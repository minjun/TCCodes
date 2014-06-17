package repo;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

import domain.item.Item;

public interface ItemRepository extends CouchbaseRepository<Item, String> {

}
