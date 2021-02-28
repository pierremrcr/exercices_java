package natsystem.poe2021.epreuve.exo4;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Double> nombres = new ArrayList<>();
		List<Double> nombres2 = new ArrayList<>();

		nombres.add(1.0);
		nombres.add(2.0);
		nombres.add(8.0);
		nombres.add(5.0);
		nombres.add(7.0);
		nombres.add(7.0);

		nombres2.add((double) 1);
		nombres2.add(2.5);
		nombres2.add(-1.5);
		nombres2.add((double) 8);
		nombres2.add((double) 6);
		nombres2.add((double) 7);
		nombres2.add((double) 7);


		Statistique stat = new Statistique(nombres);
		Statistique stat2 = new Statistique(nombres2);


		stat.calcule();
		stat2.calcule();

		System.out.println("1ère liste : " + stat.toString());
		System.out.println("Seconde liste : " + stat2.toString());



	}

}
