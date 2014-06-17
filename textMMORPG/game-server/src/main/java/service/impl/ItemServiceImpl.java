package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repo.ItemRepository;
import domain.item.Item;
import static utils.Utils.NEWLINE;

@Service("itemService")
public final class ItemServiceImpl {
	// private static final Logger logger =
	// LoggerFactory.getLogger(NpcServiceImpl.class);
	@Autowired
	ItemRepository itemRepo;
	@Autowired
	WorldServiceImpl worldService;

	public void save(Item item) {
		itemRepo.save(item);
	}

	public Item load(String id) {
		return itemRepo.findOne(id);
	}
}