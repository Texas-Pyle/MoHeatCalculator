import static org.junit.Assert.*;

import org.junit.Test;

public class MaterialTest {

	 
	@Test
	public void areaCartisianTest(){
		Material  mt = new Material();
		double length = 3;
		double widith = 4;
		mt.areaCartisian(length, widith); 
		double actual = mt.getArea();
		double expected = length * widith;
		 assertEquals(expected, actual,.0001); 
		
	}
	@Test
	public void areaCylinderTest() {
		Material  mt = new Material();
		double diameter = 4;
		double length = 1;
		double expected = Math.PI*(4/2)*length;
		 mt.areaCylindrical(diameter,length);
		 double actual = mt.getArea();
		assertEquals(expected, actual,.0001);
		//TODO:
	}
	@Test
	public void areaSphereTest() {
		Material  mt = new Material();
		double diameter = 4;
		double expected = Math.PI*diameter; 
		mt.areaSpherical(diameter);
		double actual = mt.getArea();
		assertEquals(expected, actual,.0001);
		
		
	}
	@Test
	public void positionTest() {
		//fisrt test is if position is not set 
		Material  mt = new Material();
		assertEquals(false, mt.isParrell(new Material()));
		//second test is if they are parrells
		mt.setPosition(3);
		Material mt2 = new Material();
		mt2.setPosition(3);
		assertEquals(true, mt.isParrell(mt2));
		//third test is if they are not equal 
		mt.setPosition(4);
		assertEquals(false, mt.isParrell(mt2));
	}
}
