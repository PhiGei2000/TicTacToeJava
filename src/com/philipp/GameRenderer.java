package com.philipp;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

public class GameRenderer {
    private int size;
    private TicTacToe game;
    private float fieldSize;

    GameRenderer(int size, TicTacToe game) {
        this.size = size;
        this.game = game;
        this.fieldSize = size / 3.0f;

        StdDraw.setCanvasSize(size, size);
        StdDraw.setScale(0, size);
    }

    public void render() {
        drawBackground();

        for (int y = 0; y < 3; y++) {
            for(int x = 0; x < 3; x++) {
                int field = game.getField(x, y);
                if(field == -1) {
                    drawCross(x, y);
                }
                else if(field == 1) {
                    drawCircle(x, y);
                }
            }
        }
    }

    private void drawBackground() {
        StdDraw.setPenColor(Color.black);
        StdDraw.setPenRadius(0.01);
        for (int i = 1; i <= 2; i++) {
            StdDraw.line(0, i * fieldSize, size, i * fieldSize);
            StdDraw.line(i * fieldSize, 0, i * fieldSize, size);
        }
    }

    private void drawCross(int x, int y) {
        StdDraw.setPenRadius(0.04);
        StdDraw.setPenColor(Color.RED);

        float x0 = (x + 0.2f) * fieldSize;
        float x1 = (x + 0.8f) * fieldSize;

        float y0 = (y + 0.2f) * fieldSize;
        float y1 = (y + 0.8f) * fieldSize;

        StdDraw.line(x0, y0, x1, y1);
        StdDraw.line(x0, y1, x1, y0);
    }

    private void drawCircle(int x, int y) {
        StdDraw.setPenRadius(0.04);
        StdDraw.setPenColor(Color.BLUE);

        float x0 = (x + 0.5f) * fieldSize;
        float y0 = (y + 0.5f) * fieldSize;

        StdDraw.circle(x0, y0, 0.35f * fieldSize);
    }

    public int getField(float mousePos) {
        return (int)Math.floor(mousePos / fieldSize);
    }
}
