package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution("c:/qwe/input.txt");
        solution.writeObject("Hi!\r\n");
        ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("c:/qwe/output.txt"));
        oos.writeObject(solution);

        ObjectInputStream ois = new ObjectInputStream((new FileInputStream("c:/qwe/output.txt")));
        Solution solution2 = (Solution) ois.readObject();
        solution2.writeObject("Hi again!");
    }
}
