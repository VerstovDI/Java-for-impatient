package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Server implements Runnable {
    protected int                    serverPort    = 8080;         // Порт, на котором будет висеть сервер
    protected ServerSocket           serverSocket  = null;         // Поле для хранения серверного сокета
    protected boolean                isStopped     = false;        // Признак остановки сервера
    protected PriorityQueue<Request> requestsQueue = null;     // Очередь с приоритетами заявок сервера
    //protected static int       numberOfClients = 0;          // Число клиентов

    public Server(int port) {
        this.serverPort = port;
        this.requestsQueue =
                new PriorityQueue<Request>(5, Comparator.comparingInt((Request req) -> req.priority));
    }

    // Перегруженный метод интерфейса Runnable для запуска сервера
    @Override
    public void run() {
        openServerSocket();  // Открываем порт, создаём сокет
        System.out.println("Server started!");
        while (!isStopped()) {
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
                System.out.println("New client connected");
                //new EchoThread().start();
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                output.write("Hello. Please, make request:");
                output.newLine();
                output.flush();
                String clientSentence = input.readLine();
                String[] requestData = clientSentence.split("\\s");
                boolean feedbackDecoding = false;
                if (Integer.parseInt(requestData[1]) == 1) {
                    feedbackDecoding = true;
                } else if (Integer.parseInt(requestData[1]) == 0){
                    feedbackDecoding = false;
                }
                Request clientsRequest = new Request(Integer.parseInt(requestData[0]), feedbackDecoding, Integer.parseInt(requestData[2]));
                this.requestsQueue.add(clientsRequest);
                Request mostValuableRequest = this.requestsQueue.remove();
                System.out.println("Received: " + mostValuableRequest);
                new Thread(new Worker(clientSocket, mostValuableRequest)).start();  // Старт потока, в котором будет выполняться данная заявка
                /*output.close();
                input.close();*/
                //
                //output.writeBytes(фывфывфывфывфыввфывфы);
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("[Error] Server stopped!") ;
                    return;
                }
                throw new RuntimeException("[Error] Incorrect accepting client connection!", e);
            }
            //new Thread(new Worker(clientSocket, clientsRequest)).start();  // Старт потока, в которой будет выполняться данная заявка
        }
        System.out.println("[LOG] Server stopped!") ;
    }

    // Функция проверки того, работает ли сервер
    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    // Функция закрытия серверного сокета
    public synchronized void stop() {
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("[Error] Incorrect closing server...", e);
        }
    }

    // Функция открытия серверного сокета
    private void openServerSocket() {
        System.out.println("...opening server socket");
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("[Error] Can't open port " + this.serverPort, e);
        }
    }

    // Механизм постановки в очередь
    private void enqueuePrioritize(Request request) {

    }
}
