package designPatterns.Prototype;

class Inner {
    private int b;

    public int getB() {
	return b;
    }

    public void setB(int b) {
	this.b = b;
    }
}

public class CloneFoo implements Cloneable {
    private int a;
    private Inner inner;

    public Inner getInner() {
        return inner;
    }

    public void setInner(Inner inner) {
        this.inner = inner;
    }

    public int getA() {
	return a;
    }
    
    public void setA(int a) {
	this.a = a;
	inner = new Inner();
	inner.setB(5);
    }

    public Object Clone() throws CloneNotSupportedException {
	return super.clone();
    }

    /**
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
	// TODO Auto-generated method stub
	CloneFoo a = new CloneFoo();
	a.setA(3);
	CloneFoo b = (CloneFoo) a.Clone();
	System.out.println(a.getInner());
	System.out.println(b.getInner());
    }

}
