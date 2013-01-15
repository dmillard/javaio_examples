import java.io.*;

public class Example6_DataStreams {
    public static void main(String[] args) throws IOException {

        DataOutputStream out = null;

        final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
        final int[] units = {12, 8, 13, 29, 50 };
        final String[] descs = {
            "UGA T-Shirt",
            "UGA Mug",
            "Stuffed Bulldog",
            "UGA Pin",
            "UGA Key Chain"
        };

        try {
            out = new DataOutputStream(new BufferedOutputStream(
                        new FileOutputStream("output_datastream")));
            for(int i = 0; i < prices.length; i++) {
                out.writeDouble(prices[i]);
                out.writeInt(units[i]);
                out.writeUTF(descs[i]);
            }
        } finally {
            if(out != null) out.close();
        }

        DataInputStream in = null;

        double price;
        int unit;
        String desc;
        double total = 0.0;

        try {
            in = new DataInputStream(new BufferedInputStream(
                        new FileInputStream("output_datastream")));
            while(true) {
                price = in.readDouble();
                unit = in.readInt();
                desc = in.readUTF();
                System.out.format("You ordered %d units of %s at $%.2f%n",
                        unit, desc, price);
                total += unit * price;
            }
        } catch (EOFException e) {
        } finally {
            if(in != null) in.close();
        }
    }
}
