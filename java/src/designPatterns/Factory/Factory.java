package designPatterns.Factory;

public class Factory {
    public Button createButton(String buttonType) {
	if (buttonType.equalsIgnoreCase("win")) {
	    return new WinButton();
	} else {
	    return new OSXButton();
	}
    }
}
