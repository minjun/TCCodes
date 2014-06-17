package service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.map.World;
import repo.WorldRepository;

@Service("worldService")
public class WorldServiceImpl {
	World world = null;
	@Autowired
	WorldRepository worldRepo;

	@PostConstruct
	private void init() {
		world = worldRepo.findOne("world");
	}

	public World getWorld() {
		return world;
	}

	public void saveWorld(World world) {
		if (world == null)
			return;
		worldRepo.save(world);
	}

}
