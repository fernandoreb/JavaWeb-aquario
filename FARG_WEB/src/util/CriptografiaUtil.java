package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaUtil {
	
	public static String gerarSenhaSHA256(String senha) {

		try{
			
			MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");

			algoritmo.update(senha.getBytes());
	
			String senhaEncriptada = new BigInteger(1, algoritmo.digest()).toString(16);
			
			return senhaEncriptada;
	
		}
		catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return senha; 
	}
}

