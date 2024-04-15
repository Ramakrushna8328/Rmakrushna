package menuberger;

import java.io.File;
import java.io.PrintWriter;

public class CreateFile {

	public static void main(String[] args) {
		

        try { 
  
            // Get the file 
            File f = new File("D:\\NEW4FDOLDER.txt"); 
           
            System.out.println("length: " + f.length());
            // Create new file 
            // if it does not exist 
            if (f.createNewFile()) 
                System.out.println("File created"); 
            else
                System.out.println("File already exists"); 
        } 
        catch (Exception e) { 
            System.err.println(e); 
        } 
		

	}

}
