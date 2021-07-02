package SoftAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAsserts {

    @Test
    public void testAsserts(){
        SoftAssert softAssert = new SoftAssert();

        //Assert.assertFalse(1 < 5, "1 es menor que 5");
        softAssert.assertTrue(10 > 12, "10 no es mayor a 12");
        softAssert.assertEquals("Hola", "Mundo", "Se esperaba encontrar a Mundo pero no fue asi");
        softAssert.assertNotEquals("Hola", "Hola","No se esperaba Hola, pero se obtuvo Hola" );
        softAssert.assertTrue("hola".contains("x"), "No se encontro la letra x dentro de la palabra hola");

        System.out.println("Fin del metodo de test");
        //softAssert.assertAll();
    }


}