import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        try {
            System.out.println("Client online");
            Socket csoc = new Socket("localhost", 3000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
