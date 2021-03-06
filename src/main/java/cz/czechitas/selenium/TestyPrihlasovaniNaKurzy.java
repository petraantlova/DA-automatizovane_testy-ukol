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

        prihlaseniRodice();

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

        prihlaseniRodice();
        vyberTerminuKurzu();
        WebElement polickoJmenoZaka = prohlizec.findElement(By.id("forename"));
        polickoJmenoZaka.sendKeys("Melichar");
        WebElement polickoPrijmeniZaka = prohlizec.findElement(By.id("surname"));
        polickoPrijmeniZaka.sendKeys("Test" + System.currentTimeMillis());
        WebElement polickoDatumNarozeniZaka = prohlizec.findElement(By.id("birthday"));
        polickoDatumNarozeniZaka.sendKeys("12.05.2012");
        WebElement zaskrtavaciPolickoPlatbaHotove = prohlizec.findElement(By.xpath("//table/tbody/tr[8]/td[2]/span[4]/label"));
        zaskrtavaciPolickoPlatbaHotove.click();
        zaskrtniSouhlasSPodminkami();
        vytvorPrihlaskuNaKurz();

        WebElement potvrzeniPrihlasky = prohlizec.findElement(By.xpath("//*[text()='Stáhnout potvrzení o přihlášení']"));
        Assertions.assertNotNull(potvrzeniPrihlasky);
    }

    @Test
    public void prihlaseniRodiceVyberKurzuVytvoreniPrihlasky() {
        prohlizec.navigate().to(URL_APLIKACE);
        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.className("qa-login-button"));
        tlacitkoPrihlasit.click();

        prihlaseniRodice();
        WebElement zalozkaProRodice = prohlizec.findElement(By.className("qa-for-parents-button"));
        zalozkaProRodice.click();
        WebElement dropDownVytvoritPrihlasku = prohlizec.findElement(By.className("qa-new-application-button"));
        dropDownVytvoritPrihlasku.click();
        WebElement tlacitkoProgramovaniViceInformaci = prohlizec.findElement(By.xpath("//div[2]/a"));
        tlacitkoProgramovaniViceInformaci.click();
        WebElement tlacitkoJavaVytvoritPrihlasku = prohlizec.findElement(By.xpath("//div[2]/a"));
        tlacitkoJavaVytvoritPrihlasku.click();
        vyberTerminuKurzu();
        WebElement polickoJmenoZaka = prohlizec.findElement(By.id("forename"));
        polickoJmenoZaka.sendKeys("Melichar");
        WebElement polickoPrijmeniZaka = prohlizec.findElement(By.id("surname"));
        polickoPrijmeniZaka.sendKeys("Test" + System.currentTimeMillis());
        WebElement polickoDatumNarozeniZaka = prohlizec.findElement(By.id("birthday"));
        polickoDatumNarozeniZaka.sendKeys("13.05.2010");
        WebElement zaskrtavaciPolickoPlatbaBankovnimPrevodem = prohlizec.findElement(By.xpath("//tr[8]/td[2]/span[1]/label"));
        zaskrtavaciPolickoPlatbaBankovnimPrevodem.click();
        zaskrtniSouhlasSPodminkami();
        vytvorPrihlaskuNaKurz();

        WebElement potvrzeniPrihlasky = prohlizec.findElement(By.xpath("//*[text()='Stáhnout potvrzení o přihlášení']"));
        Assertions.assertNotNull(potvrzeniPrihlasky);
    }

    @Test
    public void zmenaHeslaUzivatele() {
        prohlizec.navigate().to(URL_APLIKACE);
        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.className("qa-login-button"));
        tlacitkoPrihlasit.click();

        prihlaseniRodice();
        WebElement tlacitkoJmenoUzivatele = prohlizec.findElement(By.className("qa-logged-in-username"));
        tlacitkoJmenoUzivatele.click();
        WebElement tlacitkoProfil = prohlizec.findElement(By.className("qa-user-profile-button"));
        tlacitkoProfil.click();
        WebElement polickoZadejNoveHeslo = prohlizec.findElement(By.id("password"));
        polickoZadejNoveHeslo.sendKeys("TAczechitas2021");
        WebElement polickoKontrolaHesla = prohlizec.findElement(By.id("password-confirm"));
        polickoKontrolaHesla.sendKeys("TAczechitas2021");
        WebElement tlacitkoZmenit = prohlizec.findElement(By.className("qa-login-button"));
        tlacitkoZmenit.click();
    }

    //metody
    public void prihlaseniRodice() {
        WebElement polickoEmail = prohlizec.findElement(By.id("email"));
        polickoEmail.sendKeys("panitestova@gmail.com");
        WebElement polickoHeslo = prohlizec.findElement(By.id("password"));
        polickoHeslo.sendKeys("DAczechitas2021");
        WebElement mensiTlacitkoPrihlasit = prohlizec.findElement(By.xpath("//button[contains (@class, 'qa-login-button')]"));
        mensiTlacitkoPrihlasit.click();
    }

    public void zaskrtniSouhlasSPodminkami() {
        WebElement zaskrtavaciPolickoSouhlasSPodminkami = prohlizec.findElement(By.xpath("//tr[11]/td[2]/span/label"));
        zaskrtavaciPolickoSouhlasSPodminkami.click();
    }

    public void vytvorPrihlaskuNaKurz() {
        WebElement tlacitkoVytvoritPrihlaskuNaKurz = prohlizec.findElement(By.className("qa-submit-button"));
        tlacitkoVytvoritPrihlaskuNaKurz.click();
    }

    public void vyberTerminuKurzu() {
        WebElement polickoVyberteTermin = prohlizec.findElement(By.className("bs-placeholder"));
        polickoVyberteTermin.click();
        WebElement polickoPrazdnyTermin = prohlizec.findElement(By.className("bs-searchbox"));
        polickoPrazdnyTermin.click();
        WebElement polickoKonkretniTermin = prohlizec.findElement(By.xpath("//*[@id=\"bs-select-1-0\"]"));
        polickoKonkretniTermin.click();
    }

    @AfterEach
    public void tearDown() {
        prohlizec.close();
    }
}
