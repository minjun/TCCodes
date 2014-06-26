package domain.charactor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Transient;
import org.springframework.data.couchbase.core.mapping.Document;

import domain.item.Item;
import static utils.Ansi.*;
import static utils.Utils.NEWLINE;

@Document
public class Player extends Char {
	public static final String PREFIX = "user_";

	public static enum PSTATUS {
		IDINPUT, IDCONFIRMED, NAMEINPUT, NORMAL, LOCKED, DELETED, END
	};

	public static final String SET_BRIEF = "brief";
	String name;
	String password;
	String roomId;
	PSTATUS status;
	String gender;
	Item[] item;
	Map<String, String> settings = new HashMap<String, String>();
	@Transient
	boolean connected = true, inStore = false;

	public Player(String id, String name, String password) {
		super(PREFIX + id);
		this.password = password;
		this.status = PSTATUS.END;
		this.roomId = "/d/city/kezhan.c";
		// armors.add(new Armor(Armor.KIND.BOOT,"boots"));
	}

	public String getId() {
		return super.getId().replace(PREFIX, "");
	}

	public boolean isInStore() {
		return inStore;
	}

	public void setup() {
		if (getNumSet("age") == 0)
			born();
		long max_kee = (getNumSet("age") - 4) * (getNumSet("con") + getNumSet("str")) + getNumSet("max_force") / 2;
		long max_sen = (getNumSet("age") - 4) * (getNumSet("spi") + getNumSet("int")) + getNumSet("max_mana") / 2;
		setNumSet("max_kee", max_kee);
		setNumSet("max_sen", max_sen);
		setNumSet("eff_kee", max_kee);
		setNumSet("eff_sen", max_sen);
		setNumSet("kee", max_kee);
		setNumSet("sen", max_sen);
		setNumSet("force", getNumSet("max_force") * 2);
		setNumSet("mana", getNumSet("max_mana") * 2);
	}

	public void born() {
		setNumSet("age", 14);
		setNumSet("str", 20);
		setNumSet("cor", 20);
		setNumSet("int", 20);
		setNumSet("kar", 20);
		setNumSet("spi", 20);
		setNumSet("per", 20);
		setNumSet("con", 20);
		setNumSet("kar", 20);
		setNumSet("force", 100);
		setNumSet("mana", 100);
		setNumSet("max_force", 100);
		setNumSet("max_mana", 100);
	}

	public String getHP() {
		StringBuffer sb = new StringBuffer();
		sb.append(String.format("个人状态 姓名：%s 性别：%s ID：%s", name, gender, getId())).append(NEWLINE);
		sb.append(String.format("〖 气血 〗%s%d/%d" + NOR, status_color(getNumSet("kee"), getNumSet("max_kee")), getNumSet("kee"), getNumSet("max_kee"))).append(
				" ");
		sb.append(String.format("〖 内力 〗%s%d/%d" + NOR, status_color(getNumSet("force"), getNumSet("max_force")), getNumSet("force"), getNumSet("max_force")))
				.append(NEWLINE);
		sb.append(String.format("〖 精神 〗%s%d/%d" + NOR, status_color(getNumSet("sen"), getNumSet("max_sen")), getNumSet("sen"), getNumSet("max_sen"))).append(
				" ");
		sb.append(String.format("〖 法力 〗%s%d/%d" + NOR, status_color(getNumSet("mana"), getNumSet("max_mana")), getNumSet("mana"), getNumSet("max_mana")))
				.append(NEWLINE);
		sb.append(String.format("〖 潜能 〗%d", getNumSet("pot"))).append(" ");
		sb.append(String.format("〖 杀气 〗%d", getNumSet("bellicosity"))).append(NEWLINE);
		sb.append(String.format("〖 武学 〗%d", getNumSet("combat_exp"))).append(" ");
		sb.append(String.format("〖 道行 〗%d", getNumSet("daoxing"))).append(NEWLINE);
		return sb.toString();
	}

	public void setInStore(boolean inStore) {
		this.inStore = inStore;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public boolean needSave() {
		return status.ordinal() >= PSTATUS.NORMAL.ordinal() && status.ordinal() < PSTATUS.END.ordinal();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public PSTATUS getStatus() {
		return status;
	}

	public void setStatus(PSTATUS status) {
		this.status = status;
	}

	public void setSettings(String key, String value) {
		settings.put(key, value);
	}

	public String getSettings(String key) {
		return settings.get(key);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "id=" + getId() + ";name=" + name + ";password=" + password + ";status=" + status;
	}
}
