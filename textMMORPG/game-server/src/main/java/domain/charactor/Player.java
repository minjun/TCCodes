package domain.charactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Transient;
import org.springframework.data.couchbase.core.mapping.Document;

import domain.item.Armor;
import domain.item.Bag;
import domain.item.Weapon;
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
	Map<String, String> settings = new HashMap<String, String>();
	@Transient
	boolean connected = true;
	@Transient
	boolean inStore = false;
	
	
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
		if (getSet("age") == null)
			born();
		int max_kee = (getSetInt("age") - 4) * (getSetInt("con") + getSetInt("str")) + getSetInt("max_force") / 2;
		int max_sen = (getSetInt("age") - 4) * (getSetInt("spi") + getSetInt("int")) + getSetInt("max_mana") / 2;
		setSet("max_kee", max_kee);
		setSet("max_sen", max_sen);
		setSet("eff_kee", max_kee);
		setSet("eff_sen", max_sen);
		setSet("kee", max_kee);
		setSet("sen", max_sen);
		setSet("force", getSetInt("max_force") * 2);
		setSet("mana", getSetInt("max_mana") * 2);
	}

	public void born() {
		setSet("age", 14);
		setSet("str", 20);
		setSet("cor", 20);
		setSet("int", 20);
		setSet("kar", 20);
		setSet("spi", 20);
		setSet("per", 20);
		setSet("con", 20);
		setSet("kar", 20);
		setSet("force", 100);
		setSet("mana", 100);
		setSet("max_force", 100);
		setSet("max_mana", 100);
	}

	public String getHP() {
		StringBuffer sb = new StringBuffer();
		int kee = Integer.parseInt(getSet("kee"));
		int max_kee = Integer.parseInt(getSet("max_kee"));
		int sen = Integer.parseInt(getSet("sen"));
		int max_sen = Integer.parseInt(getSet("max_sen"));
		int force = Integer.parseInt(getSet("force"));
		int max_force = Integer.parseInt(getSet("max_force"));
		int mana = Integer.parseInt(getSet("mana"));
		int max_mana = Integer.parseInt(getSet("max_mana"));
		int pot = 0;
		int bellicosity = 0;
		int combat_exp = 0;
		int daoxing = 0;
		sb.append(String.format("个人状态 姓名：%s 性别：%s ID：%s", name, gender, getId())).append(NEWLINE);
		sb.append(String.format("〖 气血 〗%s%d/%d" + NOR, status_color(kee, max_kee), kee, max_kee)).append(" ");
		sb.append(String.format("〖 内力 〗%s%d/%d" + NOR, status_color(force, max_force), force, max_force)).append(NEWLINE);
		sb.append(String.format("〖 精神 〗%s%d/%d" + NOR, status_color(sen, max_sen), sen, max_sen)).append(" ");
		sb.append(String.format("〖 法力 〗%s%d/%d" + NOR, status_color(mana, max_mana), mana, max_mana)).append(NEWLINE);
		sb.append(String.format("〖 潜能 〗%d", pot)).append(" ");
		sb.append(String.format("〖 杀气 〗%d", bellicosity)).append(NEWLINE);
		sb.append(String.format("〖 武学 〗%d", combat_exp)).append(" ");
		sb.append(String.format("〖 道行 〗%d", daoxing)).append(NEWLINE);
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
