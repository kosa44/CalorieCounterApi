package pl.kosa.caloriecounter.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.persistence.GeneratedValue;
import java.math.BigDecimal;

@Component
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId id;
    @NotBlank
    private String name;
    @PositiveOrZero
    private BigDecimal protein;
    @PositiveOrZero
    private BigDecimal carbohydrates;
    @PositiveOrZero
    private BigDecimal fat;
    @PositiveOrZero
    private BigDecimal calories;

    public Product() {

    }

    public Product(String name, BigDecimal protein, BigDecimal carbohydrates, BigDecimal fat) {
        this.name = name;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
        this.calories = (protein.multiply(new BigDecimal("4"))).add((carbohydrates.multiply(new BigDecimal("4"))).add(fat.multiply(new BigDecimal("9"))));
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getProtein() {
        return protein;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }

    public BigDecimal getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(BigDecimal carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public BigDecimal getFat() {
        return fat;
    }

    public void setFat(BigDecimal fat) {
        this.fat = fat;
    }

    public BigDecimal getCalories() {
        return calories;
    }

    public void setCalories(BigDecimal calories) {
        this.calories = calories;
    }

    public void update(Product product) {
        this.setName(product.getName());
        this.setProtein(product.getProtein());
        this.setCarbohydrates(product.getCarbohydrates());
        this.setFat(product.getFat());
        this.setCalories(product.getCalories());
    }
}
