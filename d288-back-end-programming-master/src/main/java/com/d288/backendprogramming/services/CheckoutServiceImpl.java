package com.d288.backendprogramming.services;

import com.d288.backendprogramming.dao.CartRepo;
import com.d288.backendprogramming.dao.CustomerRepo;
import com.d288.backendprogramming.entities.Cart;
import com.d288.backendprogramming.entities.CartItem;
import com.d288.backendprogramming.entities.Customer;
import com.d288.backendprogramming.entities.StatusType;
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

        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cart::add);

        cart.setCartItem(purchase.getCartItems());
        cart.setCustomer(purchase.getCustomer());

        Customer customer = purchase.getCustomer();
        customer.add(cart);

        cart.setStatus(StatusType.ordered);

        cartRepo.save(cart);
        customerRepo.save(customer);

            return new PurchaseResponse(orderTrackingNumber);



    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }


}
