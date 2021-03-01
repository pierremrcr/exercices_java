package natsystem.poe2021.epreuve.exo5.composants;

public class StringComponent {
	
	public static String fill(int lg, char c) {
		return new String(new char[lg]).replace('\0', c);
	}

}
