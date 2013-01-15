import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Example3_CopyLines {
    public static void main(String[] args) throws IOException {

        BufferedReader in = null;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new FileReader("xanadu.txt"));
            out = new PrintWriter(new FileWriter("output_lines.txt"));
            
            String l;
            while ((l = in.readLine()) != null) out.println(l);
        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }
}
