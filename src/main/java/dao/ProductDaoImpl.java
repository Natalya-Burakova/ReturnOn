package dao;

import db.ProductDB;
import model.Product;

import java.util.ArrayList;

public class ProductDaoImpl implements ProductDao{

    private ProductDB productDB;

    private ArrayList<String> allProducts;

    public ProductDaoImpl() {
        productDB = ProductDB.getInstance();
        allProducts  = new ArrayList<>();
    }

    @Override
    public boolean isExistProduct(Product model) {
        return allProducts.contains(model.getName());
    }

    @Override
    public int save(Product model) {
        if (!isExistProduct(model)) {
            allProducts.add(model.getName());
            return 1;
        }
        return 0;
    }

    @Override
    public int saveInPurchase(Product model) {
        if (isExistProduct(model)) {
            productDB.getDbPurchase().add(model);
            return 1;
        }
        return 0;
    }

    @Override
    public int saveInDemand(Product model) {
        if (isExistProduct(model)) {
            int count = 0;
            for (Product product : productDB.getDbPurchase()) {
                if (product.getName().equals(model.getName()) &&
                        product.getPrice()<=model.getPrice() &&
                        (product.getDate().isBefore(model.getDate()) || product.getDate().isEqual(model.getDate()))) {
                        count+=product.getAmount();
                }
            }
            if (count>=model.getAmount()) {
                productDB.getDbDemand().add(model);
                return 1;
            }
            else return 0;
        }
        return 0;
    }

    @Override
    public Float profit(Product model) {
        if (isExistProduct(model)) {
            Float profit = 0.0f;
            Integer count = 0;

            for (Product product1: productDB.getDbDemand()) {
                System.out.println(model.getName() + " "+model.getDate());
                    if (product1.getName().equals(model.getName()) && (product1.getDate().isBefore(model.getDate()) || product1.getDate().isEqual(model.getDate())) ) {
                        profit += product1.getPrice()* product1.getAmount();
                        count += product1.getAmount();
                    }

            }
            for (Product product : productDB.getDbPurchase()) {
                    if (product.getName().equals(model.getName()) && (product.getDate().isBefore(model.getDate()) || product.getDate().isEqual(model.getDate()))) {
                        if (count>0) {
                            if (count>=product.getAmount()) {
                                profit -= product.getAmount() * product.getPrice();
                                count -= product.getAmount();
                            }
                            else {
                                profit -= count * product.getPrice();
                                count -= count;
                            }
                        }
                    }
            }

            if (profit!=0.0f && count==0) return profit;
            else return null;
        }
        return null;
    }

    @Override
    public int update(Product model) { return 0; }

    @Override
    public int delete(Product model) { return 0; }
}
