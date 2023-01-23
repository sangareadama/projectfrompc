 package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import beans.Calculatrice;

class TestCalculatrice {

	Calculatrice calcul;
	double nbre1,nbre2,nbre3,result;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}
	

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
		
		calcul = new Calculatrice();
		nbre1= new Random().nextDouble()*50;
		nbre2= new Random().nextDouble()*50;
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void additionTest() {
		result=nbre1+nbre2;		
		assertEquals(result, calcul.addation(nbre1,nbre2));
	} 
	 
	@Test
	void soustractionTest() {
		result=nbre1-nbre2;		
		assertEquals(result, calcul.soustraction(nbre1,nbre2));
	}

	@Test
	void multiplicationTest() {
		result=nbre1*nbre2;		
		assertEquals(result, calcul.multiplication(nbre1,nbre2));
	}

	@Test
	void divisionTest() {
		result=nbre2/nbre1;		
		assertEquals(result, calcul.division(nbre1,nbre2));
	}
	
	/*
	 * @Test void quadtratiqueTest() {
	 * 
	 * 
	 * result= nbre2 * nbre2 - 4 * nbre1 * nbre3;
	 * 
	 * assertEquals(result, calcul.quadratique(nbre1,nbre2,nbre3)); }
	 */
}
