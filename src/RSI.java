import java.util.Timer;
import java.util.TimerTask;

public class RSI {
    int numberOfHistoricalSessions = 14;
    int seconds = 5;
    int decision = 0;

    double[] vecQuotation = new double[numberOfHistoricalSessions];

    void runRSI(String isin) {
        Timer timer = new Timer();
        timer.schedule(new TimerRun(), 0, seconds * 1000);
    }

    class TimerRun extends TimerTask {
        public void run() {
            try {
                ReadData data = new ReadData();

                for (int i = numberOfHistoricalSessions - 1; i > 0; i--) {
                    vecQuotation[i] = vecQuotation[i - 1];
                }

                vecQuotation[0] = data.getQuotation("PLOPTTC00011");

//                model data
                vecQuotation[1] = 375.3;
                vecQuotation[2] = 375.6;
                vecQuotation[3] = 374.3;
                vecQuotation[4] = 377.5;
                vecQuotation[5] = 383.9;
                vecQuotation[6] = 385.3;
                vecQuotation[7] = 380.3;
                vecQuotation[8] = 377.3;
                vecQuotation[9] = 378.3;
                vecQuotation[10] = 374.3;
                vecQuotation[11] = 376.3;
                vecQuotation[12] = 377.3;
                vecQuotation[13] = 371.3;

                double increases = 0.0;
                double decreases = 0.0;
                double RS = 0.0;
                double RSIValue = 0.0;
                int countIncreases = 0;
                int countDecreases = 0;

                for (int i = 0; i < numberOfHistoricalSessions - 1; i++) {
                    if (vecQuotation[i] > vecQuotation[i + 1]) {
                        increases += vecQuotation[i] - vecQuotation[i + 1];
                        countIncreases++;
                    }

                    if (vecQuotation[i] < vecQuotation[i + 1]) {
                        decreases -= vecQuotation[i] - vecQuotation[i + 1];
                        countDecreases++;
                    }
                }

//                now increases and decreases is average of it
                if (countIncreases > 0) {
                    increases = increases / countIncreases;
                }

                if (countIncreases > 0) {
                    decreases = decreases / countDecreases;
                }

                if (decreases > 0) {
                    RS = increases/decreases;
                }
                
                if (RS != -1) {
                    RSIValue = 100 - (100 / (1 + RS));
                }

                System.out.println("RSI: " + RSIValue);

                decision = 0;
                if (RSIValue >= 70) decision = -1;
                if (RSIValue <= 30) decision = 1;
            } catch (Exception err) {
                System.out.println(err);
            }
        }
    }
}
