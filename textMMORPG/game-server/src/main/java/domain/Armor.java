package domain;

public final class Armor {
    public static enum KIND {
	HEAD, NECK, GLOVE, WRIST, CLOTH, ARMOR, WAIST, BOOTS, MAXITEM
    };

    KIND kind;
    String name;

    public Armor(KIND kind, String name) {

    }
}
