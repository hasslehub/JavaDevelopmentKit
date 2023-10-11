package org.example.server;


public interface IRepository {

    String readLog();

    void addMessageInLog(String message);

}
