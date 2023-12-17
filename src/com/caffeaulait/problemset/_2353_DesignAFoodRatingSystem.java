package com.caffeaulait.problemset;

import java.util.*;

public class _2353_DesignAFoodRatingSystem {
    /**
     * Design a food rating system that can do the following:
     *
     * Modify the rating of a food item listed in the system.
     * Return the highest-rated food item for a type of cuisine in the system.
     * Implement the FoodRatings class:
     *
     * FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the system. The food items are described by foods, cuisines and ratings, all of which have a length of n.
     * foods[i] is the name of the ith food,
     * cuisines[i] is the type of cuisine of the ith food, and
     * ratings[i] is the initial rating of the ith food.
     * void changeRating(String food, int newRating) Changes the rating of the food item with the name food.
     * String highestRated(String cuisine) Returns the name of the food item that has the highest rating for the given type of cuisine. If there is a tie, return the item with the lexicographically smaller name.
     * Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.
     *
     */

    class FoodRatings {

        Map<String, PriorityQueue<Food>> map = new HashMap<>();

        Map<String, Food> nameMap = new HashMap<>();


        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                String food = foods[i];
                String cuisine = cuisines[i];
                int rating = ratings[i];
                Food f = new Food(food, rating, cuisine);
                nameMap.put(food, f);
                if (!map.containsKey(cuisine)) {
                    map.put(cuisine, new PriorityQueue<>((o1, o2) -> {
                        int result = o2.rating - o1.rating;
                        if (result != 0) return result;
                        return o1.name.compareTo(o2.name);
                    }));
                }
                map.get(cuisine).offer(f);
            }
        }

        public void changeRating(String food, int newRating) {
            Food f = nameMap.get(food);
            map.get(f.cuisine).remove(f);
            f.rating = newRating;
            map.get(f.cuisine).offer(f);
        }

        public String highestRated(String cuisine) {
            return map.get(cuisine).peek().name;
        }


        class Food {
            String name;
            int rating;
            String cuisine;

            public Food(String name, int rating, String cuisine) {
                this.name = name;
                this.rating = rating;
                this.cuisine = cuisine;
            }
        }
    }
}
