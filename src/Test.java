import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        int fileCounter = 1; // Startnummer für die Dateinamen
        List<Hotel> hotels=new ArrayList<>();

        while (true) {
            String jsonFileName = "example" + fileCounter + ".json";
            String jsonFilePath = "resources/" + jsonFileName; // Passe den Pfad entsprechend an

            try {
                // JSON-Datei einlesen
                String jsonContent = readJSON(jsonFilePath);

                // Ausgabe der JSON-Werte
                System.out.println("Inhalt der JSON-Datei: " + jsonFileName + ":");

                // Objekt "hotel" mit fortlaufender Zahl erstellen und Werte speichern
                Hotel hotel = parseJSON(jsonContent, fileCounter);

                // Hinzufügen des Hotelobjekts zur Liste
                hotels.add(hotel);

                // Ausgabe des Hotel-Objekts
                System.out.println(hotel);

                fileCounter++; // Inkrementiere den Zähler für die nächste Datei

            } catch (IOException e) {
                // Wenn die Datei nicht gefunden wird, breche die Schleife ab
                System.out.println("Keine weitere JSON-Datei gefunden.");
                break;
            }
        }
        // Beispiel: Zugriff auf das erste Hotelobjekt in der Liste
        if (!hotels.isEmpty()) {
            Hotel firstHotel = hotels.get(0);
            System.out.println("Erstes Hotel: " + firstHotel);
        }
        System.out.println("ArrayListe aller Hotels:" + "\n" +hotels );

    }

    public static String readJSON(String filePath) throws IOException {
        StringBuilder jsonContent = new StringBuilder();

        // JSON-Datei einlesen
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
        }

        return jsonContent.toString();
    }

    public static Hotel parseJSON(String jsonContent, int fileCounter) {
        // Einfache Implementierung zum Parsen des JSON-Strings und Erstellen des Hotel-Objekts
        String name = extractValue(jsonContent,"name") ;
        int zimmerAnzahl = Integer.parseInt(extractValue(jsonContent, "Anzahl an Zimmern"));


        return new Hotel(name, zimmerAnzahl);
    }

    public static String extractValue(String jsonContent, String key) {
        String searchKey = "\"" + key + "\":";
        int index = jsonContent.indexOf(searchKey);
        if (index != -1) {
            int startIndex = index + searchKey.length();
            int endIndex = jsonContent.indexOf(",", startIndex);
            if (endIndex == -1) {
                endIndex = jsonContent.indexOf("}", startIndex);
            }
            return jsonContent.substring(startIndex, endIndex).trim().replace("\"", "");
        }
        return null;
    }

    // Einfaches Hotel-Objekt zur Speicherung der JSON-Daten
    static class Hotel {
        private String name;
        private int zimmerAnzahl;


        public Hotel(String name, int zimmerAnzahl) {
            this.name = name;
            this.zimmerAnzahl=zimmerAnzahl;

        }

        @Override
        public String toString() {
            return "Hotel{name='" + name + "', Zimmeranzahl='" + zimmerAnzahl + "}" + "\n";
        }
    }
}
