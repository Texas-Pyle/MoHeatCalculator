import java.time.chrono.ThaiBuddhistChronology;

public class Material {
	private double area;
	private double heatTransferCoefficient;
	private double length;// 0 if using spherical coridinates
	private double diameter;//0 if using  cartesian 
	private double temperature;
	private double widith;
	private double depth;// will be 0 if not using cartesian
	private String typeOfGeometry;
	String typeOfHeatTransfer;
	private double thickness;
	private double innderDiameter;
	private double outterDiameter;
	private Double position; 
	public Material() {
		
	}
	// cylindrical constructor
	public Material (String typeOfHeatTransfer, double heatTransferCoefficients, double length, double innerDiameter, double Thickness, double outerDiamter) {
		this.typeOfHeatTransfer = typeOfHeatTransfer;
		this.heatTransferCoefficient = heatTransferCoefficients;
		this.length = length;
		this.innderDiameter = innerDiameter;
		this.thickness = Thickness;
		this.outterDiameter = outerDiamter;
		this.typeOfGeometry = "cylindrical";
		areaCylindrical(innerDiameter, outerDiamter);
		
	}// spherical consturctor
	public Material (String typeOfHeatTransfer, double heatTransferCoefficients, double Diamater, double Thickness){
		this.typeOfHeatTransfer = typeOfHeatTransfer;
		this.heatTransferCoefficient = heatTransferCoefficients;
		this.diameter = Diamater;
		this.thickness = Thickness;
		this.typeOfGeometry = "spherical";
		areaSpherical(Diamater);
	}
	// cartesian constructor 
	public Material( String typeOfHeatTranfer,double heatTransfercoefficients,double Length,double widith,double depth) {
		this.typeOfGeometry = "cartesian";
		this.typeOfHeatTransfer = typeOfHeatTranfer;
		this.heatTransferCoefficient = heatTransfercoefficients;
		this.length = Length;
		this.widith = widith;
		this.depth = depth;
		areaCartisian(depth, widith);
		
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
	public String getTypeOfgeometry() {
		return typeOfGeometry;
	}
	public double getInnderDiameter() {
		return innderDiameter;
	}
	public void setInnderDiameter(double innderDiameter) {
		this.innderDiameter = innderDiameter;
	}
	public double getOutterDiameter() {
		return outterDiameter;
	}
	public void setOutterDiameter(double outterDiameter) {
		this.outterDiameter = outterDiameter;
	}
	public Double getPosition() {
		return position;
	}
	public void setPosition(double position) {
		this.position = position;
	}
	public boolean isParrell(Material mat) {
		if (this.position == null || mat.getPosition() == null) {
			return false; 
		}
		else if (this.position.equals( mat.getPosition())) {
			return true;
		 }
		return false;
		
	}
	public double getHeight() {
		// TODO Auto-generated method stub
		return widith;
	}
}
