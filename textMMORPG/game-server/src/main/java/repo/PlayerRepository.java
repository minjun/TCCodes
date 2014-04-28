package repo;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

import domain.player.Player;


public interface PlayerRepository extends CouchbaseRepository<Player, String> {
}
