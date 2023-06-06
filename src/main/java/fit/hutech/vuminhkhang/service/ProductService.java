package fit.hutech.vuminhkhang.service;

import java.util.List;
import fit.hutech.vuminhkhang.model.Product;

public interface ProductService
{
    List<Product> getAllProducts();
    void saveProduct(Product product);
    Product getProductById(int id);
    void deleteProduct(int id);
}
