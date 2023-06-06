package fit.hutech.vuminhkhang.service;

import fit.hutech.vuminhkhang.model.Product;
import fit.hutech.vuminhkhang.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServieImp  implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public Product getProductById(int id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = null;
        if(optional.isPresent()){
            product = optional.get();
        }
        else {
            throw new RuntimeException("Product not found for id ::" +id);
        }
        return product;
    }

    @Override
    public void deleteProduct(int id) {
        this.productRepository.deleteById(id);
    }
}