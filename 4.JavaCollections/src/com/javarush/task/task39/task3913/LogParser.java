package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    List<MyLog> logs;
    Path logDir;
    public LogParser(Path logDir) {
        this.logDir = logDir;
        logs = getLogs();
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<java.lang.String> getUniqueIPs(Date after, Date before) {
        Set<java.lang.String> ipSet = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            ipSet.add(log.ip);
        return ipSet;
    }

    @Override
    public Set<java.lang.String> getIPsForUser(java.lang.String user, Date after, Date before) {
        Set<java.lang.String> ipSet = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            if (log.userName.equals(user))
                ipSet.add(log.ip);
        return ipSet;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<java.lang.String> ipSet = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            if (log.event.equals(event))
                ipSet.add(log.ip);
        return ipSet;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<java.lang.String> ipSet = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            if (log.status.equals(status))
                ipSet.add(log.ip);
        return ipSet;
    }

    private List<MyLog> getLogsByDate (Date after, Date before) {
        List<MyLog> logsList = new ArrayList<>();
        for (MyLog log : logs) {
            if (after != null && before != null) {
                if (log.date.getTime() > after.getTime() && log.date.getTime() < before.getTime())
                    logsList.add(log);
            }
            else if (after == null && before != null) {
                if (log.date.getTime() < before.getTime())
                    logsList.add(log);
            }
            else if (after != null && before == null) {
                if (log.date.getTime() > after.getTime())
                    logsList.add(log);
            }
            else
                logsList.add(log);
        }
        return logsList;
    }

    public ArrayList<MyLog> getLogs() {
        ArrayList<MyLog> logs = new ArrayList<>();
        for (File file : logDir.toFile().listFiles()) {
            if (file.getName().endsWith(".log")) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()) {
                        java.lang.String[] splitter = reader.readLine().split("\\t");
                        java.lang.String ip = splitter[0];
                        java.lang.String userName = "";
                        try {
                            userName = splitter[1];
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                        Date time = format.parse(splitter[2]);
                        int taskNumber;
                        Event event;
                        java.lang.String[] events = splitter[3].split(" ");
                        if (events.length == 2) {
                            event = getEventFromString(events[0]);
                            taskNumber = Integer.parseInt(events[1]);
                        }
                        else {
                            taskNumber = 0;
                            event = getEventFromString(events[0]);
                        }
                        Status status = getStatusFromString(splitter[4]);
                        logs.add(new MyLog(ip, userName, time, event, taskNumber, status));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return logs;
    }

    private Event getEventFromString(String event) {
        java.lang.String[] splitter = event.split(" ");
        switch (splitter[0]) {
            case "DONE_TASK":
                return Event.DONE_TASK;
            case "LOGIN":
                return Event.LOGIN;
            case "DOWNLOAD_PLUGIN":
                return Event.DOWNLOAD_PLUGIN;
            case "WRITE_MESSAGE":
                return Event.WRITE_MESSAGE;
            case "SOLVE_TASK":
                return Event.SOLVE_TASK;
            default:
                return null;
        }
    }

    private Status getStatusFromString(String status) {

        switch (status) {
            case "OK":
                return Status.OK;
            case "FAILED":
                return Status.FAILED;
            case "ERROR":
                return Status.ERROR;
            default:
                return null;
        }
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> users = new HashSet<>();
        for (MyLog log : getLogs())
            users.add(log.userName);
        return users;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            users.add(log.userName);
        return users.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> evetns = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            if (log.userName.equals(user))
                evetns.add(log.event);
        return evetns.size();
    }

    @Override
    public Set<java.lang.String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            if (log.ip.equals(ip))
                users.add(log.userName);
        return users;
    }

    private Set<Date> getDatesForIP(String value, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            if (log.ip.equals(value))
                dates.add(log.date);
        return dates;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getUsersByEvent(Event.LOGIN, after, before);
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getUsersByEvent(Event.DOWNLOAD_PLUGIN, after, before);
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getUsersByEvent(Event.WRITE_MESSAGE, after, before);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getUsersByEvent(Event.SOLVE_TASK, after, before);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            if (log.event.equals(Event.SOLVE_TASK) && log.taskNumber == task)
                users.add(log.userName);
        return users;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getUsersByEvent(Event.DONE_TASK, after, before);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            if (log.event.equals(Event.DONE_TASK) && log.taskNumber == task)
                users.add(log.userName);
        return users;
    }

    private Set<String> getUsersByEvent (Event event, Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            if (log.event.equals(event))
                users.add(log.userName);
        return users;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(java.lang.String user, Event event, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before)) {
            if (log.userName.equals(user) && log.event.equals(event))
                dates.add(log.date);
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before)) {
            if (log.status.equals(Status.FAILED))
                dates.add(log.date);
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before)) {
            if (log.status.equals(Status.ERROR))
                dates.add(log.date);
        }
        return dates;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(java.lang.String user, Date after, Date before) {
        List<Date> list = new ArrayList<>();
        for (MyLog log : getLogsByDate(after, before)) {
            if (log.event.equals(Event.LOGIN) && log.userName.equals(user))
                list.add(log.date);
        }
        Collections.sort(list);
        if (list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    @Override
    public Date getDateWhenUserSolvedTask(java.lang.String user, int task, Date after, Date before) {
        List<Date> list = new ArrayList<>();
        for (MyLog log : getLogsByDate(after, before)) {
            if (log.event.equals(Event.SOLVE_TASK) && log.taskNumber == task && log.userName.equals(user))
                list.add(log.date);
        }
        Collections.sort(list);
        if (list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    @Override
    public Date getDateWhenUserDoneTask(java.lang.String user, int task, Date after, Date before) {
        List<Date> list = new ArrayList<>();
        for (MyLog log : getLogsByDate(after, before))
            if (log.event.equals(Event.DONE_TASK) && log.taskNumber == task && log.userName.equals(user))
                list.add(log.date);
        Collections.sort(list);
        if (list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(java.lang.String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            if (log.event.equals(Event.WRITE_MESSAGE) && log.userName.equals(user))
                dates.add(log.date);
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(java.lang.String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            if (log.userName.equals(user) && log.event.equals(Event.DOWNLOAD_PLUGIN))
                dates.add(log.date);
        return dates;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            events.add(log.event);
        return events;
    }

    @Override
    public Set<Event> getEventsForIP(java.lang.String ip, Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            if (log.ip.equals(ip))
                events.add(log.event);
        return events;
    }

    private Set<Status> getStatusForIP(String value, Date after, Date before) {
        Set<Status> statusses = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            if (log.ip.equals(value))
                statusses.add(log.status);
        return statusses;
    }

    @Override
    public Set<Event> getEventsForUser(java.lang.String user, Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            if (log.userName.equals(user))
                events.add(log.event);
        return events;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            if (log.status.equals(Status.FAILED))
                events.add(log.event);
        return events;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (MyLog log : getLogsByDate(after, before))
            if (log.status.equals(Status.ERROR))
                events.add(log.event);
        return events;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for (MyLog log : getLogsByDate(after, before))
            if (log.taskNumber == task && log.event.equals(Event.SOLVE_TASK))
                count ++;
        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for (MyLog log : getLogsByDate(after, before))
            if (log.taskNumber == task && log.event.equals(Event.DONE_TASK))
                count ++;
        return count;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        for (MyLog log : getLogsByDate(after, before)){
            if (log.taskNumber != 0 && log.event.equals(Event.SOLVE_TASK)) {
                checkMap(map, log);
            }
        }
        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        for (MyLog log : getLogsByDate(after, before)) {
            if (log.taskNumber != 0) {
                if (log.event.equals(Event.DONE_TASK)) {
                    checkMap(map, log);
                }
            }
        }
        return map;
    }

    private void checkMap(Map<Integer, Integer> map, MyLog log) {
        if (map.get(log.taskNumber) != null) {
            int value = map.get(log.taskNumber) + 1;
            map.put(log.taskNumber, value);
        } else
            map.put(log.taskNumber, 1);
    }

    private Set<Date> getAllDates() {
        Set<Date> dates = new HashSet<>();
        for (MyLog log : getLogs())
            dates.add(log.date);
        return dates;
    }
    private  Set<Status> getAllStatus() {
        Set<Status> statuses = new HashSet<>();
        for (MyLog log : getLogs())
            statuses.add(log.status);
        return statuses;
    }

    @Override
    public Set<Object> execute(String query) {
        String param1 = "";
        String param2 = "";
        String after = "";
        String before = "";
        String value = "";
        Set<Object> set = new HashSet<>();
        if (query.contains("between")) {
            String regex = "get (?<field1>\\w+) for (?<field2>\\w+) = \"(?<value1>.*?)\" and date between \"(?<after>.*?)\" and \"(?<before>.*?)\"";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(query);
            if (matcher.find()) {
                param1 = matcher.group("field1");
                param2 = matcher.group("field2");
                value = matcher.group("value1");
                after = matcher.group("after");
                before = matcher.group("before");
            }
            return getSetByParams(param1, param2, value, after, before);
        }
        else if (query.contains("=")) {
            String regex = "get (?<field1>\\w+) for (?<field2>\\w+) = \"(?<value1>.*?)\"";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(query);
            if (matcher.find()) {
                param1 = matcher.group("field1");
                param2 = matcher.group("field2");
                value = matcher.group("value1");
            }
            return getSetByParams(param1, param2, value);
        }
        else {
            String regex = "get (?<field1>\\w+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(query);
            if (matcher.find()) {
                param1 = matcher.group("field1");
            }
            switch (param1) {
                case "ip" : return new HashSet<>(getUniqueIPs(null, null));
                case "user" : return new HashSet<>(getAllUsers());
                case "date" : return new HashSet<>(getAllDates());
                case "event" : return new HashSet<>(getAllEvents(null, null));
                case "status" : return new HashSet<>(getAllStatus());
            }
        }
        return set;
    }

    private Set<Object> getSetByParams(String field1, String field2, String value1, String after, String before) {
        Set<Object> results = new HashSet<>();
        Date dateAfter = null;
        Date dateBefore = null;
        if (!after.equals("[after]"))
            dateAfter = parseDate(after);
        if (!before.equals("[before]"))
            dateBefore = parseDate(before);
        for (MyLog log : getLogsByDate(dateAfter, dateBefore)) {
            if (value1.contains("any")
                    || field2.equals("ip") && value1.equals(log.getIp())
                    || field2.equals("user") && value1.equals(log.getUserName())
                    || field2.equals("date") && parseDate(value1).equals(log.getDate())
                    || field2.equals("event") && value1.equals(String.valueOf(log.event))
                    || field2.equals("status") && value1.equals(String.valueOf(log.status))
            ) {
                switch (field1) {
                    case "ip":
                        results.add(log.ip);
                        break;
                    case "user":
                        results.add(log.userName);
                        break;
                    case "date":
                        results.add(log.date);
                        break;
                    case "event":
                        results.add(log.event);
                        break;
                    case "status":
                        results.add(log.status);
                        break;
                }

            }
        }
        return results;
    }

    private Set<Object> getSetByParams(String field1, String field2, String value1) {
        Set<Object> results = new HashSet<>();

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(logDir, "*.log")) {
            for (Path path : directoryStream) {
                BufferedReader fileReader = new BufferedReader(new FileReader(path.toString()));
                while (fileReader.ready()) {
                    String str = fileReader.readLine();
                    Map<String, String> data = getDataFromString(str);
                    String ipFromData = data.get("ip");
                    String userFromData = data.get("user");
                    Date date = parseDate(data.get("date"));
                    String eventFromData = data.get("event");
                    String statusFromData = data.get("status");
                    //String taskFromData = data.get("task");
                    if (value1.contains("any")
                            || field2.equals("ip") && value1.equals(ipFromData)
                            || field2.equals("user") && value1.equals(userFromData)
                            || field2.equals("date") && parseDate(value1).equals(date)
                            || field2.equals("event") && value1.equals(eventFromData)
                            || field2.equals("status") && value1.equals(statusFromData)
                    ) {
                        switch (field1) {
                            case "ip" :
                                results.add(ipFromData);
                                break;
                            case "user" :
                                results.add(userFromData);
                                break;
                            case "date" :
                                results.add(date);
                                break;
                            case "event" :
                                results.add(Event.valueOf(eventFromData));
                                break;
                            case "status" :
                                results.add(Status.valueOf(statusFromData));
                                break;
                        }

                    }
                }
                fileReader.close();
                path.getFileName();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }

    private Date parseDate(String s) {
        String string = s;
        int date = Integer.parseInt(string.substring(0, string.indexOf('.')));
        string = string.substring(string.indexOf('.')+1);
        int month = Integer.parseInt(string.substring(0, string.indexOf('.'))) - 1;
        string = string.substring(string.indexOf('.')+1);
        int year = Integer.parseInt(string.substring(0, string.indexOf(' ')));
        string = string.substring(string.indexOf(' ')+1);
        int hrs = Integer.parseInt(string.substring(0, string.indexOf(':')));
        string = string.substring(string.indexOf(':')+1);
        int min = Integer.parseInt(string.substring(0, string.indexOf(':')));
        string = string.substring(string.indexOf(':')+1);
        int sec = Integer.parseInt(string);
        return (new GregorianCalendar(year, month, date, hrs, min, sec)).getTime();
    }

    private Map<String, String> getDataFromString(String s) {
        Map<String, String> result = new HashMap<>();
        String ip = s.substring(0, s.indexOf('\t'));
        result.put("ip", ip);
        String str = s.substring(s.indexOf('\t')+1);
        String user = str.substring(0, str.indexOf('\t'));
        result.put("user", user);
        str = str.substring(str.indexOf('\t')+1);
        String date = str.substring(0, str.indexOf('\t'));
        result.put("date", date);
        str = str.substring(str.indexOf('\t')+1);
        String event = str.substring(0, str.indexOf('\t'));
        if (event.indexOf(' ') > 0) {
            String taskNumber = event.substring(event.indexOf(' ')+1);
            event = event.substring(0, event.indexOf(' '));
            result.put("task", taskNumber);
        }
        result.put("event", event);
        str = str.substring(str.indexOf('\t')+1);
        String status = str;
        result.put("status", status);
        return result;
    }
    public class MyLog {
        String ip;
        String userName;
        Date date;
        Event event;
        int taskNumber;
        Status status;

        public MyLog(String ip, String userName, Date date, Event event, int taskNumber, Status status) {
            this.ip = ip;
            this.userName = userName;
            this.date = date;
            this.event = event;
            this.taskNumber = taskNumber;
            this.status = status;
        }

        public Object searchRecAtQueryField(String field1, String field2, String value1) {

            switch (field2) {
                case "ip":
                    if (value1.equals(this.ip)) {
                        return getField(field1);
                    }
                    break;
                case "user":
                    if (value1.equals(this.userName)) {
                        return getField(field1);
                    }
                    break;
                case "date":
                    if (value1.equals(this.date)) {
                        return getField(field1);
                    }
                    break;
                case "event":
                    if (value1.equals(this.event)) {
                        return getField(field1);
                    }
                    break;
                case "status":
                    if (value1.equals(this.status)) {
                        return getField(field1);
                    }
                    break;
            }
            return null;
        }

        private Object getField(String field1) {
            switch (field1) {
                case "ip":
                    return ip;
                case "user":
                    return userName;
                case "date":
                    return date;
                case "event":
                    return Event.valueOf(field1);
                case "status":
                    return Status.valueOf(field1);
                default:
                    return null;
            }
        }

        public String getIp() {
            return ip;
        }

        public String getUserName() {
            return userName;
        }

        public Date getDate() {
            return date;
        }

        public Event getEvent() {
            return event;
        }

        public int getTaskNumber() {
            return taskNumber;
        }

        public Status getStatus() {
            return status;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public void setEvent(Event event) {
            this.event = event;
        }

        public void setTaskNumber(int taskNumber) {
            this.taskNumber = taskNumber;
        }

        public void setStatus(Status status) {
            this.status = status;
        }
    }

}