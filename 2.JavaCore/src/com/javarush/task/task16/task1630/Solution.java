package com.javarush.task.task16.task1630;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    public static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    static {
        try {
            firstFileName = rd.readLine();
            secondFileName = rd.readLine();
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException, IOException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent() throws IOException;

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fullFileName;
        private String output = "";


        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fullFileName)));
                String s;
                while ((s=reader.readLine())!=null)
                    output = output + s + " ";

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void setFileName(String fullFileName) {
        this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() throws IOException {
            return output;
        }
    }
}
