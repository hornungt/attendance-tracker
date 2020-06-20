package backend.repositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;

import javax.inject.Inject;

public abstract class CollectionRepository {

    private final String database = "hornung-dev";
    private final String collection;
    private final MongoClient client;
    private final Class template;

    @Inject
    public CollectionRepository(String collection, Class template, MongoClient client) {
        this.collection = collection;
        this.template = template;
        this.client = client;
    }

    protected MongoCollection getCollection() {
        return client.getDatabase(database).getCollection(collection, template);
    }

}
