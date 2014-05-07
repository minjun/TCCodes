package service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.map.World;
import repo.WorldRepository;
import service.WorldService;

@Service("worldService")
public class WorldServiceImpl implements WorldService {
	World world = null;
	@Autowired
	WorldRepository worldRepo;

	@PostConstruct
	private void init() {
		world = worldRepo.findOne("world");
	}

	public World getWorld() {
		// TODO Auto-generated method stub
		return world;
	}

	public void saveWorld(World world) {
		// TODO Auto-generated method stub
		if (world == null)
			return;
		worldRepo.save(world);
	}

}