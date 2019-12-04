
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
	public double calculateFlux() {
	
		
		return Math.abs(tempinfinity - temp0)/calculateResistance();
	}

	@Override
	public double calculateTemperature(double pos) {
		 
		return 0;
	}
	public double calculateResistance() {
		double totalResistance = 0;
		//for convection we must use the area of the previous material unless it is the first then we use the next material area
		//this is because the convecition is acting on a surface it doens not have area of its own because its a gas
		if ( materials[0].getTypeOfgeometry().equals("cartesian")) {
		for (int i = 0; i < materials.length; ++i) {
			// making sure we are in a series type of heat transfer
			if(!(i == materials.length - 1 ? false : materials[i].isParrell(materials[i+1]))) {
				
				if (materials[i].getTypeOfHeatTransfer().equals("convection")) {
					totalResistance += 1/(materials[i].getHeatTransferCoefficient() * materials[i == 
							0  ?  i + 1 : i -1].getArea());
				}else { 
					totalResistance += materials[i].getLength()/(materials[i].getArea() * materials[i].getHeatTransferCoefficient());
				}
			}
			// calculations when materials are in series only in conduction 
				else {
					//TODO: this needs to be the posisiton of the parallel materail not just the length of the material 
					totalResistance += materials[i].getLength() * (1/(materials[i].getHeatTransferCoefficient()*materials[i].getHeight() + materials[i + 1].getHeatTransferCoefficient()* 
								materials[i+1].getHeight()));
					i++; //included two material in this calculation
			}
		}
		}else if (materials[0].getTypeOfgeometry().equals("cylindrical")) { 
			for (int i = 0; i < materials.length; ++i) {
				if (materials[i].getTypeOfHeatTransfer().equals("convection")) {
						totalResistance += 1/(materials[i == 0 ? i + 1: i -1].getHeatTransferCoefficient() * 
								materials[i == 0 ? i + 1: i -1 ].getArea());
				}else {
					totalResistance += Math.log(materials[i].getOutterDiameter() / materials[i].getInnderDiameter())/
							(2 * Math.PI * materials[i].getHeatTransferCoefficient() * materials[i].getLength());
				}
			}  
		}
		
		return totalResistance;
	}
	public double cylindricalSolidHomogeneousEnergyGeneration(double heatGeneration) {
		return Math.PI* Math.pow((materials[0].getDiameter()/2),2) * materials[0].getLength() * heatGeneration;
	}
	
	public double extenedeSurfaceEfficiency() {
		return temp0;
		//TODO:
	}
	public double heatTranferOfextendedSurface() {
		return temp0;
		//TODO:
	}
}
 

	
