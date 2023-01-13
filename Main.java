import org.jsoup.Jsoup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Main {

    public static void main(String[] args) throws InterruptedException {
        int correctLength;
        WebDriver driver=new ChromeDriver();
        driver.get("https://sneidavaktin.is/");
        Thread.sleep(5000);
        ((ChromeDriver) driver).findElementByXPath("/html/body/main/div[1]/div/div[4]/div[5]/div[4]").click();
        Thread.sleep(2000);
        while(true) {
           String html = driver.getPageSource();
           html = Jsoup.parse(html).select("body > main > div.main-inner.game > div.bottom-container").toString();
           String[] splitCorrect = html.split("_chosen");
               Thread.sleep(140);
               for (int x = 0; x < splitCorrect.length; x++) {
                   correctLength = splitCorrect[x].length();
                   if (splitCorrect[x].substring(correctLength - 1).toUpperCase().contains(">")) {
                   } else {
                       ((ChromeDriver) driver).findElementByXPath("//*[@id=\"" + splitCorrect[x].substring(correctLength - 1).toUpperCase() + "\"]").click();
                   }
               }
       }
    }
}
