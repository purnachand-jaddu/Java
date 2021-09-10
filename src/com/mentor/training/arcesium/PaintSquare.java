package com.mentor.training.arcesium;

public class PaintSquare {

    public static void main(String[] args) {
        int[] initialState = new int[]{0,0,0,0,1};
        System.out.println(calculateMinMoves(initialState));
    }

    private static int calculateMinMoves(int[] initialState) {
        int length = initialState.length;
        int[] minMovesPerI = new int[length];
        if (length <= 1) {
            return 0;
        }
        minMovesPerI[0] = 0;
        minMovesPerI[1] = initialState[1] == initialState[0] ? 1 : 0;
        for (int i = 2; i < length; i++) {
            minMovesPerI[i] = Integer.MAX_VALUE;
            if (initialState[i] == initialState[i - 1]) {
                minMovesPerI[i] = Integer.min(minMovesPerI[i], minMovesPerI[i - 2] + 1);
            } else {
                minMovesPerI[i] = Integer.min(minMovesPerI[i - 1], minMovesPerI[i]);
            }
        }
        return minMovesPerI[length - 1];
    }

}
