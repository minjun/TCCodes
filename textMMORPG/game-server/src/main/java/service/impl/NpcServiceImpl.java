package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.charactor.Npc;
import repo.NpcRepository;

@Service("npcService")
public final class NpcServiceImpl {
	// private static final Logger logger =
	// LoggerFactory.getLogger(NpcServiceImpl.class);
	@Autowired
	NpcRepository npcRepo;
	@Autowired
	WorldServiceImpl worldService;

	public void save(Npc npc) {
		npcRepo.save(npc);
	}

	public Npc load(String id) {
		return npcRepo.findOne(id);
	}
}