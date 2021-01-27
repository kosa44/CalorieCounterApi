package pl.kosa.caloriecounter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.kosa.caloriecounter.model.Product;
import pl.kosa.caloriecounter.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    // should be final?
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void setup() {
        productRepository.deleteAll();
        Product milk = new Product("milk", new BigDecimal("1.1"), new BigDecimal("1.1"), new BigDecimal("1.1"));
        Product rice = new Product("rice", new BigDecimal("2.2"), new BigDecimal("2.2"), new BigDecimal("2.2"));
        this.save(milk);
        this.save(rice);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public void update(String name, Product update) {
//        Optional<Product> toBeUpdated = productRepository.findAll().stream().filter(element -> element.getName().equals(name)).findFirst();
//        toBeUpdated.ifPresentOrElse(product -> product.update(update), () -> System.out.println("No product with name "+name+" exists!"));
        productRepository.findByName(name).update(update);
    }

    public void deleteByName(String name) {
        productRepository.delete(productRepository.findByName(name));
//        ifPresentOrElse(product -> productRepository.deleteByName(name), () -> System.out.println("No product with name "+name+" exists!"));
    }
}
