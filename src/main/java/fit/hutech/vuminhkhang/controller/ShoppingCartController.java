package fit.hutech.vuminhkhang.controller;

import fit.hutech.vuminhkhang.model.CartItem;
import fit.hutech.vuminhkhang.model.Product;
import fit.hutech.vuminhkhang.service.ProductService;
import fit.hutech.vuminhkhang.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("shoppingcart")
public class ShoppingCartController {
    @Autowired
    ProductService productService;
    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("view")
    public String viewCart(Model model){
        model.addAttribute("all_items_in_shoppingcart",shoppingCartService.getAllItems());
        model.addAttribute("total_amount",shoppingCartService.getAmount());
        return "view_shoppingcart";
    }

    @GetMapping("/add/{id}")
    public String addItem(@PathVariable("id") Integer id){
        Product product = productService.getProductById(id);
        if(product != null){
            CartItem item = new CartItem();
            item.setProductId(product.getId());
            item.setName(product.getName());
            item.setPrice(product.getPrice());
            item.setQuantity(1);
            shoppingCartService.add(item);
        }
        return "redirect:/shoppingcart/view";
    }

    @GetMapping("clear")
    public String clearCart(){
        shoppingCartService.Clear();
        return "redirect:/shoppingcart/view";
    }

    @GetMapping("remove/{id}")
    public String removeItem(@PathVariable("id") Integer id){
        shoppingCartService.remove(id);
        return "redirect:/shoppingcart/view";
    }

    @PostMapping("update")
    public String updateItem (@RequestParam("productId") Integer productId, @RequestParam("quantity") Integer quantity){
        shoppingCartService.update(productId,quantity);
        return "redirect:/shoppingcart/view";
    }
}
