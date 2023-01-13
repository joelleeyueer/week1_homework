package shopping_cart;

import java.util.*;

public class Directory{
    private static Map<String, ArrayList<String>> customerDirectory;
    private static List<String> shoppingCart;


    public Directory() {
        customerDirectory = new HashMap<>();
    }

    public Map<String, ArrayList<String>> getCustomerDirectory() {
        return customerDirectory;
    }
    public int getSDSize(){
        return customerDirectory.size();
    }

    public static void addCustomer(String customer){
        customerDirectory.put(customer, new ArrayList<>());
    }


    public void delete(String cartOwner){
        customerDirectory.remove(cartOwner);
        customerList.remove(cartOwner);
    }

    public void delete(int index){
        String owner = customerDirectory.get(index).getCartOwner();
        customerDirectory.remove(index);
        customerList.remove(owner);
    }
}
