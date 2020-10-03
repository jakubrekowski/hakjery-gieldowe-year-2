import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class ReadData {
    double getQuotation(String isin) {
        try {
            Document encodedHTML = Jsoup.connect("https://www.gpw.pl/ajaxindex.php?start=quotationsTab&format=html&action=GPWListaSp&gls_isin=" + isin).get();
            Document decryptedHTML = Jsoup.parse(encodedHTML.toString());

            double selling = Double.parseDouble(decryptedHTML.select("td").get(4).ownText().replace(",", ".").replace(" ", ""));

            System.out.println("\nconnected \n\n");

            return selling;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
