import java.util.List;
import java.util.ArrayList;

public class MainStra {
    public static void main(String[] args) {
        // Simuler des données de prix pour 200 jours
        List<Double> closingPrices = new ArrayList<>();
       for (int i = 0; i < 200; i++) {
            prices.add(20 + Math.random() * 10); // Générer des prix aléatoires entre 20 et 30
        }
        


        // Créer des instances d'IndicateurTechnique en utilisant les méthodes statiques
        IndicateurTechnique rsiIndicator = IndicateurTechnique.createRSI(closingPrices, 14);
        IndicateurTechnique smaIndicator = IndicateurTechnique.createSMA(closingPrices, 20);
        IndicateurTechnique emaIndicator = IndicateurTechnique.createEMA(closingPrices, 20);
        IndicateurTechnique macdIndicator = IndicateurTechnique.createMACD(closingPrices, 12, 26, 9);
        IndicateurTechnique bollingerBandsIndicator = IndicateurTechnique.createBollingerBands(closingPrices, 20, 2.0);

        // Créer des instances de stratégies avec les indicateurs appropriés
        StrategieRSI strategieRSI = new StrategieRSI(rsiIndicator);
        StrategieMACD strategieMACD = new StrategieMACD(macdIndicator);
        StrategieMoyennesMobiles strategieMoyennesMobiles = new StrategieMoyennesMobiles(smaIndicator);
        StrategieTendance strategieTendance = new StrategieTendance(emaIndicator);
        StrategieBollinger strategieBollinger = new StrategieBollinger(bollingerBandsIndicator);

        // Tester la stratégie RSI
        System.out.println("Test de la Stratégie RSI:");
        try {
            String signalRSI = strategieRSI.executerAvecPrixCloture(closingPrices);
            System.out.printf("Signal RSI: %s%n", signalRSI);
        } catch (Exception e) {
            System.out.println("Erreur lors du test de la Stratégie RSI: " + e.getMessage());
        }

        // Tester la stratégie MACD
        System.out.println("\nTest de la Stratégie MACD:");
        try {
            String signalMACD = strategieMACD.executerAvecPrix(prices);
            System.out.printf("Signal MACD: %s%n", signalMACD);
        } catch (Exception e) {
            System.out.println("Erreur lors du test de la Stratégie MACD: " + e.getMessage());
        }

        // Tester la stratégie Moyennes Mobiles
        System.out.println("\nTest de la Stratégie Moyennes Mobiles:");
        try {
            String signalMoyennesMobiles = strategieMoyennesMobiles.executerAvecPrix(prices);
            System.out.printf("Signal Moyennes Mobiles: %s%n", signalMoyennesMobiles);
        } catch (Exception e) {
            System.out.println("Erreur lors du test de la Stratégie Moyennes Mobiles: " + e.getMessage());
        }

        // Tester la stratégie Tendance
        System.out.println("\nTest de la Stratégie de Tendance:");
        try {
            String signalTendance = strategieTendance.executerAvecPrix(prices);
            System.out.printf("Signal de Tendance: %s%n", signalTendance);
        } catch (Exception e) {
            System.out.println("Erreur lors du test de la Stratégie de Tendance: " + e.getMessage());
        }

        // Tester la stratégie Bandes de Bollinger
        System.out.println("\nTest de la Stratégie Bandes de Bollinger:");
        try {
            String signalBollinger = strategieBollinger.executerAvecPrix(prices);
            System.out.printf("Signal Bandes de Bollinger: %s%n", signalBollinger);
        } catch (Exception e) {
            System.out.println("Erreur lors du test de la Stratégie Bandes de Bollinger: " + e.getMessage());
        }
    }
}

