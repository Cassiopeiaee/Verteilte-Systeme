import jdk.internal.org.objectweb.asm.ClassReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageBroker {
    MessageBroker() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Thread thread = new Thread(new Runnable() {
                public void run() {
                        try(Socket socket = serverSocket.accept()) {
                            System.out.println(getClass().getName() + " connected");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            });
            thread.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
