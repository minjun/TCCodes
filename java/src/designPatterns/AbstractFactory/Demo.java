package designPatterns.AbstractFactory;

abstract class Factory {
	public abstract Button createButton();
}

abstract class Button {
	public abstract void paint();
}

class OSXFactory extends Factory {

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new OSXButton();
	}

}

class WinFactory extends Factory {

	@Override
	public Button createButton() {
		return new WinButton();
	}

}

class OSXButton extends Button {

	@Override
	public void paint() {
		System.out.println("Painted by Mac OS X Button");
	}

}

class WinButton extends Button {

	@Override
	public void paint() {
		System.out.println("Painted by Win Button");
	}

}

public class Demo {
	public static void main(String[] args) {
		Factory factory = new WinFactory();
		factory.createButton().paint();
	}
}
