package domain.item;

public class ArmorBuilder {
	private Item item;

	public ArmorBuilder(Item item) {
		this.item = item;
	}

	public Item getArmor() {
		item.setKind(Item.ItemKind.armor);
		return item;
	}
}
