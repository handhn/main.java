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

        // Paramètres pour les indicateurs
        int rsiPeriod = 14;
        int smaPeriod = 20;
        int emaPeriod = 20;
        int macdShortPeriod = 12;
        int macdLongPeriod = 26;
        int macdSignalPeriod = 9;
        int bollingerPeriod = 20;
        double bollingerK = 2.0;

        // Calculer et afficher RSI
        double rsi = RSICalculator.calculateRSI(closingPrices, rsiPeriod);
        System.out.printf("RSI (%d périodes): %.2f%n", rsiPeriod, rsi);

        // Calculer et afficher SMA
        double sma = MAsCalculator.calculateSMA(prices, smaPeriod);
        System.out.printf("SMA (%d périodes): %.2f%n", smaPeriod, sma);

        // Calculer et afficher EMA
        double ema = MAsCalculator.calculateEMA(prices, emaPeriod);
        System.out.printf("EMA (%d périodes): %.2f%n", emaPeriod, ema);

        // Calculer et afficher MACD
        MACDCalculator macdCalculator = new MACDCalculator(macdShortPeriod, macdLongPeriod, macdSignalPeriod);
        List<Double> macdHistogram = macdCalculator.calculateMACD(prices);
        System.out.printf("MACD (%d, %d, %d): %s%n", macdShortPeriod, macdLongPeriod, macdSignalPeriod, macdHistogram);

        // Calculer et afficher Bandes de Bollinger
        BollingerBDCalculator.calculateBollingerBD bollingerBands = 
            BollingerBDCalculator.calculate(prices, bollingerPeriod, bollingerK);
        System.out.printf("Bandes de Bollinger (%d périodes, %.1f K):%n", bollingerPeriod, bollingerK);
        System.out.printf("  SMA: %.2f%n", bollingerBands.sma);
        System.out.printf("  Bande supérieure: %.2f%n", bollingerBands.upperBand);
        System.out.printf("  Bande inférieure: %.2f%n", bollingerBands.lowerBand);
    }
}
