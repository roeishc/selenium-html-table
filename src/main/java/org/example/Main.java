package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello world!");

        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\assignments\\selenium-extract-data-from-table\\chromedriver.exe");

        // Set ChromeOptions to disable web security
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-file-access-from-files");
        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--remote-debugging-port=0"); // This lets ChromeDriver select an available port

        // Initialize the WebDriver with options
        WebDriver driver = new ChromeDriver(options);

        try {
            Thread.sleep(2000);

            // Navigate to the local HTML file using the file:// protocol
            driver.get("file:///C:/Projects/assignments/selenium-extract-data-from-table/src/main/resources/index.html");

            WebElement table = driver.findElement(By.id("gradesTable"));
            List<WebElement> rows = table.findElements(By.tagName("tr"));

            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for (WebElement cell : cells) {
                    System.out.print(cell.getText() + "\t");
                }
                System.out.println();
            }
        } finally {
            driver.quit();
        }




        /*
        Google's example with the addition of disabling web security in Options
         */

//        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
//        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\assignments\\selenium-extract-data-from-table\\chromedriver.exe");
//
//        // Set ChromeOptions to disable web security
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-web-security");
//        options.addArguments("--allow-file-access-from-files");
//        options.addArguments("--remote-allow-origins=*");
////        options.addArguments("--remote-debugging-port=0"); // This lets ChromeDriver select an available port
//        // Initialize the WebDriver with options
//        WebDriver driver = new ChromeDriver(options);
//
//        driver.get("http://www.google.com/");
//        Thread.sleep(5000);  // Let the user actually see something!
//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("ChromeDriver");
//        searchBox.submit();
//        Thread.sleep(5000);  // Let the user actually see something!
//        driver.quit();

    }
}