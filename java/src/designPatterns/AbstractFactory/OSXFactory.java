package designPatterns.AbstractFactory;

public class OSXFactory extends Factory {

    @Override
    public Button createButton() {
	// TODO Auto-generated method stub
	return new OSXButton();
    }

}
