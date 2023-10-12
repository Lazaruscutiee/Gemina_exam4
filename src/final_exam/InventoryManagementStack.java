import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Acer
 */
class Product {
    private String name;
    private int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
public class InventoryManagementStack {

    private Stack<Product> inventoryStack;

    public InventoryManagementStack() {
        inventoryStack = new Stack<>();
    }

    public void addProduct(String productName, int quantity) {
        Product product = new Product(productName, quantity);
        inventoryStack.push(product);
    }

    public void sellProduct(String productName, int quantity) {
        Product product = inventoryStack.pop();
        if (product != null && product.getName().equals(productName)) {
            product.setQuantity(product.getQuantity() - quantity);
            if (product.getQuantity() > 0) {
                inventoryStack.push(product);
            }
        } else {
            throw new IllegalArgumentException("Product not found in inventory: " + productName);
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Product product:  inventoryStack) {
            System.out.println(product.getName()+ "\t\t\t" + product.getQuantity());
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        InventoryManagementStack stack = new InventoryManagementStack();
       
        while(true){
        System.out.println("     *Gemina Store*  ");
        System.out.println("1. Add product");
        System.out.println("2. Sell product");
        System.out.println("3. Display inventory");

      
        int choice = scn.nextInt();

        switch (choice) {
            case 1:
               
                System.out.println("Enter Product to add: ");
                String productName = scn.next();
                System.out.println("Enter the Quantity of the product: ");
                int quantity = scn.nextInt();
                stack.addProduct(productName, quantity);
                break;
            case 2:             
                System.out.println("Enter the name of the product to sell: ");
                productName = scn.next();
                System.out.println("Enter the quantity of the product to sell: ");
                quantity = scn.nextInt();
                stack.sellProduct(productName, quantity);
                break;
            case 3:            
                stack.displayInventory();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}

}