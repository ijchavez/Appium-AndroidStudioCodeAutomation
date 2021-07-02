package PruebasSeleniumWebDriver;

import org.testng.annotations.Test;

public class PrimerTest extends BaseTest{

    @Test
    public void primerTest(){
        System.out.println(driver.getCurrentUrl());

    }

}
