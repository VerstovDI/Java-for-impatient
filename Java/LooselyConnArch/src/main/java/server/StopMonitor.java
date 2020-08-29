package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class StopMonitor implements Runnable {
        private ServerSocket serverMonitorSocket;

        public StopMonitor(int port) {
            //setDaemon(true);
            //setName("StopMonitor");
            try {
                serverMonitorSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            System.out.println("stop monitor thread listening on: "+ serverMonitorSocket.getInetAddress()+":"+ serverMonitorSocket.getLocalPort());
            Socket socket;
            try {
                socket = serverMonitorSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                reader.readLine();
                System.out.println("stop signal received, stopping server");
                socket.close();
                serverMonitorSocket.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
}
