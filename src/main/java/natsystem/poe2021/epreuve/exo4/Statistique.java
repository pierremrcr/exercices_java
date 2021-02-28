package natsystem.poe2021.epreuve.exo4;

import java.util.Collections;
import java.util.List;

public class Statistique implements Calculable {

	private List<Double> nombres;
	private Double min;
	private Double max;
	private Double moyenne;
	private Double mediane;
	private Double ecartType;


	public Statistique(List<Double> nombres) {
		super();
		this.nombres = nombres;
	}

	public List<Double> getNombres() {
		return nombres;
	}
	public void setNombres(List<Double> nombres) {
		this.nombres = nombres;
	}
	public Double getMin() {
		return min;
	}
	public void setMin(Double min) {
		this.min = min;
	}
	public Double getMax() {
		return max;
	}
	public void setMax(Double max) {
		this.max = max;
	}
	public Double getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(Double moyenne) {
		this.moyenne = moyenne;
	}
	public Double getMediane() {
		return mediane;
	}
	public void setMediane(Double mediane) {
		this.mediane = mediane;
	}
	public Double getEcartType() {
		return ecartType;
	}
	public void setEcartType(Double ecartType) {
		this.ecartType = ecartType;
	}

	@Override
	public String toString() {
		return  " min = " + min + ", max = " + max + ", moyenne = " + moyenne + ", mediane = " + mediane
				+ ", ecartType = " + ecartType;
	}

	@Override
	public void calcule() {


		// Calcul minimum et maximum 

		Collections.sort(nombres);

		this.min = nombres.get(0);
		this.max = nombres.get(nombres.size()-1);


		//Calcul mediane
		int milieu = nombres.size()/2;
		
		if (nombres.size() % 2 == 1)
			this.mediane = nombres.get(milieu);
		else {
			this.mediane = ((nombres.get(milieu-1) + nombres.get(milieu))/2.0);
		}

		// Calcul de la moyenne

		Double somme = 0.0;

		for (Double nombre : nombres) {
			somme += nombre;
		}
		this.moyenne = somme / nombres.size(); 
		
		// Calcul écart type
		
		Double somme2 = 0.0;
		
		for (Double nombre : nombres) {
			Double differenceAuCarre  = Math.pow(nombre - this.getMoyenne(),2); 
			somme2 += differenceAuCarre;	
		}
		this.ecartType =  Math.sqrt(somme2 / this.getMoyenne());
	}



}
