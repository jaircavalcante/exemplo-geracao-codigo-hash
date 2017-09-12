import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class TestHashing {
	
	
	public static String gerarHash(String password) throws NoSuchAlgorithmException{
		
		MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(password.getBytes());
	    
	    byte byteData[] = md.digest();

	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < byteData.length; i++)
	        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	    
	    String chave = sb.toString();
		
	    return chave;
		
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		
		String password = "554986800001162016042513181";
		
		System.out.println("Chave:" + TestHashing.gerarHash(password));
	    
	    
		
	}
}
