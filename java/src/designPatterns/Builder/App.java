package designPatterns.Builder;

public class App {

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
