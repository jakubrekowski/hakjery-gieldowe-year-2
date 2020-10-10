import java.util.Timer;
import java.util.TimerTask;

public class ROC {
    int numberOfHistoricalSessions = 14;
    int seconds = 5;
    int decision = 0;

    double[] vecQuotation = new double[numberOfHistoricalSessions];
    double[] vecROC = new double[2];

    void runROC(String isin) {
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

                double ROCValue = 0.0;
                double ROCRest = 1.0;

                for (int i = 0; i < numberOfHistoricalSessions - 1; i++) {
                    ROCRest *= vecQuotation[i];
                }

                ROCValue = vecQuotation[0] - ROCRest;



                for (int i = 2 - 1; i > 0; i--) {
                    vecROC[i] = vecROC[i - 1];
                }

                vecROC[0] = ROCValue;

                if (vecROC[0] > 0 && vecROC[1] < 0) decision = 1;
                if (vecROC[0] < 0 && vecROC[1] > 0) decision = -1;

                System.out.println("ROC: " + ROCValue);

            } catch (Exception err) {
                System.out.println(err);
            }
        }
    }
}
