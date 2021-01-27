package pl.kosa.caloriecounter.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductTest {

    @Test
    public void shouldHaveEqualNamesAfterUpdate() {
        Product milk = new Product("milk", new BigDecimal("1.1"), new BigDecimal("1.1"), new BigDecimal("1.1"));
        Product rice = new Product("rice", new BigDecimal("2.2"), new BigDecimal("2.2"), new BigDecimal("2.2"));

        milk.update(rice);
        Assertions.assertEquals("rice", milk.getName());
    }
}
