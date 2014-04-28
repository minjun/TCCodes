package repo;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

import domain.map.Room;

public interface RoomRepository extends CouchbaseRepository<Room, String> {

}
