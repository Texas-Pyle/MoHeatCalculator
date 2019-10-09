
public class SteadyStateHeatTransfer extends HeatTransfer {
	private int numberOfMaterials;
	private double[] materalheatTransferCoefficients;
	private double tempinfinity;
	private double temp0;
	private String[] typeOfHeatTransfer;
	private double[] area;
	private double[] length;
	
	public SteadyStateHeatTransfer() {
		
	}
	public SteadyStateHeatTransfer(int numberOfMaterials , double[] materalHeatTransferCoefficients, double tempInfinity,double Temp0,String[]
									TypeOfHeatTransfer , double[] area,double length[]) {
		this.numberOfMaterials = numberOfMaterials;
		this.materalheatTransferCoefficients = materalHeatTransferCoefficients;
		this.tempinfinity = tempInfinity;
		this.temp0 = Temp0;
		this.typeOfHeatTransfer = TypeOfHeatTransfer;
		this.area = area;
		this.length = length;
		
	}	@Override
	protected double calculateFlux() {
		// TODO Auto-generated method stub
		
		return (temp0 - tempinfinity)/calculateResistance();
	}

	@Override
	protected double calculateTemperature(double pos) {
		// TODO Auto-generated method stub
		return 0;
	}
	private double calculateResistance() {
		double totalResistance = 0;
		for (int i = 0; i < materalheatTransferCoefficients.length; ++i) {
			if (typeOfHeatTransfer[i].equals("convection")) {
				totalResistance += 1/(materalheatTransferCoefficients[i] * area[i]);
			}else {
				totalResistance += length[i]/(area[i]*materalheatTransferCoefficients[i]);
			}
		}
		
		return totalResistance;
	}
	public double area(String typeOfCordinates, double xlenght,double ylength) {
		
		
		return 0;
	}
}
