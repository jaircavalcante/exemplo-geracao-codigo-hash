import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

	private static MessageDigest md = null;
	
	//M�todo para gera��o do algoritmo
	static {
		try {
			//M�todo getInstance da classe MessageDigest
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
	}

	//M�todo para gerar a chave
	private static char[] hexCodes(byte[] text) {
		char[] hexOutput = new char[text.length * 2];
		String hexString;

		for (int i = 0; i < text.length; i++) {
			hexString = "00" + Integer.toHexString(text[i]);
			hexString.toUpperCase().getChars(hexString.length() - 2,
					hexString.length(), hexOutput, i * 2);
		}
		return hexOutput;
	}

	//M�todo para criptografar texto
	public static String calculaHashing(String pwd) {
		if (md != null) {
			return new String(hexCodes(md.digest(pwd.getBytes())));
		}
		return null;
	}

	public static void main(String[] args){
		String senha = "abc";
		System.out.println(Main.calculaHashing(senha));
		System.out.println(Main.calculaHashing(senha).length());
	}

}


