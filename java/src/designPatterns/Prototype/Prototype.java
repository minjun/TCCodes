package designPatterns.Prototype;

public class Prototype {
    int attr;

    public int getAttr() {
	return attr;
    }

    public void setAttr(int attr) {
	this.attr = attr;
    }

    // this function takes a long time to execute
    public void longProcessTask(int attr) {
	try {
	    Thread.sleep(5000);
	} catch (Exception e) {
	}
	this.attr = attr;
    }

    public Prototype clone() {
	Prototype p = new Prototype();
	p.setAttr(getAttr());
	return p;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	Prototype p = new Prototype();
	p.longProcessTask(0);
	Prototype p1 = p.clone();
	System.out.println(p1.attr);
    }

}
