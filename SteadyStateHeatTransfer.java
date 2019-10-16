
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
		//for convection we must use the area of the previous material unless it is the first then we use the next material area
		//this is because the convecition is acting on a surface it doens not have area of its own because its a gas
		for (int i = 0; i < materials.length; ++i) {
			if (materials[i].getTypeOfHeatTransfer().equals("convection")) {
				if (i == 0) {
				totalResistance += 1/(materials[i].getHeatTransferCoefficient() * materials[i+1].getArea());
				}else {
					totalResistance += 1/(materials[i].getHeatTransferCoefficient() * materials[i-1].getArea());
				}
			}else {
				totalResistance += materials[i].getLength()/(materials[i].getArea() * materials[i].getHeatTransferCoefficient());
			}
		} 
		
		return totalResistance;
	}
	
}
