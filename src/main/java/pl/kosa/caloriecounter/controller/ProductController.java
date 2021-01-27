package pl.kosa.caloriecounter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.kosa.caloriecounter.model.Product;
import pl.kosa.caloriecounter.service.ProductService;

import java.util.List;

@RestController("/")
public class ProductController {

    private ProductService productService;

    @Autowired
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("products/{name}")
    public Product getProductName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @PostMapping(consumes="application/json")
//    @Transactional
    public void saveProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @PutMapping("products/{name}")
//    @Transactional
    public void updateProduct(@PathVariable String toBeUpdatedByName, @RequestBody Product update) {
        productService.update(toBeUpdatedByName, update);
    }

    @DeleteMapping("products/{name}")
//    @Transactional
    public void deleteProduct(@PathVariable String name) {
        productService.deleteByName(name);
    }
}
