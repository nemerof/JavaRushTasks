package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    @Override
    protected String getUserName() throws IOException, ClassNotFoundException {
        return "date_bot_" + ((int) (Math.random() * 100));
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String[] args) {
        BotClient bot = new BotClient();
        bot.run();
    }

    public class BotSocketThread extends Client.SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] messageParts = message.split(": ");
            if (messageParts.length == 2) {
                String messageAuthor = messageParts[0];
                String messageText = messageParts[1].toLowerCase();
                String dateTimeFormat = null;
                switch (messageText) {
                    case "дата":
                        dateTimeFormat = "d.MM.YYYY";
                        break;
                    case "день":
                        dateTimeFormat = "d";
                        break;
                    case "месяц":
                        dateTimeFormat = "MMMM";
                        break;
                    case "год":
                        dateTimeFormat = "YYYY";
                        break;
                    case "время":
                        dateTimeFormat = "H:mm:ss";
                        break;
                    case "час":
                        dateTimeFormat = "H";
                        break;
                    case "минуты":
                        dateTimeFormat = "m";
                        break;
                    case "секунды":
                        dateTimeFormat = "s";
                        break;
                }
                if (dateTimeFormat != null) {
                    String reply = String.format("Информация для %s: %s",
                            messageAuthor,
                            new SimpleDateFormat(dateTimeFormat).format(Calendar.getInstance().getTime()));
                    sendTextMessage(reply);
                }
            }
        }
    }
}
