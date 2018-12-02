import model.Product;
import services.ProductService;

import java.util.Scanner;

public class Main {

    private static ProductService productService = new ProductService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду (eсли хотите завершить ввод, введите EXIT):  ");
            String[] command = scanner.nextLine().split(" ");

            if (command.length == 1) {
                if (command[0].toUpperCase().equals("EXIT")) break;
                else System.out.println("ERROR");
            }
            else if (command.length == 2) {
                if (command[0].toUpperCase().equals("NEWPRODUCT")) {
                    if (productService.newproduct(command[1])) System.out.println("OK");
                    else System.out.println("ERROR");
                }
                else System.out.println("ERROR");
            }
            else if (command.length == 3) {
                if (command[0].toUpperCase().equals("SALESREPORT")) {
                    Float result = productService.salesreport(command[1],command[2]);
                    if (result!=null) System.out.println(result);
                    else System.out.println("ERROR");
                }
                else System.out.println("ERROR");
            }
            else if (command.length == 5) {
                if (command[0].toUpperCase().equals("DEMAND")) {
                    if (productService.demand(command[1],command[2], command[3], command[4])) System.out.println("OK");
                    else System.out.println("ERROR");
                }
                else if (command[0].toUpperCase().equals("PURCHASE"))  {
                    if (productService.purchase(command[1],command[2], command[3], command[4])) System.out.println("OK");else System.out.println("ERROR");

                }
                else System.out.println("ERROR");
            }
            else System.out.println("ERROR");
        }
    }


}
