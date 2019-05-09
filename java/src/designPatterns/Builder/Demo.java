package designPatterns.Builder;

abstract class Builder {
	protected Vehicle vehicle = new Vehicle();

	public Vehicle getVehicle() {
		return vehicle;
	}

	abstract public Builder BuildFrame(String frame);

	abstract public Builder BuildEngine(String engine);

	abstract public Builder BuildWheels(int wheels);

	abstract public Builder BuildDoors(int doors);
}

class CarBuilder extends Builder {

	@Override
	public Builder BuildFrame(String frame) {
		vehicle.setFrame(frame);
		return this;
	}

	@Override
	public Builder BuildEngine(String engine) {
		vehicle.setEngine(engine);
		return this;
	}

	@Override
	public Builder BuildWheels(int wheels) {
		vehicle.setWheels(wheels);
		return this;
	}

	@Override
	public Builder BuildDoors(int doors) {
		// TODO Auto-generated method stub
		vehicle.setDoors(doors);
		return this;
	}

}

class Vehicle {
	private String engine;
	private int wheels;
	private String frame;
	private int doors;

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public String getFrame() {
		return frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	@Override
	public String toString() {
		return String.format("Car:frame:%s,engine:%s,wheels:%d,doors:%d", frame, engine, wheels, doors);
	}
}

class Director {

	/**
	 * @param args
	 */
	public void Construct(Builder builder, int doors, int wheels, String frame, String engine) {
		builder.BuildDoors(doors).BuildWheels(wheels).BuildFrame(frame).BuildEngine(engine);
	}

}

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Builder carBuilder = new CarBuilder();
		new Director().Construct(carBuilder, 4, 4, "frame", "engine");
		System.out.println(carBuilder.getVehicle());
	}

}
