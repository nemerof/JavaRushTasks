import com.javarush.task.task39.task3913.Event;
import com.javarush.task.task39.task3913.Status;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static final String SDF_PATTERN = "dd.MM.yyyy HH:mm:ss";
    private SimpleDateFormat sdf = new SimpleDateFormat();
    private Path logDir = Paths.get("D:\\pojectJava\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task39\\task3913\\logs\\");

    public static void main(String[] args) {
        System.out.println(new Main().getIPsForEvent(Event.DONE_TASK,null, null));
    }

    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> set = new HashSet<>();

        try {
            for (LogStorage storage : new LogReader().run()) {
                if (after == null && before == null) {
                    set.add(storage.id);
                } else if (after != null && before != null) {
                    if (storage.date.before(before) && storage.date.after(after)) {
                        set.add(storage.id);
                    }
                } else if (after != null) {
                    if (storage.date.after(after)) {
                        set.add(storage.id);
                    }
                } else {
                    if (storage.date.before(before)) {
                        set.add(storage.id);
                    }
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return set;
    }

    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> set = new HashSet<>();

        try {
            for (LogStorage storage : new LogReader().run()) {
                if (storage.name.equals(user)) {
                    if (after == null && before == null) {
                        set.add(storage.id);
                    } else if (after != null && before != null) {
                        if (storage.date.before(before) && storage.date.after(after)) {
                            set.add(storage.id);
                        }
                    } else if (after != null) {
                        if (storage.date.after(after)) {
                            set.add(storage.id);
                        }
                    } else {
                        if (storage.date.before(before)) {
                            set.add(storage.id);
                        }
                    }
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return set;
    }

    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> set = new HashSet<>();

        try {
            for (LogStorage storage : new LogReader().run()) {
                if (Status.valueOf(storage.status).equals(status)) {
                    if (after == null && before == null) {
                        set.add(storage.id);
                    } else if (after != null && before != null) {
                        if (storage.date.before(before) && storage.date.after(after)) {
                            set.add(storage.id);
                        }
                    } else if (after != null) {
                        if (storage.date.after(after)) {
                            set.add(storage.id);
                        }
                    } else {
                        if (storage.date.before(before)) {
                            set.add(storage.id);
                        }
                    }
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return set;
    }

    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> set = new HashSet<>();

        try {
            for (LogStorage storage : new LogReader().run()) {
                if (Event.valueOf(storage.event).equals(event)) {
                    if (after == null && before == null) {
                        set.add(storage.id);
                    } else if (after != null && before != null) {
                        if (storage.date.before(before) && storage.date.after(after)) {
                            set.add(storage.id);
                        }
                    } else if (after != null) {
                        if (storage.date.after(after)) {
                            set.add(storage.id);
                        }
                    } else {
                        if (storage.date.before(before)) {
                            set.add(storage.id);
                        }
                    }
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return set;
    }

    public static class LogStorage {
        public String id;
        public String name;
        public Date date;
        public String event;
        public String status;

        public LogStorage(String id, String name, Date date, String event, String status) {
            this.id = id;
            this.name = name;
            this.date = date;
            this.event = event;
            this.status = status;
        }
    }

    public class LogReader {
        public Set<LogStorage> run() throws IOException, ParseException {
            Set<LogStorage> storages = new HashSet<>();

            if (logDir.toFile().listFiles() != null) {
                for (File file : logDir.toFile().listFiles()) {
                    BufferedReader rd = new BufferedReader(new FileReader(file));
                    while (rd.ready()) {
                        String line = rd.readLine().replaceAll("\t", " ");
                        String[] splitLine = line.split(" ");
                        String event = null;
                        String status = null;

                        StringBuilder forDate = new StringBuilder();
                        StringBuilder forName = new StringBuilder();
                        for (int i = 1; i < splitLine.length; i ++) {
                            if (splitLine[i].toCharArray()[0] <= 57 && splitLine[i].toCharArray()[0] >= 48) {
                                forDate.append(splitLine[i]).append(" ").append(splitLine[i + 1]);
                                for (int j = 1; j < i; j ++) {
                                    forName.append(splitLine[j]).append(" ");
                                }
                                event = splitLine[i+2];
                                try {
                                    status = splitLine[i+3];
                                } catch (Exception e) {
                                    //skip
                                }
                                break;
                            }
                        }

                        String id = splitLine[0];
                        String name = forName.toString().trim();
                        Date date = sdf.parse(forDate.toString());
                        LogStorage storage = new LogStorage(id, name, date, event, status);
                        storages.add(storage);
                    }
                }
            }
            return storages;
        }
    }
}
