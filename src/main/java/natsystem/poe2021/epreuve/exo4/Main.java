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
    
    System.out.println("Résultats 1ère liste : ");
    
    System.out.println("Minimum : " + stat.getMin());
    System.out.println("Maximum : " + stat.getMax());
    System.out.println("Moyenne : " + stat.getMoyenne());
    System.out.println("Médiane : " + stat.getMediane());
    System.out.println("Ecart type : " + stat.getEcartType());
    
    System.out.println("Résultats seconde liste : ");
    
    System.out.println("Minimum : " + stat2.getMin());
    System.out.println("Maximum : " + stat2.getMax());
    System.out.println("Moyenne : " + stat2.getMoyenne());
    System.out.println("Médiane : " + stat2.getMediane());
    System.out.println("Ecart type : " + stat2.getEcartType());
	
	}

}
