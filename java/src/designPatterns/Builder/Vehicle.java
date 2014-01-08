package designPatterns.Builder;

public class Vehicle {
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
	return String.format("Car:frame:%s,engine:%s,wheels:%d,doors:%d",
		frame, engine, wheels, doors);
    }
}
