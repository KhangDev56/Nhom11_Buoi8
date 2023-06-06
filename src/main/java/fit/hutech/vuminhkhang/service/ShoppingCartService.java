package fit.hutech.vuminhkhang.service;

import fit.hutech.vuminhkhang.model.CartItem;

import java.util.Collection;

public interface ShoppingCartService {
    void add(CartItem newItem);
    void remove(int id);
    CartItem update(int productID, int quantity);
    void Clear();
    double getAmount();
    int getCount();
    Collection<CartItem> getAllItems();
}
