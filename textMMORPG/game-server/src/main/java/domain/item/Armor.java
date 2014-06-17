package domain.item;

public final class Armor extends Item {
	public static enum KIND {
		HEAD, NECK, GLOVE, WRIST, CLOTH, ARMOR, WAIST, BOOT, MAXITEM
	};

	KIND kind;

	public Armor(String id, String name, String ids, String inherits, KIND kind) {
		super(id, name, ids, inherits);
		this.kind = kind;
	}
}
