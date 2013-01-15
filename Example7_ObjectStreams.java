import java.io.*;
import java.math.BigDecimal;

public class Example7_ObjectStreams {
    public static void main(String[] args)
        throws IOException, ClassNotFoundException {

        final BigDecimal[] prices = {
            new BigDecimal("19.99"),
            new BigDecimal("9.99"),
            new BigDecimal("15.99"),
            new BigDecimal("3.99"),
            new BigDecimal("4.99"),
        };

        ObjectOutputStream out = null;
        
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(
                        new FileOutputStream("output_objectstream")));
            for(int i =0; i < prices.length; i++) out.writeObject(prices[i]);
        } finally {
            if(out != null) out.close();
        }

        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream(new BufferedInputStream(
                        new FileInputStream("output_objectstream")));

            BigDecimal price;
            try {
                while(true) {
                    price = (BigDecimal) in.readObject();
                    System.out.format("Price: $%.2f%n", price);
                }
            } catch (EOFException e) {}
        } finally {
            if(in != null) in.close();
        }
    }
}
