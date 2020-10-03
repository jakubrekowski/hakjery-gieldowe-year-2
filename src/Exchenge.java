public class Exchenge {
    public static void main(String[] args) {
        RSI rsiCDP = new RSI();
        System.out.println(rsiCDP.runRSI("PLOPTTC00011"));

        ReadData data = new ReadData();
//        System.out.println(data.getQuotation());
    }
}
