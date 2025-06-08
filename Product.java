public class Product {
    private ProductService productService;
 
    public Product(){
        productService = new ProductService();
    }

    public Product(String ID, String name, String description, String price, String disPrice, Trader trader, Category category){
        productService = new ProductService(ID, name, description, price, disPrice, trader, category);
    }
}
