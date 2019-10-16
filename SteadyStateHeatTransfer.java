
public class SteadyStateHeatTransfer extends HeatTransfer {
	private Material[] materials;
	private double tempinfinity;
	private double temp0;
	public SteadyStateHeatTransfer() {
		
	}
	public SteadyStateHeatTransfer( Material[] material, double tempInfinity
									 ,double temp0) {
		this.tempinfinity = tempInfinity;
		
		this.materials = material;
		this.temp0 = temp0;
		
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
	public double calculateResistance() {
		double totalResistance = 0;
		for (int i = 0; i < materials.length; ++i) {
			if (materials[i].getTypeOfHeatTransfer().equals("convection")) {
				totalResistance += 1/(materials[i].getHeatTransferCoefficient() * materials[i].getArea());
			}else {
				totalResistance += materials[i].getLength()/(materials[i].getArea() * materials[i].getHeatTransferCoefficient());
			}
		}
		
		return totalResistance;
	}
	
}
