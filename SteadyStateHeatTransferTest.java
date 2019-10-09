import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class SteadyStateHeatTransferTest {

	@Test
	public void calculateFulxTest() {
		double[] heatTransferCoeficients = {3,24.8,1500};//first and last one were given second one had to be found in apendix
		double tempInfinity = 80;//given in problem
		double temp0 = 0;
		String[] typeOfheatTransfer = {"Convection","Conduction","Convection"};// needs to be reconized by the user
		double length[]; //was given in the problem
		double area[] ;
			SteadyStateHeatTransfer st = new SteadyStateHeatTransfer(3, heatTransferCoeficients, tempInfinity, temp0, 
										typeOfheatTransfer, area, length);
	}
	@Test 
	public void calculateResistanceTest() {
		
	}
	@Test
	public void areaCartisianTest(){
		String typeOfCordinates = "Cartisian" ;
		SteadyStateHeatTransfer st = new SteadyStateHeatTransfer();
		double length = 3;
		double widith = 4;
		double actual = st.area(typeOfCordinates,length, widith);
		double expected = length * widith;
		 Assert.assertEquals(expected, actual);
		
	}

}
