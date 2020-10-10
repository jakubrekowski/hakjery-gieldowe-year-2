public class Exchenge {
    public static void main(String[] args) {
        String CDPisin = "PLOPTTC00011";

        RSI rsiCDP = new RSI();
        rsiCDP.runRSI(CDPisin);

        ROC rocCDP = new ROC();
        rocCDP.runROC(CDPisin);
    }
}
