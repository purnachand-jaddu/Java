package com.mentor.training.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class FiveStarSellers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPairs = scanner.nextInt();

        int threshold = 77;

        Queue<RatingObject> queue = new PriorityQueue<>(numberOfPairs, new RatingObjectComparator());

        for (int i = 0; i < numberOfPairs; i++) {
            queue.add(new RatingObject(scanner.nextDouble(), scanner.nextDouble()));
        }

        int count = 0;

        while (findRating(queue) < threshold) {
            RatingObject peekedObject = queue.poll();
            assert peekedObject != null;
            peekedObject.totalReviews++;
            peekedObject.fiveStarReviews++;
            queue.add(peekedObject);
            count++;
            for (RatingObject rating : queue) {
                System.out.print(rating.fiveStarReviews + " " + rating.totalReviews);
                System.out.println();
            }
        }

        System.out.println(count);

    }

    private static double findRating(Queue<RatingObject> queue) {

        int size = queue.size();

        double sum = 0;
        for (RatingObject ratingObject : queue) {
            sum += ratingObject.fiveStarReviews / ratingObject.totalReviews;
        }

        return sum / size * 100;
    }

    private static class RatingObjectComparator implements Comparator<RatingObject> {
        @Override
        public int compare(RatingObject firstObject, RatingObject secondObject) {
            double jumpForFirstObject = (firstObject.fiveStarReviews + 1) / (firstObject.totalReviews + 1) - firstObject.fiveStarReviews / firstObject.totalReviews;
            double jumpForSecondObject = (secondObject.fiveStarReviews + 1) / (secondObject.totalReviews + 1) - secondObject.fiveStarReviews / secondObject.totalReviews;
            if (jumpForFirstObject < jumpForSecondObject) {
                return 1;
            } else if (jumpForFirstObject > jumpForSecondObject) {
                return -1;
            }
            return 0;
        }
    }

    private static class RatingObject {
        private double fiveStarReviews;

        private double totalReviews;

        private RatingObject(double fiveStarReviews, double totalReviews) {
            this.fiveStarReviews = fiveStarReviews;
            this.totalReviews = totalReviews;
        }
    }
}
