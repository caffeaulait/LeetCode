package com.caffeaulait.problemset;

import java.util.*;

public class _0355_DesginTwitter {
    /**
     * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
     *
     * postTweet(userId, tweetId): Compose a new tweet.
     * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     * follow(followerId, followeeId): Follower follows a followee.
     * unfollow(followerId, followeeId): Follower unfollows a followee.
     * Example:
     *
     * Twitter twitter = new Twitter();
     *
     * // User 1 posts a new tweet (id = 5).
     * twitter.postTweet(1, 5);
     *
     * // User 1's news feed should return a list with 1 tweet id -> [5].
     * twitter.getNewsFeed(1);
     *
     * // User 1 follows user 2.
     * twitter.follow(1, 2);
     *
     * // User 2 posts a new tweet (id = 6).
     * twitter.postTweet(2, 6);
     *
     * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
     * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
     * twitter.getNewsFeed(1);
     *
     * // User 1 unfollows user 2.
     * twitter.unfollow(1, 2);
     *
     * // User 1's news feed should return a list with 1 tweet id -> [5],
     * // since user 1 is no longer following user 2.
     * twitter.getNewsFeed(1);
     */

    private static int timeStamp = 0;

    private Map<Integer, User> map;

    class Tweet{
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id){
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }

    class User{
        public int id;
        public Set<Integer> followed;
        public Tweet tweet_head;

        public User(int id){
            this.id = id;
            followed = new HashSet<>();
            follow(id); //follow yourself first
            tweet_head = null;
        }

        public void follow(int id){
            followed.add(id);
        }

        public void unfollow(int id){
            followed.remove(id);
        }

        public void post(int id){
            Tweet t = new Tweet(id);
            t.next = tweet_head;
            tweet_head = t;
        }
    }

    /** Initialize your data structure here. */
    public _0355_DesginTwitter() {
        map = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!map.containsKey(userId)){
            User usr = new User(userId);
            map.put(userId, usr);
        }
        map.get(userId).post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        if (!map.containsKey(userId)) return list;
        Set<Integer> users = map.get(userId).followed;
        PriorityQueue<Tweet> queue = new PriorityQueue<>(users.size(), (a,b) -> (b.time - a.time));
        for (int u : users) {
            Tweet t = map.get(u).tweet_head;
            if (t!=null) queue.add(t);
        }
        int num = 0;
        while (!queue.isEmpty() && num < 10){
            Tweet t = queue.poll();
            list.add(t.id);
            num++;
            if (t.next!=null) {
                queue.add(t.next);
            }
        }
        return list;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)){
            User user = new User(followerId);
            map.put(followerId, user);
        }
        if (!map.containsKey(followeeId)){
            User user = new User(followeeId);
            map.put(followeeId, user);
        }
        map.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!map.containsKey(followerId) || (!map.containsKey(followeeId))) return;
        map.get(followerId).unfollow(followeeId);
    }
}
