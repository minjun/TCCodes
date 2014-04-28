package domain.item;

public final class Armor {
    public static enum KIND {
	HEAD, NECK, GLOVE, WRIST, CLOTH, ARMOR, WAIST, BOOT, MAXITEM
    };

    KIND kind;
    String name;
    int armor;
    int armor_vs_force;
    int armor_vs_spells;

    public Armor(KIND kind, String name) {
    	this.kind = kind;
    	this.name = name;
    }
}
