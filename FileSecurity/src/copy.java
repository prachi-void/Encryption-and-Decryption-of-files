

import java.io.File;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class copy 
{
    public  void copy(String object)
    {	
    	FileInputStream instream = null;
	FileOutputStream outstream = null;
 
    	try{
    	    File infile =new File("C:\\Users\\username\\Desktop\\encrptText.txt");
    	    File outfile =new File(object);
    	    
 
    	    instream = new FileInputStream(infile);
    	    outstream = new FileOutputStream(outfile);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    /*copying the contents from input stream to
    	     * output stream using read and write methods
    	     */
    	    while ((length = instream.read(buffer)) > 0){
    	    	outstream.write(buffer, 0, length);
    	    }

    	    //Closing the input/output file streams
    	    instream.close();
    	    outstream.close();

    	    //System.out.println("File copied successfully!!");
    	   DeleteFile deletefile=new DeleteFile();
    	   deletefile.DeleteFile("C:\\Users\\Prachi\\Desktop\\encrptText.txt");
    	    	
 
    	}catch(IOException ioe){
    		ioe.printStackTrace();
    	 }
    }
 
		
	}
