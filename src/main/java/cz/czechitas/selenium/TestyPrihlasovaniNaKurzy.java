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

    private static final String URL_APLIKACE = "https://cz-test-dva.herokuapp.com/";

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
        prohlizec.navigate().to(URL_APLIKACE);
        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.className("qa-login-button"));
        tlacitkoPrihlasit.click();

        WebElement polickoEmail = prohlizec.findElement(By.id("email"));
        polickoEmail.sendKeys("panitestova@gmail.com");
        WebElement polickoHeslo = prohlizec.findElement(By.id("password"));
        polickoHeslo.sendKeys("DAczechitas2021");
        WebElement mensiTlacitkoPrihlasit = prohlizec.findElement(By.xpath("//button[contains (@class, 'qa-login-button')]"));
        mensiTlacitkoPrihlasit.click();

        Assertions.assertTrue(prohlizec.getCurrentUrl().endsWith("/zaci"));
        WebElement nadpisStranky = prohlizec.findElement(By.xpath("//header//h1"));
        Assertions.assertEquals("Přihlášky", nadpisStranky.getText());
    }

    @Test
    public void vyberKurzuProDitePrihlaseniRodiceVytvoreniPrihlasky() {
        String urlVyberKurzu = URL_APLIKACE + "11-trimesicni-kurzy-webu";
        prohlizec.navigate().to(urlVyberKurzu);
        WebElement tlacitkoVytvoritPrihlasku = prohlizec.findElement(By.className("btn-primary"));
        tlacitkoVytvoritPrihlasku.click();

        WebElement polickoEmail = prohlizec.findElement(By.id("email"));
        polickoEmail.sendKeys("panitestova@gmail.com");
        WebElement polickoHeslo = prohlizec.findElement(By.id("password"));
        polickoHeslo.sendKeys("DAczechitas2021");
        WebElement mensiTlacitkoPrihlasit = prohlizec.findElement(By.xpath("//button[contains (@class, 'qa-login-button')]"));
        mensiTlacitkoPrihlasit.click();
        WebElement polickoTermin = prohlizec.findElement(By.className("bs-placeholder"));
        polickoTermin.click();
        WebElement polickoPrazdnyTermin = prohlizec.findElement(By.className("bs-searchbox"));
        polickoPrazdnyTermin.click();
        WebElement polickoKonkretniTermin = prohlizec.findElement(By.id("bs-select-1-0"));
        polickoKonkretniTermin.click();
        WebElement polickoJmenoZaka = prohlizec.findElement(By.id("forename"));
        polickoJmenoZaka.sendKeys("Melichar");
        WebElement polickoPrijmeniZaka = prohlizec.findElement(By.id("surname"));
        polickoPrijmeniZaka.sendKeys("Test");
        WebElement polickoDatumNarozeniZaka = prohlizec.findElement(By.id("birthday"));
        polickoDatumNarozeniZaka.sendKeys("12.05.2012");
        WebElement zaskrtavaciPolickoPlatbaHotove = prohlizec.findElement(By.xpath("//table/tbody/tr[8]/td[2]/span[4]/label"));
        zaskrtavaciPolickoPlatbaHotove.click();
        WebElement zaskrtavaciPolickoSouhlasSPodminkami = prohlizec.findElement(By.xpath("//table/tbody/tr[11]/td[2]/span/label"));
        zaskrtavaciPolickoSouhlasSPodminkami.click();
        WebElement tlacitkoVytvoritPrihlaskuNaKurz = prohlizec.findElement(By.className("qa-submit-button"));
        tlacitkoVytvoritPrihlaskuNaKurz.click();

        WebElement potvrzeniPrihlasky = prohlizec.findElement(By.xpath("//*[text()='Stáhnout potvrzení o přihlášení']"));
        Assertions.assertNotNull(potvrzeniPrihlasky);
    }

    @Test
    public void prihlaseniRodiceVyberKurzuVytvoreniPrihlasky() {
        prohlizec.navigate().to(URL_APLIKACE);
        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.className("qa-login-button"));
        tlacitkoPrihlasit.click();

        WebElement polickoEmail = prohlizec.findElement(By.id("email"));
        polickoEmail.sendKeys("panitestova@gmail.com");
        WebElement polickoHeslo = prohlizec.findElement(By.id("password"));
        polickoHeslo.sendKeys("DAczechitas2021");
        WebElement mensiTlacitkoPrihlasit = prohlizec.findElement(By.xpath("//button[contains (@class, 'qa-login-button')]"));
        mensiTlacitkoPrihlasit.click();
        WebElement zalozkaProRodice = prohlizec.findElement(By.className("qa-for-parents-button"));
        zalozkaProRodice.click();
        WebElement dropDownVytvoritPrihlasku = prohlizec.findElement(By.className("qa-new-application-button"));
        dropDownVytvoritPrihlasku.click();
        WebElement tlacitkoProgramovaniViceInformaci = prohlizec.findElement(By.xpath("//div[2]/a"));
        tlacitkoProgramovaniViceInformaci.click();
        WebElement tlacitkoJavaVytvoritPrihlasku = prohlizec.findElement(By.xpath("//div[2]/a"));
        tlacitkoJavaVytvoritPrihlasku.click();
        WebElement polickoVyberteTermin = prohlizec.findElement(By.className("bs-placeholder"));
        polickoVyberteTermin.click();
        WebElement polickoPrazdnyTermin = prohlizec.findElement(By.className("bs-searchbox"));
        polickoPrazdnyTermin.click();
        WebElement polickoKonkretniTermin = prohlizec.findElement(By.xpath("//*[@id=\"bs-select-1-0\"]"));
        polickoKonkretniTermin.click();
        WebElement polickoJmenoZaka = prohlizec.findElement(By.id("forename"));
        polickoJmenoZaka.sendKeys("Melichar");
        WebElement polickoPrijmeniZaka = prohlizec.findElement(By.id("surname"));
        polickoPrijmeniZaka.sendKeys("Test");
        WebElement polickoDatumNarozeniZaka = prohlizec.findElement(By.id("birthday"));
        polickoDatumNarozeniZaka.sendKeys("13.05.2010");
        WebElement zaskrtavaciPolickoPlatbaBankovnimPrevodem = prohlizec.findElement(By.xpath("//tr[8]/td[2]/span[1]/label"));
        zaskrtavaciPolickoPlatbaBankovnimPrevodem.click();
        WebElement zaskrtavaciPolickoSouhlasSPodminkami = prohlizec.findElement(By.xpath("//tr[11]/td[2]/span/label"));
        zaskrtavaciPolickoSouhlasSPodminkami.click();
        WebElement tlacitkoVytvoritPrihlasku = prohlizec.findElement(By.className("qa-submit-button"));
        tlacitkoVytvoritPrihlasku.click();
        //WebElement zalozkaPrihlasky = prohlizec.findElement(By.xpath("/html/body/div/header/div/nav/span[2]/a"));
        //zalozkaPrihlasky.click();

        WebElement potvrzeniPrihlasky = prohlizec.findElement(By.xpath("//*[text()='Stáhnout potvrzení o přihlášení']"));
        Assertions.assertNotNull(potvrzeniPrihlasky);

    }

    @Test
    public void zmenaHeslaUzivatele() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");
        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[2]/a"));
        tlacitkoPrihlasit.click();
        WebElement polickoEmail = prohlizec.findElement(By.id("email"));
        polickoEmail.sendKeys("panitestova@gmail.com");
        WebElement polickoHeslo = prohlizec.findElement(By.id("password"));
        polickoHeslo.sendKeys("DAczechitas2021");
        WebElement mensiTlacitkoPrihlasit = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div[3]/div/button"));
        mensiTlacitkoPrihlasit.click();
        WebElement tlacitkoJmenoUzivatele = prohlizec.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[2]/div/a"));
        tlacitkoJmenoUzivatele.click();
        WebElement tlacitkoProfil = prohlizec.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[2]/div/div/a[1]"));
        tlacitkoProfil.click();
        WebElement polickoZadejNoveHeslo = prohlizec.findElement(By.id("password"));
        polickoZadejNoveHeslo.sendKeys("TAczechitas2021");
        WebElement polickoZmenaHeslaKontrolaHesla = prohlizec.findElement(By.id("password-confirm"));
        polickoZmenaHeslaKontrolaHesla.sendKeys("TAczechitas2021");
        WebElement tlacitkoZmenit = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/form/div[4]/div/button"));
        tlacitkoZmenit.click();

    }

    @AfterEach
    public void tearDown() {
        prohlizec.close();
    }
}
