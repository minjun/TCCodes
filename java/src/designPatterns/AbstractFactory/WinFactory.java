package designPatterns.AbstractFactory;

public class WinFactory extends Factory {

    @Override
    public Button createButton() {
	// TODO Auto-generated method stub
	return new WinButton();
    }

}
