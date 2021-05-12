package cz.czechitas.selenium;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestyPrihlasovaniNaKurzy {

    WebDriver prohlizec;

    @BeforeEach
    public void setUp() {
//      System.setProperty("webdriver.gecko.driver", System.getProperty("user.home") + "/Java-Training/Selenium/geckodriver");
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        prohlizec = new FirefoxDriver();
        prohlizec.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void prihlaseniRodiceDoUctu() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");
        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[2]/a"));
        tlacitkoPrihlasit.click();
        WebElement polickoEmail = prohlizec.findElement(By.id("email"));
        polickoEmail.sendKeys("panitestova@gmail.com");
        WebElement polickoHeslo = prohlizec.findElement(By.id("password"));
        polickoHeslo.sendKeys("DAczechitas2021");
        WebElement mensiTlacitkoPrihlasit = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div[3]/div/button"));
        mensiTlacitkoPrihlasit.click();
    }

    @Test
    public void prihlaseniDiteteDoKurzu() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/11-trimesicni-kurzy-webu");
        WebElement tlacitkoVytvoritPrihlasku = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div[2]/a"));
        tlacitkoVytvoritPrihlasku.click();
        WebElement polickoEmail = prohlizec.findElement(By.id("email"));
        polickoEmail.sendKeys("panitestova@gmail.com");
        WebElement polickoHeslo = prohlizec.findElement(By.id("password"));
        polickoHeslo.sendKeys("DAczechitas2021");
        WebElement mensiTlacitkoPrihlasit = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div[3]/div/button"));
        mensiTlacitkoPrihlasit.click();
        //WebElement polickoTermin = prohlizec.findElement(By.id("/html/body/div/div/div/div/div/form/table/tbody/tr[2]/td[2]/div/button/div/div/div"));
        //polickoTermin.click();
        //WebElement polickoVyhledaniTerminu = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/form/table/tbody/tr[2]/td[2]/div/div/div[1]/input"));
        //polickoVyhledaniTerminu.click();
        //polickoVyhledaniTerminu.sendKeys("2");
        //polickoVyhledaniTerminu.sendKeys("\n");
        WebElement polickoJmenoZaka = prohlizec.findElement(By.id("forename"));
        polickoJmenoZaka.sendKeys("Manual");
        WebElement polickoPrijmeniZaka = prohlizec.findElement(By.id("surname"));
        polickoPrijmeniZaka.sendKeys("Test");
        WebElement polickoDatumNarozeniZaka = prohlizec.findElement(By.id("birthday"));
        polickoDatumNarozeniZaka.sendKeys("12.05.2012");
        WebElement zaskrtavaciPolickoPlatbaHotove = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/form/table/tbody/tr[8]/td[2]/span[4]/label"));
        zaskrtavaciPolickoPlatbaHotove.click();
        WebElement zaskrtavaciPolickoSouhlasSPodminkami = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/form/table/tbody/tr[11]/td[2]/span/label"));
        zaskrtavaciPolickoSouhlasSPodminkami.click();
        //WebElement tlacitkoVytvoritPrihlaskuNaKurz = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/form/table/tbody/tr[11]/td[2]/input"));
        //tlacitkoVytvoritPrihlaskuNaKurz.click();
        //WebElement zalozkaPrihlasky = prohlizec.findElement(By.xpath("/html/body/div/header/div/nav/span[2]/a"));
        //zalozkaPrihlasky.click();

        //List<WebElement> seznamPrihlasek = prohlizec.findElements(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[1]"));
        //WebElement elementPrvniPrihlaska = seznamPrihlasek.get(0);
        //String prvniPrihlaska = elementPrvniPrihlaska.getText();
        //Assertions.assertEquals("Automat Test", prvniPrihlaska);
    }

    /*@Test
    public void zviratVTabulceMusiByt7() {
        prohlizec.navigate().to("https://automation3.shinekamil.repl.co/");
        WebElement zalozkaTabulka = prohlizec.findElement(By.linkText("Table"));
        zalozkaTabulka.click();

        List<WebElement> seznamZvirat = prohlizec.findElements(By.xpath("//table/tbody/tr/td[1]"));
        Assertions.assertEquals(7, seznamZvirat.size());
    }*/

    /*@Test
    public void prvniZvireVTabulceMusiBytKocka() {
        prohlizec.navigate().to("https://automation3.shinekamil.repl.co/");
        WebElement zalozkaTabulka = prohlizec.findElement(By.linkText("Table"));
        zalozkaTabulka.click();
    */


    @AfterEach
    public void tearDown() {
        prohlizec.close();
    }
}
