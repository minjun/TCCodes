package designPatterns.Builder;

public class CarBuilder extends Builder {

    @Override
    public void BuildFrame(String frame) {
	vehicle.setFrame(frame);
   }

    @Override
    public void BuildEngine(String engine) {
	vehicle.setEngine(engine);
    }

    @Override
    public void BuildWheels(int wheels) {
	vehicle.setWheels(wheels);
    }

    @Override
    public void BuildDoors(int doors) {
	// TODO Auto-generated method stub
	vehicle.setDoors(doors);
    }

}
