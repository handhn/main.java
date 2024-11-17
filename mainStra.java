import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Simuler des données de prix pour 30 jours
        List<Double> prices = List.of(
            22.27, 22.19, 22.08, 22.17, 22.18, 22.13, 22.23, 22.43, 22.24, 22.29,
            22.15, 22.39, 22.38, 22.61, 23.36, 24.05, 23.75, 23.83, 23.95, 23.63,
            23.82, 23.87, 23.65, 23.19, 23.10, 23.33, 22.68, 23.10, 22.40, 22.17
        );

        // Utiliser les mêmes prix pour les prix de clôture dans cet exemple
        List<Double> closingPrices = new ArrayList<>(prices);

        // Créer une instance d'IndicateurTechnique (assurez-vous d'avoir une implémentation)
        IndicateurTechnique indicateurs = new IndicateurTechnique(); // Remplacez par votre constructeur approprié

        // Créer des instances de stratégies
        StrategieRSI strategieRSI = new StrategieRSI(indicateurs);
        StrategieMACD strategieMACD = new StrategieMACD(indicateurs);
        StrategieMoyennesMobiles strategieMoyennesMobiles = new StrategieMoyennesMobiles(indicateurs);
        StrategieTendance strategieTendance = new StrategieTendance(indicateurs);
        StrategieBollinger strategieBollinger = new StrategieBollinger(indicateurs);

        // Tester la stratégie RSI
        String signalRSI = strategieRSI.executerAvecPrixCloture(closingPrices);
        System.out.printf("Signal RSI: %s%n", signalRSI);

        // Tester la stratégie MACD
        String signalMACD = strategieMACD.executerAvecPrix(prices);
        System.out.printf("Signal MACD: %s%n", signalMACD);

        // Tester la stratégie Moyennes Mobiles
        String signalMoyennesMobiles = strategieMoyennesMobiles.executerAvecPrix(prices);
        System.out.printf("Signal Moyennes Mobiles: %s%n", signalMoyennesMobiles);

        // Tester la stratégie Tendance
        String signalTendance = strategieTendance.executerAvecPrix(prices);
        System.out.printf("Signal Tendance: %s%n", signalTendance);

        // Tester la stratégie Bandes de Bollinger
        String signalBollinger = strategieBollinger.executerAvecPrix(prices);
        System.out.printf("Signal Bandes de Bollinger: %s%n", signalBollinger);
    }
}
