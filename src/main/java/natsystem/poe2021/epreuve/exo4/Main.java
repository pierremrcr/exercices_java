package natsystem.poe2021.epreuve.exo4;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
	List<Double> nombres = new ArrayList<>();
	
	nombres.add(10.5);
	nombres.add(8.0);
	nombres.add(11.0);
	nombres.add(6.5);
	
	
    Statistique stat = new Statistique(nombres);
    
    stat.calcule();
    
    System.out.println(stat.getMin());
    System.out.println(stat.getMax());
    System.out.println(stat.getMoyenne());
	
	}

}
