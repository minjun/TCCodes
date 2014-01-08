package designPatterns.Builder;

public abstract class Builder {
    protected Vehicle vehicle = new Vehicle();
    
    public Vehicle getVehicle() {
	return vehicle;
    }
    abstract public void BuildFrame(String frame);
    abstract public void BuildEngine(String engine);
    abstract public void BuildWheels(int wheels);
    abstract public void BuildDoors(int doors);
}
