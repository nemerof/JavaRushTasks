package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    private int endX;
    private int endY;

    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> words1 = detectAllWords(crossword, "home", "same");
        for (Word elem : words1) {
            System.out.println(elem.toString());
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordsList = new ArrayList<>();
        Word word;
        Solution solution = new Solution();

        for (String elem : words) {
            char[] currentWord = elem.toCharArray();
            for (int i = 0; i < crossword.length; i ++) {
                for (int j = 0; j < crossword[i].length; j ++) {
                    if (crossword[i][j] == currentWord[0]) {
                        int startX = i;
                        int startY = j;
                        if (solution.checkE(startX, startY, currentWord, crossword) ||
                                solution.checkS(startX, startY, currentWord, crossword) ||
                                solution.checkW(startX, startY, currentWord, crossword) ||
                                solution.checkN(startX, startY, currentWord, crossword) ||
                                solution.checkNE(startX, startY, currentWord, crossword) ||
                                solution.checkNW(startX, startY, currentWord, crossword) ||
                                solution.checkSE(startX, startY, currentWord, crossword) ||
                                solution.checkSW(startX, startY, currentWord, crossword)) {
                            word = new Word(elem);
                            word.setStartPoint(startY, startX);
                            word.setEndPoint(solution.endX, solution.endY);
                            wordsList.add(word);
                        }
                    }
                }
            }
        }

        return wordsList;
    }

    public boolean checkW(int startX, int startY, char[] currentWord, int[][] crossword) {
        boolean isPossible = true;

        try {
            for (int i = 1; i < currentWord.length; i ++) {
                startY --;
                if (crossword[startX][startY] == currentWord[i]) {
                    isPossible = true;
                    endX = startY;
                    endY = startX;
                } else {
                    isPossible = false;
                    break;
                }
            }


        } catch (Exception e) {
            return false;
        }

        return isPossible;
    }

    public boolean checkS(int startX, int startY, char[] currentWord, int[][] crossword) {
        boolean isPossible = true;

        try {
            for (int i = 1; i < currentWord.length; i ++) {
                startX ++;
                if (crossword[startX][startY] == currentWord[i]) {
                    isPossible = true;
                    endX = startY;
                    endY = startX;
                } else {
                    isPossible = false;
                    break;
                }
            }


        } catch (Exception e) {
            return false;
        }

        return isPossible;
    }

    public boolean checkE(int startX, int startY, char[] currentWord, int[][] crossword) {
        boolean isPossible = true;

        try {
            for (int i = 1; i < currentWord.length; i ++) {
                startY ++;
                if (crossword[startX][startY] == currentWord[i]) {
                    isPossible = true;
                    endX = startY;
                    endY = startX;
                } else {
                    isPossible = false;
                    break;
                }
            }


        } catch (Exception e) {
            return false;
        }

        return isPossible;
    }

    public boolean checkN(int startX, int startY, char[] currentWord, int[][] crossword) {
        boolean isPossible = true;

        try {
            for (int i = 1; i < currentWord.length; i ++) {
                startX --;
                if (crossword[startX][startY] == currentWord[i]) {
                    isPossible = true;
                    endX = startY;
                    endY = startX;
                } else {
                    isPossible = false;
                    break;
                }
            }


        } catch (Exception e) {
            return false;
        }

        return isPossible;
    }

    public boolean checkNE(int startX, int startY, char[] currentWord, int[][] crossword) {
        boolean isPossible = true;

        try {
            for (int i = 1; i < currentWord.length; i ++) {
                startX --;
                startY ++;
                if (crossword[startX][startY] == currentWord[i]) {
                    isPossible = true;
                    endX = startY;
                    endY = startX;
                } else {
                    isPossible = false;
                    break;
                }
            }


        } catch (Exception e) {
            return false;
        }

        return isPossible;
    }

    public boolean checkNW(int startX, int startY, char[] currentWord, int[][] crossword) {
        boolean isPossible = true;

        try {
            for (int i = 1; i < currentWord.length; i ++) {
                startX --;
                startY --;
                if (crossword[startX][startY] == currentWord[i]) {
                    isPossible = true;
                    endX = startY;
                    endY = startX;
                } else {
                    isPossible = false;
                    break;
                }
            }


        } catch (Exception e) {
            return false;
        }

        return isPossible;
    }

    public boolean checkSE(int startX, int startY, char[] currentWord, int[][] crossword) {
        boolean isPossible = true;

        try {
            for (int i = 1; i < currentWord.length; i ++) {
                startX ++;
                startY ++;
                if (crossword[startX][startY] == currentWord[i]) {
                    isPossible = true;
                    endX = startY;
                    endY = startX;
                } else {
                    isPossible = false;
                    break;
                }
            }


        } catch (Exception e) {
            return false;
        }

        return isPossible;
    }

    public boolean checkSW(int startX, int startY, char[] currentWord, int[][] crossword) {
        boolean isPossible = true;

        try {
            for (int i = 1; i < currentWord.length; i ++) {
                startX ++;
                startY --;
                if (crossword[startX][startY] == currentWord[i]) {
                    isPossible = true;
                    endX = startY;
                    endY = startX;
                } else {
                    isPossible = false;
                    break;
                }
            }


        } catch (Exception e) {
            return false;
        }

        return isPossible;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
