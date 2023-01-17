package com.tienda;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tienda.dto.PricesDto;
import com.tienda.service.PricesService;

/**
 * @author Yoan Hernandez
 * @date 17 ene 2023
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WsTiendaApplicationTests {
    @Autowired
    private PricesService pricesService;

    /**
     * Prueba 1
     */
    @Test
    public void test1() {
        PricesDto testDto = new PricesDto(35455L, 1L, "2020-06-14 10:00:00");
        PricesDto testResult = this.pricesService.salePrice(testDto).getPrice();
        assertTrue((testResult.getRate() + "->" + testResult.getPrice().setScale(2)).equals("TARIFA 1->35.50"));
    }

    /**
     * Prueba 2
     */
    @Test
    public void test2() {
        PricesDto testDto = new PricesDto(35455L, 1L, "2020-06-14 16:00:00");
        PricesDto testResult = this.pricesService.salePrice(testDto).getPrice();
        assertTrue((testResult.getRate() + "->" + testResult.getPrice().setScale(2)).equals("TARIFA 2->25.45"));
    }

    /**
     * Prueba 3
     */
    @Test
    public void test3() {
        PricesDto testDto = new PricesDto(35455L, 1L, "2020-06-14 21:00:00");
        PricesDto testResult = this.pricesService.salePrice(testDto).getPrice();
        assertTrue((testResult.getRate() + "->" + testResult.getPrice().setScale(2)).equals("TARIFA 1->35.50"));
    }

    /**
     * Prueba 4
     */
    @Test
    public void test4() {
        PricesDto testDto = new PricesDto(35455L, 1L, "2020-06-15 10:00:00");
        PricesDto testResult = this.pricesService.salePrice(testDto).getPrice();
        assertTrue((testResult.getRate() + "->" + testResult.getPrice().setScale(2)).equals("TARIFA 3->30.50"));
    }

    /**
     * Prueba 5
     */
    @Test
    public void test5() {
        PricesDto testDto = new PricesDto(35455L, 1L, "2020-06-16 21:00:00");
        PricesDto testResult = this.pricesService.salePrice(testDto).getPrice();
        assertTrue((testResult.getRate() + "->" + testResult.getPrice().setScale(2)).equals("TARIFA 4->38.95"));
    }
}
