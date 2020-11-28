package com.philipp;

public class TicTacToe {
    private int[] field = new int[9];

    public int getField(int x, int y) {
        return field[x + 3 * y];
    }

    public void setField(int x, int y, int value) {
        this.field[x + 3 * y] = value;
    }

    public static final int Player = -1;
    public static final int Ai = 1;
    public static final int Empty = 0;

    public int getWinner() {
        for (int i = 0; i < 3; i++) {
            if (field[i] == field[i + 3] && field[i + 3] == field[i + 6] && field[i] != 0) {
                return field[i];
            }
            else if (field[i * 3] == field[i * 3 + 1] && field[i * 3 + 1] == field[i * 3 + 2] && field[i * 3] != 0) {
                return field[i * 3];
            }
        }

        if (field[0] == field[4] && field[4] == field[8] && field[0] != 0) {
            return field[0];
        }
        else if (field[2] == field[4] && field[4] == field[6] && field[2] != 0) {
            return field[2];
        }

        return 0;
    }

    public boolean isOver() {
        if(getWinner() != 0){
            return true;
        }

        for (int i = 0; i < 9; i++) {
            if (field[i] == 0) {
                return false;
            }
        }

        return true;
    }
}
