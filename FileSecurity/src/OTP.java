

import java.util.*; 

public class OTP 
{ 
	static String otp=new String();
    static String generateOTP()
    
    { 
    	int len=4;
        // Using numeric values 
        String numbers = "0123456789"; 
  
        // Using random method 
        Random rndm_method = new Random(); 
  
       // char [] otp = new char[len]; 
        
  
        for (int i = 0; i < len; i++) 
        { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            otp+=
             numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
        return otp; 
    } 
   /* public static void main(String[] args) 
    { 
      int length = 4; 
       System.out.println(generateOTP()); 
    } */
} 