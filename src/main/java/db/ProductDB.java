package db;

import model.Product;


import java.util.Comparator;
import java.util.PriorityQueue;

public class ProductDB {

    private PriorityQueue<Product> dbPurchase;
    private PriorityQueue<Product> dbDemand;
    private static ProductDB ourInstance = new ProductDB();

    public static ProductDB getInstance() { return ourInstance; }

    private ProductDB() {
        Comparator<Product> comparator = ((o1, o2) -> {
            if (o1.getDate().isEqual(o2.getDate())) return 0;
            else if (o1.getDate().isBefore(o2.getDate())) return -1;
            else return 1;
        });
        this.dbPurchase= new PriorityQueue<Product>(comparator);
        this.dbDemand = new PriorityQueue<Product>(comparator);
    }

    public PriorityQueue<Product> getDbDemand() {
        return dbDemand;
    }

    public PriorityQueue<Product> getDbPurchase() {
        return dbPurchase;
    }

}
