package tw.teddysoft.bdd.domain.invoice;

/**
 * Created by jay on 2017/3/29.
 */
public class Main {
    public static void main(String[] args) {
        double vatRate = 0;
        int excludedPrice = 0;
        int includedPrice = 0;
        Invoice invoice = null;
        for(int i = 0; i < args.length; i = i + 2){
           if(args[i].equals("-r")){
                vatRate = Double.parseDouble(args[i+1]);
           }
           else if(args[i].equals("-i")){
               excludedPrice = 0;
               includedPrice = Integer.parseInt(args[i+1]);
           }
           else if(args[i].equals("-e")){
                includedPrice = 0;
                excludedPrice = Integer.parseInt(args[i+1]);
            }
            else if(args[i].equals("-h")){
               System.out.println("-r       setting vatRate");
               System.out.println("-i       setting TaxIncludedPrice");
               System.out.println("-e       setting TaxExcludedPrice");
               System.exit(0);
           }
           else{
                System.out.println("Usage -h to know how to use");
           }
        }

        if(includedPrice != 0){
            invoice = InvoiceBuilder.newInstance().
                    withVatRate(vatRate).
                    withTaxIncludedPrice(includedPrice).
                    issue();
        }
        else if(excludedPrice != 0){
            invoice = InvoiceBuilder.newInstance().
                    withVatRate(vatRate).
                    withTaxExcludedPrice(excludedPrice).
                    issue();
        }
        else{
            System.out.println("請輸入含稅價格或者未稅價格");
            System.exit(0);
        }
        System.out.println("TaxIncludedPrice: " + invoice.getTaxIncludedPrice());
        System.out.println("VatRate: " + invoice.getVatRate());
        System.out.println("Vat: " + invoice.getVAT());
        System.out.println("TaxExcludedPrice: " + invoice.getTaxExcludedPrice());
    }
}
