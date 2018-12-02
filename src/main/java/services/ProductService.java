package services;

import dao.ProductDao;
import dao.ProductDaoImpl;
import model.Product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductService {

    private ProductDao productDao;

    public ProductService() { productDao = new ProductDaoImpl(); }

    public boolean newproduct(String name){ return productDao.save(new Product(name)) == 1? true: false; }

    public boolean purchase(String name, String amount, String price, String date){
        try {
            Integer amountPr = Integer.parseInt(amount);
            Float pricePr = Float.parseFloat(price);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate datePr = LocalDate.parse(date, dateTimeFormatter);
            if (pricePr > 0 && amountPr > 0) {
                Product product = new Product(name, amountPr, pricePr, datePr);
                if (productDao.isExistProduct(product))
                    return  productDao.saveInPurchase(product) == 1? true: false;
                else return false;
            }
            else return false;
        }
        catch (Exception e) { return false; }
    }

    public boolean demand(String name, String amount, String price, String date){
        try {
            Integer amountPr = Integer.parseInt(amount);
            Float pricePr = Float.parseFloat(price);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate datePr = LocalDate.parse(date, dateTimeFormatter);
            if (pricePr > 0 && amountPr > 0) {
                Product product = new Product(name, amountPr, pricePr, datePr);
                if (productDao.isExistProduct(product)) return  productDao.saveInDemand(product) == 1? true: false;
                else return false;
            }
            else return false;
        }
        catch (Exception e) { return false; }
    }

    public Float salesreport(String name, String date){
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate datePr = LocalDate.parse(date, dateTimeFormatter);
            Product product = new Product(name, datePr);
            if (productDao.isExistProduct(product)) return productDao.profit(product);
            else return null;
        }
        catch (Exception e) { return null;}
    }

}
