package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.List;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;
    private int turnDelay;
    private Apple apple;
    private boolean isGameStopped;
    private static final int GOAL = 20;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        isGameStopped = false;
        score = 0;
        setScore(score);
        createNewApple();
        drawScene();
        turnDelay = 300;
        setTurnTimer(turnDelay);
    }

    private void drawScene() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if (!apple.isAlive) {
            score += 5;
            setScore(score);
            turnDelay -= 10;
            setTurnTimer(turnDelay);
            createNewApple();
        }
        if (!snake.isAlive) {
            gameOver();
        }
        if (GOAL < snake.getLength()) {
            win();
        }
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key.equals(Key.DOWN)) {
            snake.setDirection(Direction.DOWN);
        }
        if (key.equals(Key.UP)) {
            snake.setDirection(Direction.UP);
        }
        if (key.equals(Key.RIGHT)) {
            snake.setDirection(Direction.RIGHT);
        }
        if (key.equals(Key.LEFT)) {
            snake.setDirection(Direction.LEFT);
        }
        if (isGameStopped && key.equals(Key.SPACE)) {
            createGame();
        }
    }

    private void createNewApple() {
        apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
        while (snake.checkCollision(apple)) {
            apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
        }
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.YELLOW, "GAME OVER", Color.ORANGE, 75);
    }

    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.YELLOW, "YOU WIN", Color.BLUE, 90);
    }
}
