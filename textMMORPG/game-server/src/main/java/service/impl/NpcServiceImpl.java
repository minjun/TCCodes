package service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.charactor.Npc;
import repo.NpcRepository;
import service.WorldService;

@Service("npcService")
public final class NpcServiceImpl {
	private static final Logger logger = LoggerFactory.getLogger(NpcServiceImpl.class);
	final Map<String, Npc> rooms = new HashMap<String, Npc>();
	final static String NEWLINE = "\r\n";
	@Autowired
	NpcRepository npcRepo;
	@Autowired
	WorldService worldService;

	public void saveNpc(Npc npc) {
		npcRepo.save(npc);
	}
}