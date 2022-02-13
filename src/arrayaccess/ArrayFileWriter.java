package arrayaccess;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ArrayFileWriter {
    public static void write(Model model)
    {
        String data = model.toString();
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("src/numbers"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        try {
            writer.write(data);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
