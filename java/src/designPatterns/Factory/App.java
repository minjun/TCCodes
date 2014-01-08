package designPatterns.Factory;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Factory factory = new Factory();
	factory.createButton("win").paint();
    }

}
