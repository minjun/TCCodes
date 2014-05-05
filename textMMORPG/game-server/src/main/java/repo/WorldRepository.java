package repo;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

import domain.map.World;

public interface WorldRepository extends CouchbaseRepository<World, String> {

}
