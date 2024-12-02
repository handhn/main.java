import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        // données
        
	Signal signal = new Signal();
        String accessKey = "e151d80c378a3619067daf2e67d2dade"; // Assurez-vous d'utiliser votre propre clé d'accès
        String symbol = "AMZN";
        List<Double> closingPrices = new ArrayList<>();

        try {
            // Récupérer les données de l'API
            signal.updateFromMarketstack(accessKey, symbol);
            closingPrices = signal.getClosingPrices();

            System.out.println("Nombre de prix de clôture récupérés : " + closingPrices.size());
            System.out.println(signal);

            // Vérifier si nous avons suffisamment de données
            if (closingPrices.size() < 26) { // 26 est le maximum requis pour MACD
                throw new Exception("Pas assez de données pour effectuer l'analyse");
            }
      	} catch (Exception e) {
    		System.out.println("Erreur lors de la récupération des données : " + e.getMessage());
    		return; // Sortir du programme si une erreur se produit lors de la récupération des données
}           
        //fin de données 
        




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
            String signalMACD = strategieMACD.executerAvecPrixCloture(closingPrices);
            System.out.printf("Signal MACD: %s%n", signalMACD);
        } catch (Exception e) {
            System.out.println("Erreur lors du test de la Stratégie MACD: " + e.getMessage());
        }

        // Tester la stratégie Moyennes Mobiles
        System.out.println("\nTest de la Stratégie Moyennes Mobiles:");
        try {
            String signalMoyennesMobiles = strategieMoyennesMobiles.executerAvecPrixCloture(closingPrices);
            System.out.printf("Signal Moyennes Mobiles: %s%n", signalMoyennesMobiles);
        } catch (Exception e) {
            System.out.println("Erreur lors du test de la Stratégie Moyennes Mobiles: " + e.getMessage());
        }

        // Tester la stratégie Tendance
        System.out.println("\nTest de la Stratégie de Tendance:");
        try {
            String signalTendance = strategieTendance.executerAvecPrixCloture(closingPrices);
            System.out.printf("Signal de Tendance: %s%n", signalTendance);
        } catch (Exception e) {
            System.out.println("Erreur lors du test de la Stratégie de Tendance: " + e.getMessage());
        }

        // Tester la stratégie Bandes de Bollinger
        System.out.println("\nTest de la Stratégie Bandes de Bollinger:");
        try {
            String signalBollinger = strategieBollinger.executerAvecPrixCloture(closingPrices);
            System.out.printf("Signal Bandes de Bollinger: %s%n", signalBollinger);
        } catch (Exception e) {
            System.out.println("Erreur lors du test de la Stratégie Bandes de Bollinger: " + e.getMessage());
        }
    }
}
