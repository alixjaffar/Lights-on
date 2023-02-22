package ICS.summative.FileSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileWrite {

/**
 * @Author: Ali Jaffar
 * @Description: this class is used to write to a file
 */

    File file;
    FileWriter fw;
    
    public FileWrite(){
        file = new File("SaveFile.txt");
        try{
            if (!file.exists()) {
                System.out.println("File exists");
                file.createNewFile();
                } 
            fw = new FileWriter("SaveFile.txt" , true);
        } catch (Exception e){
            e.printStackTrace();
        }
        // write
}
}