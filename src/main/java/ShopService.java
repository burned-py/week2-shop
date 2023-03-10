import java.util.ArrayList;
import java.util.List;

public class ShopService {

    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Order orderProducts(List<String> productIds, String id) {
        List<Product> productsToOrder = new ArrayList<>();
        for (String productId : productIds) {
            Product productToAdd = getProduct(productId);
            productsToOrder.add(productToAdd);
        }
        return orderRepo.addOrder(new Order(id, productsToOrder));
    }

    Product getProduct(String productId) {
        return productRepo.getProduct(productId);
    }

    public List<Order> listOrders() {
        return orderRepo.listOrders();
    }
}
