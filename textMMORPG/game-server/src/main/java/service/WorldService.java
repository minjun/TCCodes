package service;

import domain.map.World;

public interface WorldService {
	World getWorld();
	void saveWorld(World world);
}
