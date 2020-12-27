

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class EncrptionDemo{

	
	  // static BrowseFile browse=new BrowseFile();
	
		// TODO Auto-generated method stub
		public static void encryptDecrypt(String key,int ciphermode,String object,String object2) 
				throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException,
				NoSuchPaddingException, IOException
		{
			FileInputStream filein=new FileInputStream(object);
			FileOutputStream fileout=new FileOutputStream(object2);
			
			DESKeySpec deskeyspec=new DESKeySpec(key.getBytes());
			
			SecretKeyFactory skf=SecretKeyFactory.getInstance("DES");
			SecretKey secretkey=skf.generateSecret(deskeyspec);
			
			Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
			
			if(ciphermode==Cipher.ENCRYPT_MODE)
			{
				cipher.init(Cipher.ENCRYPT_MODE,secretkey,SecureRandom.getInstance("SHA1PRNG"));
				CipherInputStream cis=new CipherInputStream(filein,cipher);
				write(cis,fileout);
			}
			else if(ciphermode==Cipher.DECRYPT_MODE)
			{
				cipher.init(cipher.DECRYPT_MODE,secretkey, SecureRandom.getInstance("SHA1PRNG"));
				CipherOutputStream cos=new CipherOutputStream(fileout,cipher);
				write(filein,cos);
			}
			
			
			
		}

		private static void write(InputStream in, OutputStream out) throws IOException {
			// TODO Auto-generated method stub
			byte[] buffer =new byte[64];
			int numOfBytedRead;
			while((numOfBytedRead=in.read(buffer))!= -1)
					{
				out.write(buffer,0,numOfBytedRead);
					}
			out.close();
			in.close();
			
		}

		public static void main(String[] args) 
				throws InvalidKeyException, NoSuchAlgorithmException,
				InvalidKeySpecException, NoSuchPaddingException, IOException
		{
			
			
		  
		}


		

	}

