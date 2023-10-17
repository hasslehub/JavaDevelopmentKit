package org.example;

import org.example.client.ClientGUI;
import org.example.server.Server;
import org.example.server.ServerWindow;


public class Main {
    public static void main(String[] args) {
        //Server server = new Server();
        //new ClientGUI(server);
        //new ClientGUI(server);
        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}
