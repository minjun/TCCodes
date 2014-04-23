package domain;

public class Player {
    final static int MAXARMOR = 14;
    final String id;
    final String name;
    String password;
    Armor[] armors = null;
    public Player(String id,String name,String password) {
	this.id = id;
	this.name = name;
	this.password = password;
    }
}
