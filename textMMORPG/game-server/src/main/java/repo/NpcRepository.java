package repo;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

import domain.charactor.Npc;

public interface NpcRepository extends CouchbaseRepository<Npc, String> {

}
