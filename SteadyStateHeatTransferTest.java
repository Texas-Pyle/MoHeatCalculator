import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class SteadyStateHeatTransferTest {

	@Test
	public void calculateFulxTest() {
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
	

}
