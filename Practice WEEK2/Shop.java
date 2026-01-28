public class Shop {
    String name;
    Product [] productList;
    int productCount = 0;


    public Shop() {
        productCount = 0;

        
    }

    public Shop(String name,Product[]list) {
        this.name = name;
        this.productlist = list;
        this.productCount = 0;


    }
    
    public void addProduct(Product product) {
        productlist[productCount] = product;
        productCount++;

    }
    public void displayProducts () {
        for(int i = 0; i < productList.length; i++) {
            if(productList[i] != null)
            System.out.println(productList[I]);
        }
       


    
}
