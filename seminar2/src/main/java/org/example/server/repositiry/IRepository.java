package org.example.server.repositiry;


import org.example.client.Client;

public interface IRepository {

    String readHistory();

    void save(String text);

}
