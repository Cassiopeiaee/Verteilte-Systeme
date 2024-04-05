import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer{
    public static void main(String[] args) {

        try
        {
            ServerSocket ss = new ServerSocket(3000);
            System.out.println("Waiting for Client...");
            Socket soc = ss.accept();
            System.out.println("Verbunden mit Client");
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
