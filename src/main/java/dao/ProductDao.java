package dao;

import model.Product;

public interface ProductDao extends CRUDDao<Product> {
    boolean isExistProduct(Product model);
    int saveInPurchase(Product model);
    int saveInDemand(Product model);
    Float profit(Product model);
}