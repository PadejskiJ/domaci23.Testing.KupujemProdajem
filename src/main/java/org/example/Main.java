package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

/*
Napraviti aplikaciju pomocu Selenium-a koji ce otvoriti sajt kupujemprodajem.com,
izlistati sve kategorije (Stvari) sa leve strane i njihove linkove
(kao spoken tekst “kategorija: link”), kliknuti iz te liste na Bicikli (bez hardkodovanja,
posto imate listu, iskoristiti element iz nje da se klikne), kliknuti na Električni (mozete hardcodovati).
Ostati na toj strani kao kraj zadatka.
Uspavati program na 5 sekundi kako bi se video rezultat i posle toga browser zatvoriti.
Obratiti paznju na "ad" koji kaze da se registrujete.
Uzeti dugme x i kliknuti ga pre svega da ne bi ste imali problem da ne mozete da kliknete na kategoriju.
Za 5+ nakon klika na kategoriju bicikli, treba izlistati sve kategorije koje pisu (Mountainbike, Gradski itd).
 */
public class Main {
    public static void main(String[] args) {
gi
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jpbou\\IdeaProjects/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.kupujemprodajem.com/");
        driver.manage().window().maximize();

        //   kpBoxCloseButton  //*[@id="bodyTag"]/div[9]/div/div[2]
        WebElement kpBoxCloseButton = driver.findElement(By.xpath("//*[@id=\"bodyTag\"]/div[9]/div/div[2]"));
        kpBoxCloseButton.click();

        // class= i-understand
        WebElement closeCookie = driver.findElement(By.className("i-understand"));
        closeCookie.click();

        //   id="category-tree-tab-goods"
        List <WebElement> kategorijeStvari = driver.findElements(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[4]/a"));
             for (int i = 0; i < kategorijeStvari.size(); i++) {
                  WebElement kategorija = kategorijeStvari.get(i);
                  System.out.println(kategorija.getText() + " " + kategorija.getAttribute("href"));
                }

            for (int i = 0; i < kategorijeStvari.size(); i++) {
                if (kategorijeStvari.get(i).getText().equals("Bicikli")) {
                    kategorijeStvari.get(i).click();
                    WebElement elektricniBicikli = driver.findElement(By.xpath("//*[@id=\"groupBox1360\"]/div[1]/h2/a/span"));
                    elektricniBicikli.click();
                    break;
                }
            }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}