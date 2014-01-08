package designPatterns.AbstractFactory;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Factory factory = new WinFactory();
	factory.createButton().paint();
    }

}
