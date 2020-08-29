package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Worker implements Runnable {
    protected Socket  clientSocket   = null;  // Клиентский сокет
    protected Request currentRequest = null;  // Заявка, которую обрабатывает текущий Worker
    protected static int numberOfWorkers = 0; // Переменная для хранения ID worker-ов
    protected int workersId = Worker.numberOfWorkers++;  // Уникальный ID worker-а

    public Worker(Socket clientSocket, Request currentRequest) {
        this.clientSocket = clientSocket;
        this.currentRequest = currentRequest;
    }

    @Override
    public void run() {
        try {
            InputStream input  = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            long time = System.currentTimeMillis();
            String msg = "~ Worker #" + String.valueOf(this.workersId);
            output.write(msg.getBytes());
            output.close();
            input.close();
            System.out.println("Request processed: " + time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
