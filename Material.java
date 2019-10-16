
public class Material {
	private double area;
	private double heatTransferCoefficient;
	private double length;// 0 if using spherical coridinates
	private double diameter;//0 if using  cartesian 
	private double temperature;
	private double widith;
	private double depth;// will be 0 if not using cartesian
	String typeOfHeatTransfer;
	public Material() {
		
	}
	public Material(String typeOfGeometry, String typeOfHeatTranfer,double heatTransfercoefficients,double Length,double widith,double depth,double diameter,double temperature) {
		
		this.heatTransferCoefficient = heatTransfercoefficients;
		this.length = typeOfGeometry.equals("Spherical") ? 0: Length;
		this.diameter = typeOfGeometry.equals("Cartiesian") ? 0 :diameter;
		this.depth = typeOfGeometry.equals("Cartiesian") ? depth :0;
		this.temperature = temperature;
		this.typeOfHeatTransfer = typeOfHeatTranfer;
		this.widith = widith;
		switch (typeOfGeometry) {
		case "Cartiesian":
			areaCartisian(widith, depth);
			break;

		default:
			break;
		}
		
	}
	public double getArea() {
		return area;
	}
	public double getHeatTransferCoefficient() {
		return heatTransferCoefficient;
	}
	public double getLength() {
		return length;
	}
	public double getDiameter() {
		return diameter;
	}
	public double getTemperature() {
		return temperature;
	}public double getDepth() {
		return depth;
	}
	public String getTypeOfHeatTransfer() {
		return typeOfHeatTransfer;
	}
	public void areaCartisian(double xlenght,double ylength) {
		area = xlenght*ylength;
	}
	public void areaSpherical(double diamater) {
		area = Math.PI * diamater;
	}
	public void areaCylindrical(double diamater ,double length) {
		area = Math.PI*(diamater/2)*length;
	}
}
