public class MainSig {
    public static void main(String[] args) {
        Signal signal = new Signal();
        String accessKey = "00c7ccc8fcb3802924b72ca162c11bed"; // Remplacez par votre clé d'accès réelle
        String symbol = "AAPL";

        try {
            signal.updateFromMarketstack(accessKey, symbol);
            System.out.println("Nombre de prix de clôture récupérés : " + signal.getClosingPrices().size());
            System.out.println(signal);
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des données : " + e.getMessage());
        }
    }
}

