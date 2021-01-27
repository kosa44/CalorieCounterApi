package pl.kosa.caloriecounter.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import static org.mockito.Mockito.verify;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kosa.caloriecounter.model.Product;
import pl.kosa.caloriecounter.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
public class ProductServiceTest {

    private Product milk;
    private Product rice;
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    public ProductService productService;

    @BeforeEach
    public void setUp() {
        milk = new Product("milk", new BigDecimal("1.1"), new BigDecimal("1.1"), new BigDecimal("1.1"));
        rice = new Product("rice", new BigDecimal("2.2"), new BigDecimal("2.2"), new BigDecimal("2.2"));
    }

    @AfterEach
    public void cleanUp() {
        productRepository.deleteAll();
    }

    @Test
    public void shouldSaveProducts() {
        productService.save(milk);
        productService.save(rice);
        verify(productRepository).save(milk);
        verify(productRepository).save(rice);
    }

    @Test
    public void shouldFindByName() {
        productService.save(milk);
        productService.getProductByName("milk");
        verify(productRepository).findByName("milk");
    }

    @Test
    public void shouldCallSaveMethod() {
        productService.save(milk);
        verify(productRepository).save(milk);
    }

    @Test
    public void shouldHaveEqualNamesAfterUpdate() {
        productService.save(milk);
        String name = "milk";
        productService.update(name, rice);
        verify(productRepository).findByName(name);
    }

    @Test
    public void shouldCallDeleteByName() {
        String name = "milk";
        productService.deleteByName(name);
        verify(productRepository).findByName(name);
    }
}
