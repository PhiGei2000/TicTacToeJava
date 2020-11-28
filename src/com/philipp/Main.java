package com.philipp;

import edu.princeton.cs.introcs.StdDraw;

public class Main {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        GameRenderer renderer = new GameRenderer(512, game);
        GameAi ai = new GameAi(game, 8);
        boolean mouseDown = false;
        float mouseX, mouseY;
        boolean playerActive = true;

        while (game.getWinner() == 0) {
            if (playerActive) {
                if (StdDraw.isMousePressed() && !mouseDown) {
                    mouseDown = true;
                }
                else if (!StdDraw.isMousePressed() && mouseDown) {
                    mouseX = (float) StdDraw.mouseX();
                    mouseY = (float) StdDraw.mouseY();
                    mouseDown = false;

                    int x = renderer.getField(mouseX);
                    int y = renderer.getField(mouseY);
                    game.setField(x, y, TicTacToe.Player);
                    playerActive = false;
                }
            }
            else {
                int move = ai.getNextMove();
                game.setField(move % 3, move / 3,TicTacToe.Ai);
                playerActive = true;
            }

            renderer.render();
        }
    }
}
