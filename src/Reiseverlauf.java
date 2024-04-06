import java.io.IOException;
import java.net.Socket;
import java.io.OutputStream;
import java.io.*;


public class Reiseverlauf {
    String benutzer;
    Hotel[] hotels;

    public  Reiseverlauf(String benutzer, Hotel[] hotels){

            this.hotels = hotels;
            this.benutzer = benutzer;
            reiseverlaufRun();
    }

    public void reiseverlaufRun(){
        Thread ReiseThread = new Thread(new SendHotel());
        ReiseThread.start();
    }


    class SendHotel implements Runnable{
        public void run(){
            String HostReise = "localhost";
            int PortReise = 3000;


            try
            {
                Socket ReiseverlaufSocket = new Socket(HostReise, PortReise);
                OutputStream ReiseverlaufOutputStream = ReiseverlaufSocket.getOutputStream();
                ObjectOutputStream ReiseOutput = new ObjectOutputStream(ReiseverlaufOutputStream);
                ReiseOutput.writeObject(Reiseverlauf.this);

                System.out.println("Hotel übergeben an Broker");

                ReiseOutput.close();
                System.out.println("Hotel übergeben an Broker");
                ReiseverlaufSocket.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
