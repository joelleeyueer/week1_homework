package shopping_cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class MainSC {

    public static void main(String[] args) {
    Directory d = new Directory();
    Cart c = new Cart();
    d.addCustomer(new Cart("bob", new ArrayList<>()));
    d.addCustomer(new Cart("cathy", new ArrayList<>()));
    System.out.println(d.getSDSize());
//    Cart cart1 = new Cart("joel", new ArrayList<>());
//
    String currCustomer = "bob";
//
//    d.getCustomerDirectory().get(currIndex).addToCart("apples");


    }
}
