//package com.caffeaulait.problemset;
//
//import javafx.util.Pair;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class _1912_DesignMovieRentalSystem {
//
//    class Entry {
//        int price, shop, movie;
//
//        public Entry(int price, int shop, int movie) {
//            this.price = price;
//            this.shop = shop;
//            this.movie = movie;
//        }
//    }
//
//    class MovieRentingSystem {
//        Map<Integer, TreeSet<Entry>> unrented = new HashMap<>();  //movie, entries
//        Map<Pair<Integer, Integer>, Integer> price = new HashMap<>();   //(shop, movie) price
//        TreeSet<Entry> rented;
//        Comparator<Entry> comparator = (a, b) -> {
//            if (a.price != b.price) return a.price - b.price;
//            if (a.shop != b.shop) return a.shop - b.shop;
//            return a.movie - b.movie;
//        };
//
//        public MovieRentingSystem(int n, int[][] entries) {
//            for (int[] entry: entries) {
//                int s = entry[0], m = entry[1], p = entry[2];
//                Entry r = new Entry(p, s, m);
//                unrented.putIfAbsent(m, new TreeSet<>(comparator));
//                unrented.get(m).add(r);
//                price.put(new Pair<>(s, m), p);
//            }
//            rented = new TreeSet<>(comparator);
//        }
//
//        public List<Integer> search(int movie) {
//            if (!unrented.containsKey(movie)) return new ArrayList<>();
//            return unrented.get(movie).stream().limit(5).map(e -> e.shop).collect(Collectors.toList());
//        }
//
//        public void rent(int shop, int movie) {
//            int p = price.get(new Pair<>(shop, movie));
//            Entry r = new Entry(p, shop, movie);
//            unrented.get(movie).remove(r);
//            rented.add(r);
//        }
//
//        public void drop(int shop, int movie) {
//            int p = price.get(new Pair<>(shop, movie));
//            Entry r = new Entry(p, shop, movie);
//            unrented.get(movie).add(r);
//            rented.remove(r);
//        }
//
//        public List<List<Integer>> report() {
//            return rented.stream().limit(5).map(e -> Arrays.asList(e.shop, e.movie)).collect(Collectors.toList());
//        }
//    }
//}
