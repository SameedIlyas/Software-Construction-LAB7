/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extract {

    public static Timespan getTimespan(List<Tweet> tweets) {
        if (tweets.isEmpty()) {
            throw new IllegalArgumentException("Tweet list cannot be empty");
        }

        Instant start = tweets.get(0).getTimestamp();
        Instant end = tweets.get(0).getTimestamp();
        
        for (Tweet tweet : tweets) {
            if (tweet.getTimestamp().isBefore(start)) {
                start = tweet.getTimestamp();
            }
            if (tweet.getTimestamp().isAfter(end)) {
                end = tweet.getTimestamp();
            }
        }
        
        return new Timespan(start, end);
    }

    public static Set<String> getMentionedUsers(List<Tweet> tweets) {
        Set<String> users = new HashSet<>();
        // Regex to match usernames preceded by '@' and followed by a non-word character or end of string
        Pattern pattern = Pattern.compile("@(\\w+)");
        
        for (Tweet tweet : tweets) {
            String text = tweet.getText();
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                String username = matcher.group(1).toLowerCase(); // Group 1 is the username without '@'
                users.add(username);
            }
        }
        return users;
    }
}

