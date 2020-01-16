package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    protected int score = 0;
    protected int maxTile = 2;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] fieldToSave = new Tile[tiles.length][tiles[0].length];
        isSaveNeeded = false;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                fieldToSave[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(fieldToSave);
        int scoreToSave = score;
        previousScores.push(scoreToSave);
    }

    public void rollback() {
        if(!previousScores.isEmpty() && !previousStates.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty())
            return true;

        for (Tile[] gameTile : gameTiles) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTile[j].value == gameTile[j - 1].value)
                    return true;
            }
        }

        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 1; i < gameTiles.length; i++) {
                if (gameTiles[i][j].value == gameTiles[i - 1][j].value)
                    return true;
            }
        }

        return false;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i ++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].isEmpty()) emptyTiles.add(gameTiles[i][j]);
            }
        }

        return emptyTiles;
    }

    public void addTile() {
        List<Tile> tiles = getEmptyTiles();
        if (tiles.size() == 0) {
            return;
        } else {
            int randomTile = (int) (Math.random() * tiles.size());
            tiles.get(randomTile).value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    protected void resetGameTiles() {
        maxTile = 0;
        score = 0;
        for (int i = 0; i < FIELD_WIDTH; i ++) {
            for (int j = 0; j < FIELD_WIDTH; j ++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    public void randomMove() {
        switch ((int) (Math.random() * 3)) {
            case(0): {
                left();
                break;
            }
            case(1): {
                right();
                break;
            }
            case(2): {
                up();
                break;
            }
            case(3): {
                down();
                break;
            }
        }
    }

    public boolean hasBoardChanged() {
        Tile[][] lastBoard = previousStates.peek();

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (lastBoard[i][j].value != gameTiles[i][j].value) {
                    return true;
                }
            }
        }

        return false;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        if (!hasBoardChanged()) {
            rollback();
            return new MoveEfficiency(-1, 0, move);
        }

        int emptyTilesCount = getEmptyTiles().size();

        MoveEfficiency moveEfficiency = new MoveEfficiency(emptyTilesCount, score, move);
        rollback();

        return moveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::left));
        queue.peek().getMove().move();
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean moved = false;
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].value == 0 && i < tiles.length - 1 && tiles[i + 1].value != 0) {
                Tile temp = tiles[i];
                tiles[i] = tiles[i + 1];
                tiles[i + 1] = temp;
                i = -1;
                moved = true;
            }
        }
        return moved;

    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean moved = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value != 0 && (tiles[i].value == tiles[i + 1].value)) {
                if (tiles[i].value + tiles[i + 1].value > maxTile) {
                    maxTile = tiles[i].value + tiles[i + 1].value;
                }
                tiles[i].value = tiles[i].value + tiles[i + 1].value;
                score += tiles[i].value;
                tiles[i + 1].value = 0;
                moved = true;
                compressTiles(tiles);
            }
        }
        return moved;

    }

    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean moved = false;
        for (int i = 0; i < FIELD_WIDTH; i ++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                moved = true;
            }
        }
        isSaveNeeded = true;
        if (moved) addTile();
    }

    public void right() {
        saveState(gameTiles);
        gameTiles = turnToRight(turnToRight(gameTiles));
        left();
        gameTiles = turnToRight(turnToRight(gameTiles));
    }

    public void up() {
        saveState(gameTiles);
        gameTiles = turnToRight(turnToRight(turnToRight(gameTiles)));
        left();
        gameTiles = turnToRight(gameTiles);
    }

    public void down() {
        saveState(gameTiles);
        gameTiles = turnToRight(gameTiles);
        left();
        gameTiles = turnToRight(turnToRight(turnToRight(gameTiles)));
    }

    public Tile[][] turnToRight(Tile[][] array) {
        Tile[][] resultArray = new Tile[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                resultArray[j][array.length - i - 1] = array[i][j];
            }
        }
        return resultArray;
    }
}
