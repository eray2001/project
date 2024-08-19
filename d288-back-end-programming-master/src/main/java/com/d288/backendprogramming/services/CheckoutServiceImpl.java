package com.d288.backendprogramming.services;

import com.d288.backendprogramming.dao.CartRepo;
import com.d288.backendprogramming.dao.CustomerRepo;
import com.d288.backendprogramming.entities.Cart;
import com.d288.backendprogramming.entities.CartItem;
import com.d288.backendprogramming.entities.Customer;
import com.d288.backendprogramming.entities.STATUSTYPE;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepo customerRepo;
    private CartRepo cartRepo;



    public CheckoutServiceImpl(CustomerRepo customerRepo, CartRepo cartRepo){
        this.customerRepo = customerRepo;
        this.cartRepo = cartRepo;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Cart cart = purchase.getCart();

        String cartTrackingNumber = generateCartTrackingNumber();
        cart.setOrderTrackingNumber(cartTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        cart.setCartItem(purchase.getCartItems());
        cart.setCustomer(purchase.getCustomer());

        Customer customer = purchase.getCustomer();
        customer.add(cart);

        cartRepo.save(cart);
        customerRepo.save(customer);

        cart.setStatus(STATUSTYPE.ordered);

        return new PurchaseResponse(cartTrackingNumber);
    }

    private String generateCartTrackingNumber() {
        return UUID.randomUUID().toString();
    }


}
