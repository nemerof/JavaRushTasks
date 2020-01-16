//УСЛОВНО РАБОЧЕЕ

/*
Округление чисел
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader rd1 = new BufferedReader(new InputStreamReader(new FileInputStream(rd.readLine())));
        FileOutputStream outputStream = new FileOutputStream(rd.readLine());
        String line;
        ArrayList<Integer> list = new ArrayList<>();

        while ((line = rd1.readLine()) != null) {
            double doubleLine = Double.parseDouble(line);
            if (doubleLine < 0) {
                if (doubleLine - (int) doubleLine == 0.5 || (doubleLine - (int) doubleLine > -0.5 && doubleLine - (int) doubleLine < 0)) {
                    list.add((int) doubleLine);
                } else if (doubleLine - (int) doubleLine > -1 && doubleLine - (int) doubleLine < -0.5) {
                    int addInt = (int) --doubleLine;
                    list.add(addInt);
                } else {
                    list.add((int) doubleLine);
                }
            } else if (doubleLine > 0) {
                if (doubleLine - (int) doubleLine == 0.5 || doubleLine - (int) doubleLine > 0.5) {
                    int addInt = (int) ++doubleLine;
                    list.add(addInt);
                } else if (doubleLine - (int) doubleLine < 0.5) {
                    list.add((int) doubleLine);
                } else {
                    list.add((int) doubleLine);
                }
            } else {
                list.add(0);
            }
        }

        for (int elem : list) {
            outputStream.write(String.valueOf(elem).getBytes());
            outputStream.write(' ');
        }
        rd.close();
        rd1.close();
        outputStream.close();

    }
}
