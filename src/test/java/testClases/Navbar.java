package testClases;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Navbar {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;
    Actions actions;

    public Navbar(WebDriver driver){
        this.driver = driver;
        this.elementHelper = new ElementHelper(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void userIsOnHomePage() {

    }

    public void theUserClicksOnAllElementsInTheNavbarInOrder() {


            // Sayfa kaynağını Jsoup ile parse et
            String pageSource = driver.getPageSource();
            Document doc = Jsoup.parse(pageSource);

            // Navbar elementlerini al
            Element menu = doc.getElementById("menu-1-5dc673f1");
            if (menu == null) {
                System.out.println("Menü bulunamadı. Lütfen geçerli bir ID girin.");
                return;
            }

            // Navbar'daki tüm ana başlıkları seç
            Elements menuItems = menu.select("li > a"); // Menü linklerini al
            for (Element menuItem : menuItems) {
                // Menü linkinin text'ini ve href'ini al
                String menuText = menuItem.text();
                String href = menuItem.attr("href");

                // Selenium ile bu menü elemanını bul ve tıkla
                WebElement menuElement = driver.findElement(By.linkText(menuText));
                menuElement.click();

                // Sayfanın doğru yüklendiğini doğrula
                if (driver.getCurrentUrl().equals(href) || driver.getPageSource().contains(menuText)) {
                    System.out.println("Başarıyla yönlendirildi: " + menuText);
                } else {
                    System.out.println("Yönlendirme hatası: " + menuText);
                }

                // Ana sayfaya geri dön (isteğe bağlı, çünkü her menü elemanı için baştan başlamamız gerekebilir)
                driver.navigate().back();

                // Sayfa kaynağını tekrar parse et (dinamik elemanlar için güncelleme)
                pageSource = driver.getPageSource();
                doc = Jsoup.parse(pageSource);
                menu = doc.getElementById("menu-1-5dc673f1");
                menuItems = menu.select("li > a");
            }


    }

//    public void theUserClicksOnAllElementsInTheNavbarInOrder() {
//        elementHelper.sleep(5000);
//
//
//        String pageSource = driver.getPageSource();
//        Document doc = Jsoup.parse(pageSource);
//
//        // Menü elemanını al
//        Element menu = doc.getElementById("menu-1-5dc673f1");
//        if (menu == null) {
//            System.out.println("Menü bulunamadı. Lütfen geçerli bir ID girin.");
//            return;
//        }
//
//        // Menüdeki tüm ana başlıkları ve alt başlıklarını al
//        Elements menuItems = menu.select("> li"); // Sadece doğrudan `li` elemanlarını seç
//        List<Menu> menuList = new ArrayList<>();
//
//        for (Element menuItem : menuItems) {
//
//                Menu menuObj = new Menu();
//
//
//                Elements altMenuItems = menuItem.select("ul > li > a"); // Alt başlıkları seç
//                List<String> titleList = new ArrayList<>();
//                for (Element altMenuItem : altMenuItems) {
//                    titleList.add(altMenuItem.text());
//                }
//                menuObj.setTitle(titleList);
//
//                // Menü objesini listeye ekle
//                menuList.add(menuObj);
//        }
//
//        // Listeyi ve içindekileri yazdır
//        for (Menu item : menuList) {
//            if (!item.getTitle().isEmpty()) {
//                System.out.println("Titles :");
//                for (String subItem : item.getTitle()) {
//                    System.out.println("  - " + subItem);
//                }
//            } else {
//                System.out.println("Alt Başlık yok.");
//            }
//            System.out.println();
//        }
//
//    }






    public void afterEachClickTheRelevantPageShouldOpenWithoutAnyProblems() {
    }
}
