package it.uniroma3.diadia.generale;
import java.util.Scanner;

public class IOConsole {
	public void mostraMessaggio(String msg) {
		System.out.print(msg);
		}
		public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();  per ora lo omettiamo 
		return riga;
		}
}
