package menuberger;

import java.io.FileInputStream;
import java.io.IOException;

public class fileinputstream {

	public static void main(String[] args)throws IOException 
	{
	
	      try{    
	            FileInputStream input=new FileInputStream("D:\\New folder\\java.txt");    
	          // int i=input.read(); 
	      
	           int i =input.available();
	            System.out.println("char= " +i);    
	            byte[]content=new byte[15];
	      
	            input.read(content);
	            String fileContent = new String(content);
	            System.out.println("file content = " + fileContent);
	  
	             input.close();
	             System.out.println("file has been closed");
	          }
	      catch(Exception e)
	      {
	    	  System.out.println(e);
	    	  }    
	         }    
	}


