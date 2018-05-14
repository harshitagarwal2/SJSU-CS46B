package transport;

public class Vehicle 
{
	private double xPosition;
	private double yPosition;
	private int nWheels;
	
	
	Vehicle(int nWheels)
	{
		this.nWheels = nWheels;
	}
	public void setPosition(double xPosition, double yPosition){
		this.xPosition=xPosition;
		this.yPosition=yPosition;
	}
	
	public double getXPosition(){
		return xPosition;
	}
	
	public double getYPosition(){
		return yPosition;
	}
	
	public void changePositionBy(double xDelta, double yDelta){
		xPosition = xDelta+xPosition;
		yPosition = yDelta+yPosition;
	}
	
}
