
public class Position {
	double start;
	double end;
	
	public Position(double start, double end) {
		this.start = start;
		this.end = end;
	}
	
	
	public boolean isBetween(Position pos2) {
		if (start < pos2.getStart() && end > pos2.getEnd())
			return true;
		else 
			return false;
	}


	public double getStart() {
		return start;
	}


	


	public double getEnd() {
		return end;
	}


	
	
}
