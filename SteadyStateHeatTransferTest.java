import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class SteadyStateHeatTransferTest {

	@Test
	public void calculateFulxCondutionOnlyTest() {
		Material [] mat = new Material [2];
		double transferCoeficientOne = 32.1,lenghtOne = 2, widithOne = 4,depthOne = 4;
		mat[0] = new Material("Cartiesian","conduction",transferCoeficientOne,lenghtOne,widithOne,depthOne,0,10);//last two nubers are not relevent to this test
		
		double transferCoeficientTwo = 12.1, lengthTwo = 4, widithTwo = 4, depthTwo = 3;
		mat[1] = new Material("Cartiesian","conduction",transferCoeficientTwo,lengthTwo,widithTwo,depthTwo,0,10);
		
		int tnot = 20;
		int tinfinity = 100;
		SteadyStateHeatTransfer st = new SteadyStateHeatTransfer(mat,tinfinity,tnot);
		double actual = st.calculateFlux();
		// finding total resistance then dividing temperature difference by totalResistance to  get the expected total flux
		double totalResistance = lenghtOne/(transferCoeficientOne*widithOne*depthOne);
		totalResistance += lengthTwo/(transferCoeficientTwo*widithTwo*depthTwo);
		double expected = (tinfinity - tnot)/totalResistance;
		
		assertEquals(expected, actual,.000001);
		//TODO: 
	}
	@Test 
	public void calculateResistanceCartiesianTest() {
		Material [] mat = new Material[3];
		double transferCoeficientOne = 32.1,lenghtOne = 2, widithOne = 4,depthOne = 4;
		mat[0] = new Material("Cartiesian","conduction",transferCoeficientOne,lenghtOne,widithOne,depthOne,0,10);//last two nubers are not relevent to this test
		
		double transferCoeficientTwo = 12.1, lengthTwo = 4, widithTwo = 4, depthTwo = 3;
		mat[1] = new Material("Cartiesian","conduction",transferCoeficientTwo,lengthTwo,widithTwo,depthTwo,0,10);
		
		double transferCoeficientThree = 22.4, lengthThree = 7, widiththree = 8, depthThree = 1;
		mat[2] = new Material("Cartiesian","conduction",transferCoeficientThree,lengthThree,widiththree,depthThree,0,10);
		
		SteadyStateHeatTransfer st = new SteadyStateHeatTransfer(mat,100,20);
		double expected = lenghtOne/(transferCoeficientOne*widithOne*depthOne);
		expected += lengthTwo/(transferCoeficientTwo*widithTwo*depthTwo);
		expected += lengthThree/(transferCoeficientThree*widiththree*depthThree);
		
		double actual = st.calculateResistance();
		assertEquals(expected, actual,.00001); 
		
	}
	// even though we are calculating convencitve resistances we still need a solid material that for that convection to occur 
	@Test 
	public void calculateConvectiveResistances() {
		Material [] mat = new Material[2];
		double transferCoeficientOne = 32.1,lenghtOne = 2, widithOne = 4,depthOne = 4;
		mat[0] = new Material("Cartiesian","conduction",transferCoeficientOne,lenghtOne,widithOne,depthOne,0,10);//last two numbers are not relevant to this test
		
		// convection happens on a surface of another material so there is no materials just the conductive heat transfer coefficient.
		double transferCoefficientTwo = 21.2, lengthTwo = 0, widithTwo = 0, depthTwo = 0;
		mat[1] = new Material("Cartiesian","convection",transferCoefficientTwo,lengthTwo,widithTwo,depthTwo,0,0);
		
		SteadyStateHeatTransfer st = new SteadyStateHeatTransfer(mat,100,20);// last two numbers are not relevant to this test.
		double expected = lenghtOne/(transferCoeficientOne*widithOne*depthOne);
		expected +=  1 / (transferCoefficientTwo * widithOne * depthOne);
		double actual = st.calculateResistance();
		assertEquals(expected, actual,.00001);
		
	}
	/* this test includes both resistance of conduction and convention
	 * the problem: you have a material with length 2 width 4, and a depth 4 the temperature on the hot side is 400 the heat transfer coefficient is 32.1 the cold 
	 * side of the plate is exposed to air at 50 the air has a convective heat transfer coefficient of 21.2 calculate the total flux 
	 */
	@Test
	public void calculateTotalFlux() {
		Material [] mat = new Material[2];
		double transferCoeficientOne = 32.1,lenghtOne = 2, widithOne = 4,depthOne = 4;
		mat[0] = new Material("Cartiesian","conduction",transferCoeficientOne,lenghtOne,widithOne,depthOne,0,10);//last two numbers are not relevant to this test
		
		double transferCoefficientTwo = 21.2, lengthTwo = 0, widithTwo = 0, depthTwo = 0;
		mat[1] = new Material("Cartiesian","convection",transferCoefficientTwo,lengthTwo,widithTwo,depthTwo,0,0);
		
		int tempInfinity =  40;
		int temp0 = 400;
		SteadyStateHeatTransfer st = new SteadyStateHeatTransfer(mat, tempInfinity, temp0);
		double totalResistance = lenghtOne/(transferCoeficientOne*widithOne*depthOne);
		totalResistance += 1 / (transferCoefficientTwo * widithOne * depthOne);
		double expected = (temp0 - tempInfinity )/ totalResistance;
		double actual = st.calculateFlux();
		assertEquals(expected, actual,.00001);
		
		
	}
	

}
