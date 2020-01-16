package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private List<GameObject> snakeParts = new ArrayList<>();
    private Direction direction = Direction.LEFT;
    public boolean isAlive = true;

    public int getLength() {
        return snakeParts.size();
    }

    public void setDirection(Direction direction) {
        if ((direction == Direction.LEFT && snakeParts.get(0).y == snakeParts.get(1).y) ||
                (direction == Direction.RIGHT && snakeParts.get(0).y == snakeParts.get(1).y) ||
                (direction == Direction.UP && snakeParts.get(0).x == snakeParts.get(1).x) ||
                (direction == Direction.DOWN && snakeParts.get(0).x == snakeParts.get(1).x)) return;
        if (Math.abs(this.direction.ordinal() - direction.ordinal()) == 2) return;
        this.direction = direction;
    }

    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    public void draw(Game game) {
        for (int i = 0, size = this.snakeParts.size(); i < size; i ++) {
            int x = snakeParts.get(i).x;
            int y = snakeParts.get(i).y;
            if (i == 0) {
                game.setCellValueEx(x, y, Color.NONE, HEAD_SIGN, isAlive ? Color.BLACK : Color.RED, 75);
            } else {
                game.setCellValueEx(x, y, Color.NONE, BODY_SIGN, isAlive ? Color.BLACK : Color.RED, 75);
            }
        }
    }




    public void move(Apple apple) {
        GameObject gameObject = createNewHead();

        if (gameObject.x < 0 || gameObject.x > SnakeGame.WIDTH - 1 || gameObject.y < 0 || gameObject.y > SnakeGame.HEIGHT - 1) {
            isAlive = false;
        } else {
            if (apple.x == gameObject.x && apple.y == gameObject.y) {
                apple.isAlive = false;
                /* GameObject last = snakeParts.get(snakeParts.size() - 1);
                GameObject preLast = snakeParts.get(snakeParts.size() - 2);
                if (last.y == preLast.y) {
                    snakeParts.add(new GameObject(last.x - 1, last.y));
                } */
                snakeParts.add(0, gameObject);
            } else {
                if (checkCollision(gameObject)) {
                    isAlive = false;
                    return;
                }
                removeTail();
                snakeParts.add(0, gameObject);
            }

        }
    }

    public GameObject createNewHead() {
        GameObject head = snakeParts.get(0);
        GameObject result = null;
        if (direction == Direction.LEFT) {
            result = new GameObject(head.x - 1, head.y);
        }
        if (direction == Direction.RIGHT) {
            result = new GameObject(head.x + 1, head.y);
        }
        if (direction == Direction.DOWN) {
            result = new GameObject(head.x, head.y + 1);
        }
        if (direction == Direction.UP) {
            result = new GameObject(head.x, head.y - 1);
        }

        return result;
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public boolean checkCollision(GameObject object) {
        boolean isBumped = false;
        for (GameObject gameObject : snakeParts) {
            if (object.x == gameObject.x && object.y == gameObject.y) {
                isBumped = true;
            }
        }

        return isBumped;
    }
}
