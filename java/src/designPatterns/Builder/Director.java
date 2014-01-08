package designPatterns.Builder;

public class Director {

    /**
     * @param args
     */
    public void Construct(Builder builder, int doors, int wheels, String frame, String engine) {
	builder.BuildDoors(doors);
	builder.BuildWheels(wheels);
	builder.BuildFrame(frame);
	builder.BuildEngine(engine);
    }

}
