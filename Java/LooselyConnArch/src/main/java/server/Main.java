package server;

import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int serverActivePort = 8080;
        Server myServer = new Server(serverActivePort);  // Создаём сервер, который будет работать на порту 8080
        System.out.println("...starting server");
        myServer.run();
        myServer.stop();
    }
}
