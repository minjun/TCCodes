package designPatterns.Factory;

abstract class Button {
	abstract void paint();
}

class Factory {
	static Button createButton(String buttonType) {
		if (buttonType.equalsIgnoreCase("win"))
			return new WinButton();
		return new OSXButton();
	}
}

class OSXButton extends Button {

	@Override
	void paint() {
		System.out.println("Painted by Mac OS X Button");
	}

}

class WinButton extends Button {

	@Override
	void paint() {
		System.out.println("Painted by Win Button");
	}

}

public class Demo {
	public static void main(String[] args) {
		Factory.createButton("win").paint();
	}
}
