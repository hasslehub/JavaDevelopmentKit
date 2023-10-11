package org.example.server;

import java.io.*;


public class Repository implements IRepository{
    public static final String LOG_PATH = "src/main/java/org/example/server/log.txt";


    @Override
    public void addMessageInLog(String message) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOG_PATH, true))) {
            bw.append(String.format(message + '\n'));
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи истории чата");
        }
    }


    @Override
    public String readLog(){
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH);){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
