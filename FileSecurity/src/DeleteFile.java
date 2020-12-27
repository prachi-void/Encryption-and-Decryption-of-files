

import java.io.File;

public class DeleteFile {
	
	public static  boolean DeleteFile(String file)
	{         
	File f= new File(file);           //file to be delete  
	if(f.delete())                      //returns Boolean value  
	{  
	//System.out.println(f.getName() + " deleted");   //getting and printing the file name
		return true;
	}  
	else  
	{  
	//System.out.println("failed");  
		return false;
	}   
}

	

}
