import java.util.ArrayList;
import java.util.Scanner;

public class shyam {
    static Scanner ip = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> sales = new ArrayList<>();
        ArrayList<Integer> purchase = new ArrayList<>();
        int saleCount = ip.nextInt();
        int purchaseCount = ip.nextInt();
        int total_sale = 0;
        int total_purchase = 0;
        int profit=0;
        boolean sale = false, purch = false,prof=false;
        for (int i = 0; i < saleCount; i++) {
            int data = ip.nextInt();
            sales.add(data);
        }
        for (int i = 0; i < purchaseCount; i++) {
            int data = ip.nextInt();
            purchase.add(data);
        }
        String to_do = ip.nextLine();
        if (to_do.equals("sales")) {
            for (int i = 0; i < saleCount; i++) {
                total_sale += sales.get(i);
            }
            sale = true;
        } else if (to_do.equals("purchase")) {
            for (int i = 0; i < purchaseCount; i++) {
                total_purchase += purchase.get(i);
            }
            purch = true;
        } else if (to_do.equals("profit")) {
            profit = total_sale - total_purchase;
            System.out.println(profit);
            prof = true;
        } else if (to_do.equals("showSales")) {
            if (!sale) {
                for (int i = 0; i < saleCount; i++) {
                    total_sale += sales.get(i);
                }
            }
            System.out.println(total_sale);
        } else if (to_do.equals("showPurchase")) {
            if (!purch) {
                for (int i = 0; i < purchaseCount; i++) {
                    total_purchase += purchase.get(i);
                }
            }
            System.out.println(total_purchase);
        }else if(to_do.equals("showProfit")){
            if(!prof){
                profit = total_sale-total_purchase;
            }
            System.out.println(profit);
        }
    }
}
