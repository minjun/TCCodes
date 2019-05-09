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

class CloneFoo implements Cloneable {
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

public class Demo {
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

	public Demo clone() {
		Demo p = new Demo();
		p.setAttr(getAttr());
		return p;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Demo p = new Demo();
		p.longProcessTask(0);
		Demo p1 = p.clone();
		System.out.println(p1.attr);
	}

}
