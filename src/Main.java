public class Main {
    public static void main(String[] args) {
        Hotelanbieter hotelanbieter = new Hotelanbieter("G", "H", "I", "J");
        Hotel[] anfrage1 = {hotelanbieter.h1,hotelanbieter.h2,hotelanbieter.h3};
        Hotel[] anfrage2 = {hotelanbieter.h1,hotelanbieter.h2,hotelanbieter.h3};

        MessageBroker messageBroker = new MessageBroker();
        ReiseBroker reiseBroker = new ReiseBroker();
        Reiseverlauf reiseverlauf = new Reiseverlauf("Jens", anfrage1);
        Reiseverlauf reiseverlauf1 = new Reiseverlauf("Jonas", anfrage2);

    }
}