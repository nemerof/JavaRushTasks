package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private int countMinesOnField;
    private boolean isMine;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private int countFlags;
    private boolean isGameStopped;
    private int countClosedTiles = SIDE * SIDE;
    private int score;

    private GameObject[][] gameField = new GameObject[SIDE][SIDE];

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) {
            restart();
        }
        else {
            openTile(x, y);
        }
    }

    private void createGame() {
        for (int i = 0; i < gameField.length; i ++) {
            for (int j = 0; j < gameField[i].length ; j ++) {
                if (getRandomNumber(10) == 1) {
                    isMine = true;
                    countMinesOnField++;
                }
                gameField[i][j] = new GameObject(j, i, isMine);
                setCellValue(i, j, "");
                setCellColor(i, j, Color.ORANGE);
                isMine = false;
            }
        }

        countFlags = countMinesOnField;
        countMineNeighbors();
    }

    private ArrayList<GameObject> getNeighbors(GameObject go) {
        ArrayList<GameObject> testList = new ArrayList<GameObject>();

        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (go != gameField[i][j] && Math.abs(go.x - gameField[i][j].x) < 2 && Math.abs(go.y - gameField[i][j].y) < 2) {
                    testList.add(gameField[i][j]);
                }
            }
        }

        return testList;
    }

    private void countMineNeighbors() {
        ArrayList<GameObject> testList = new ArrayList<GameObject>();

        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (!gameField[i][j].isMine) {
                    testList = getNeighbors(gameField[i][j]);
                    for (GameObject go : testList) {
                        if (go.isMine) {
                            gameField[i][j].countMineNeighbors++;
                        }
                    }
                }
            }
        }
    }

    /*private void openTile(int x, int y){
        if (gameField[y][x].isOpen || gameField[y][x].isFlag || isGameStopped){

        } else if(gameField[y][x].isMine){
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
        }
        else {
            gameField[y][x].isOpen=true;
            countClosedTiles--;
            setCellColor(x,y, Color.GREEN);
            score += 5;
            boolean notZero = gameField[x][y].countMineNeighbors!=0;
            if(notZero){
                setCellNumber(x,y,gameField[x][y].countMineNeighbors);
            }
            else {
                ArrayList<GameObject> list3 = new ArrayList<GameObject>();
                setCellValue(x,y,"");
                list3=getNeighbors(gameField[y][x]);
                for(int i=0; i<list3.size();i++){
                    int Xx=list3.get(i).x;
                    int Yy=list3.get(i).y;
                    if(!list3.get(i).isOpen){
                        openTile(Xx,Yy);
                    }
                }
            }
        }

        if (countClosedTiles == countMinesOnField) {
            win();
        }

        setScore(score);
    } */

    private void openTile(int x, int y){
        if(gameField[y][x].isFlag || isGameStopped || gameField[y][x].isOpen){
            return;
        }
        if(gameField[y][x].isMine){
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
            gameField[y][x].isOpen = true;
            return;
        } else {
            countClosedTiles = countClosedTiles - 1;
            gameField[y][x].isOpen = true;
            score += 5;
            setScore(score);
            setCellColor(x, y, Color.GREEN);
            if(gameField[y][x].countMineNeighbors != 0){
                setCellNumber(x, y, gameField[y][x].countMineNeighbors);
            } else {
                setCellValue(x, y, "");
                List<GameObject> list = getNeighbors(gameField[y][x]);
                for(GameObject object: list){
                    if(!object.isOpen & !object.isMine){
                        openTile(object.x, object.y);
                    }
                }
            }
        }
        if(countClosedTiles == countMinesOnField){
            win();
        }
    }

    private void markTile(int x, int y) {
        if (isGameStopped){
            if (gameField[x][y].isOpen || (countFlags == 0 && !gameField[x][y].isFlag)) {
            } else if (!gameField[x][y].isFlag) {
                gameField[x][y].isFlag = true;
                countFlags--;
                setCellValue(x, y, FLAG);
                setCellColor(x, y, Color.YELLOW);
            } else if (gameField[x][y].isFlag) {
                gameField[x][y].isFlag = false;
                countFlags++;
                setCellValue(x, y, "");
                setCellColor(x, y, Color.ORANGE);
            }
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    private void gameOver() {
        showAllMines();
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "Hahaha, lox", Color.WHITE, 40);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "WIN", Color.WHITE, 40);
    }

    private void restart() {
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        countMinesOnField = 0;
        setScore(score);
        createGame();
    }

    private void showAllMines() {
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (gameField[j][i].isMine) {
                    setCellValueEx(i, j, Color.RED, MINE);
                }
            }
        }
    }
}
