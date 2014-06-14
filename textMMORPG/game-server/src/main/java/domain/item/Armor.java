package domain.item;

public final class Armor extends Item {
	public static enum KIND {
		HEAD, NECK, GLOVE, WRIST, CLOTH, ARMOR, WAIST, BOOT, MAXITEM
	};

	KIND kind;
	String name;
	int armor;
	int armor_vs_force;
	int armor_vs_spells;

	public Armor(String id, KIND kind, String name) {
		super(id);
		this.kind = kind;
		this.name = name;
	}
}
