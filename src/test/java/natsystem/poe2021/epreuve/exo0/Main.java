package natsystem.poe2021.epreuve.exo0;

import org.junit.Assert;
import org.junit.Test;


import natsystem.poe2021.epreuve.exo0.Attaque;

public class Main {

	public static void main(String[] args) {
		
		System.out.println(Attaque.coup("paf !"));
		System.out.println(Attaque.coup(4,"paf !"));
		

	}
	
	@Test
	public void attaqueTest() {
		
		//Si paramètre vaut "paf !" alors la méthode retourne "aïe !", sinon elle retourne "?"
		Assert.assertEquals("aïe !", Attaque.coup("paf !"));
		Assert.assertEquals("?", Attaque.coup("frvnj"));
		
		Assert.assertEquals("aïe !", Attaque.coup(1,"paf !"));
		Assert.assertEquals("aïe !", Attaque.coup(2,"paf !"));
		Assert.assertEquals("?", Attaque.coup(1,"kfkg !"));
		
		//Si la méthode est appelée pour la 3ème et 4ème fois, elle retourne "ça suffit, arrête !" si le paramètre veut "paf !"
		Assert.assertEquals("ça suffit, arrête !", Attaque.coup(3,"paf !"));
		Assert.assertEquals("ça suffit, arrête !", Attaque.coup(4,"paf !"));
		
		//Sinon elle continue de retourner "?"
		Assert.assertEquals("?", Attaque.coup(4, "kfofo"));
		
		//A partir du 5ème appel avec le paramètre "paf !", elle retourne une chaine vide
		Assert.assertEquals(" ", Attaque.coup(5,"paf !"));
		Assert.assertEquals(" ", Attaque.coup(6,"paf !"));
		
		Assert.assertEquals("Même pas mal", Attaque.coup(5,"djchc !"));
		
		
		
	}
	
	

}
