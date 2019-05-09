package designPatterns.Facade;

/* Complex parts */

class CPU {
	public void freeze() {
	}

	public void jump(long position) {
	}

	public void execute() {
	}
}

class Memory {
	public void load(long position, byte[] data) {
	}
}

class HardDrive {
	public byte[] read(long lba, int size) {
		return null;
	}
}

/* Facade */

class ComputerFacade {
	private CPU processor;
	private Memory ram;
	private HardDrive hd;

	public ComputerFacade() {
		this.processor = new CPU();
		this.ram = new Memory();
		this.hd = new HardDrive();
	}

	public void start() {
		int BOOT_ADDRESS = 0;
		int BOOT_SECTOR = 0;
		int SECTOR_SIZE = 0;
		processor.freeze();
		ram.load(BOOT_ADDRESS, hd.read(BOOT_SECTOR, SECTOR_SIZE));
		processor.jump(BOOT_ADDRESS);
		processor.execute();
		System.out.println("All done!");
	}
}

/* Client */

public class Demo {
	public static void main(String[] args) {
		ComputerFacade computer = new ComputerFacade();
		computer.start();
	}
}