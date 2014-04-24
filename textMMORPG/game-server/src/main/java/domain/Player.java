package domain;

import java.util.List;

import org.springframework.data.annotation.Id;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class Player {
    @Id
    final String id;
    @Field
    final String name;
    @Field
    String password;
    @Field
    List<Armor> armors = null;

    public Player(String id, String name, String password) {
	this.id = id;
	this.name = name;
	this.password = password;
    }

    @Override
    public String toString() {
	return "id=" + id + ";" + "name=" + name + ";" + "password=" + password + ";";
    }
}
