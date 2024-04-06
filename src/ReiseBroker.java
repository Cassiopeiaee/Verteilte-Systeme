import java.io.IOException;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReiseBroker {
    ReiseBroker() {
        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            Runnable task = new Runnable() {
                public void run() {
                    while(true){
                        try(Socket soc = serverSocket.accept()) {
                            ObjectInputStream inputReiseBroker = new ObjectInputStream(soc.getInputStream());
                            Reiseverlauf reiseverlauf = (Reiseverlauf) inputReiseBroker.readObject();

                            handleReiseverlauf(reiseverlauf);

                            soc.close();
                            inputReiseBroker.close();

                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            Thread thread = new Thread(task);
            thread.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Socket socket = new Socket("localhost", 8080);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void handleReiseverlauf(Reiseverlauf reiseverlauf){
            System.out.println("Hier ist der Benutzer: " + reiseverlauf.benutzer);
            }
}
