import java.io.*;
import java.util.Scanner;

public class ProductService { 
    private String ID;
    private String name;
    private String description;
    private String price;
    private String disPrice;//discounted price
    private Trader trader;
    private Category category;

    public ProductService(){

    }

    public ProductService(String ID, String name, String description, String price, String disPrice, Trader trader, Category category){
        Scanner sc = null;
        try {
            sc = new Scanner(new File("Product.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        while(sc.hasNextLine()){
            if(ID.equals(sc.nextLine())){
                throw new IllegalStateException("There is already a product with this ID");
            }
        }

        this.ID = ID;
        this.name = name;
        this.disPrice = disPrice;
        this.description = description;
        this.trader = trader;
        this.price = price;
        this.category = category;

        BufferedWriter p = null;
        try {
            p = new BufferedWriter(new FileWriter("Product.txt", true));

            p.append(ID + '\n');
            p.append(name + '\n');
            p.append(price + '\n');
            p.append(disPrice + '\n');
            p.append(description + '\n');
            p.append(trader.getName() + '\n');

            p.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        sc.close();
    }

    public String getDisPrice() {
        return disPrice;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public Trader getTrader() {
        return trader;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

}
