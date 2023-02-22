package ICS.summative.FileSystem;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: Nazeem Naik
 * @Description: this class is used to read from a file
 */

public class FileRead {
    public void fileRead() {
        try {
            FileReader reader = new FileReader("SaveFile.txt");
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

