public class RSI {
    double runRSI(String isin) {
        ReadData data = new ReadData();

        double actualQuotation = data.getQuotation(isin);

        return actualQuotation;
    }
}
