import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Signal signal = new Signal();
        String urlString = "http://example.com/realtime_data"; // URL fictive, à remplacer par l'URL réelle

        // Créer une tâche pour mettre à jour les données toutes les 5 secondes
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    signal.updateFromURL(urlString);
                    System.out.println("Données mises à jour");
                    
                    // Afficher les 5 derniers prix et prix de clôture
                    List<Double> prices = signal.getPrices();
                    List<Double> closingPrices = signal.getClosingPrices();
                    int size = prices.size();
                    
                    System.out.println("Derniers prix:");
                    for (int i = Math.max(0, size - 5); i < size; i++) {
                        System.out.println("Prix: " + prices.get(i) + ", Clôture: " + closingPrices.get(i));
                    }
                } catch (Exception e) {
                    System.out.println("Erreur lors de la mise à jour des données: " + e.getMessage());
                }
            }
        };

        // Programmer la tâche pour s'exécuter toutes les 5 secondes
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 5000);

        // Laisser le programme s'exécuter pendant 1 minute
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Arrêter le timer
        timer.cancel();
    }
}
