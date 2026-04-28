import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] curr = {"USD", "EUR", "GBP", "JPY", "CAD", "AUD", "CHF", "CNY", "INR", "MXN"};
        String[] sym = {"$", "€", "£", "¥", "C$", "A$", "Fr", "¥", "₹", "Mex$"};
        double[] rate = {1.0, 0.92, 0.79, 149.5, 1.36, 1.53, 0.88, 7.24, 94.21, 17.2};
        
        System.out.println("\n--- Currency Converter ---");
        for(int i=0; i<curr.length; i++)
            System.out.println((i+1)+". "+curr[i]+" ("+sym[i]+")");
        
        System.out.print("\nFrom: ");
        int from = sc.nextInt() - 1;
        System.out.print("To: ");
        int to = sc.nextInt() - 1;
        System.out.print("Amount: ");
        double amt = sc.nextDouble();
        
        double usdTo = rate[to] / rate[0];
        double fromTo = rate[from];
        double result = amt * (usdTo / fromTo);
        
        System.out.println("\n"+curr[from]+" "+String.format("%.2f", amt)+" = "+curr[to]+" "+String.format("%.2f", result));
        sc.close();
    }
}