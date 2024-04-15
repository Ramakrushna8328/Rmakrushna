package menuberger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileoutputStream {

	public static void main(String[] args) throws FileNotFoundException 
	{
		
		try {
      FileOutputStream fos= new FileOutputStream(" myfile15.txt");
    //  PrintWriter pw=new PrintWriter(fos);
     // pw.println("i love this article");
     // pw.println(100);
      //pw.close();
    
      System.out.println(" file created");
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
	}

}
