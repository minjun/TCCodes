package dao;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

import domain.Player;

public interface PlayerRepository extends CouchbaseRepository<Player, String> {
}
