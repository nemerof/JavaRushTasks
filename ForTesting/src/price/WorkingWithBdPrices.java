package price;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkingWithBdPrices {
    public static void main(String[] args) throws IOException {
        args = new String[] {"-u", "19847", "asdaskjфыд1флдыдфлыо", "121", "12"};
        //args = new String[] {"-d", "19847"};
        // -u id name price quanity
        // -d id
        /* id = 8
            name = 30
            price = 8
            quantity = 4
         */
        // file = id productName price quantity

        BufferedReader rd = new BufferedReader(new FileReader("D:\\pojectJava\\JavaRushTasks\\ForTesting\\src\\price\\test.txt"));

        if (args.length != 0) {
            if (args[0].equals("-d")) {
                List<String> list = new ArrayList<>();
                while (rd.ready()) {
                    String line = rd.readLine();
                    String id = line.substring(0, 8);
                    if (!(Integer.parseInt(id.trim()) == Integer.parseInt(args[1]))) {
                        list.add(line);
                    }
                }
                FileWriter fw = new FileWriter("D:\\pojectJava\\JavaRushTasks\\ForTesting\\src\\price\\test.txt", false);
                for (String line : list) {
                    fw.write(line);
                    fw.write("\n");
                }
                fw.close();
            }
            else if (args[0].equals("-u")) {
                List<String> list = new ArrayList<>();
                String neededLine = "";
                int count = 0;
                int result = 0;
                while (rd.ready()) {
                    String line = rd.readLine();
                    String id = line.substring(0, 8);
                    if (Integer.parseInt(id.trim()) == Integer.parseInt(args[1])) {
                        result = count;
                    }
                    list.add(line);
                    count ++;
                }
                list.forEach(System.out::println);
                StringBuilder sb = new StringBuilder(list.get(result).substring(0, 8));
                sb.append(padRight(args[2],30));
                sb.append(padRight(args[3],8));
                sb.append(padRight(args[4],4));
                list.set(result, sb.toString());
                list.forEach(System.out::println);
                FileWriter fw = new FileWriter("D:\\pojectJava\\JavaRushTasks\\ForTesting\\src\\price\\test.txt", false);
                for (String line : list) {
                    fw.write(line);
                    fw.write("\n");
                }
                fw.close();
            }
        }

        rd.close();
    }

    private static String padRight(String input, int len) {
        if (input.length() < len) {
            return String.format("%1$-" + len + "s", input);
        } else {
            return input.substring(0, len);
        }
    }
}
