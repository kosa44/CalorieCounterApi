package pl.kosa.caloriecounter.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.kosa.caloriecounter.model.Product;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {
    Product findByName(String name);

    void deleteByName(String name);
}
