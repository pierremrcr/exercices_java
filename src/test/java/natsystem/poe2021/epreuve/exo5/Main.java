package natsystem.poe2021.epreuve.exo5;

import natsystem.poe2021.epreuve.exo5.composants.Justification;
import natsystem.poe2021.epreuve.exo5.composants.StringAlignement;

public class Main {

	public static void main(String[] args) {

	StringAlignement sa = new StringAlignement(Justification.GAUCHE, "|", 10);
	
	System.out.println(sa.format("Coucou"));
		

	}

}
