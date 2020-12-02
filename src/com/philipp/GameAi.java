package com.philipp;

public class GameAi {
    private int nextMove = -1;
    private TicTacToe game ;
    private int depth;

    public GameAi(TicTacToe game, int depth) {
        this.game = game;
        this.depth = depth;
    }

    public int getNextMove() {
        getScore(depth, false);
        return nextMove;
    }

    private int getScore(int depth, boolean player) {
        if(game.isOver() || depth == 0) {
            return game.getWinner();
        }

        int currentMove = this.depth - depth + 1;
        if(player) {
            int minScore = 0x7FFFFFFF;

            for(int y = 0; y < 3; y++) {
                for(int x = 0; x < 3; x++) {
                    if(game.getField(x, y) != TicTacToe.Empty) {
                        continue;
                    }

                    game.setField(x, y, TicTacToe.Player);
                    int score = getScore(depth - 1, false);
                    game.setField(x, y, TicTacToe.Empty);

                    if(score < minScore) {
                        nextMove = x + y * 3;
                        minScore = score;
                    }
                }
            }

            return minScore * currentMove;
        }
        else {
            int maxScore = -0x7FFFFFFF;

            for(int y = 0; y < 3; y++) {
                for(int x = 0; x < 3; x++) {
                    if(game.getField(x, y) != TicTacToe.Empty) {
                        continue;
                    }

                    game.setField(x, y, TicTacToe.Ai);
                    int score = getScore(depth - 1, true);
                    game.setField(x, y, TicTacToe.Empty);

                    if(score > maxScore) {
                        nextMove = x + y * 3;
                        maxScore = score;
                    }
                }
            }

            return maxScore * currentMove;
        }
    }
}
