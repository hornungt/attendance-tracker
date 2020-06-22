package backend.repositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import java.util.List;

/**
 * General mongodb respository class
 */
public abstract class CollectionRepository<T> {

    private final String database = "hornung-dev";
    private final MongoClient client;
    private final Class template;

    /**
     * Creates repository to access mongodb collections
     * @param template - the .class property of T
     * @param client - injected MongoClient object
     */
    @Inject
    public CollectionRepository(Class template, MongoClient client) {
        this.template = template;
        this.client = client;
    }

    /**
     * @param collection - the name of the collection
     * @return associated collection of objects of type T
     */
    protected MongoCollection<T> getCollection(String collection) {
        return client.getDatabase(database).getCollection(collection, template);
    }

    public Single<List<String>> getAllCollections() {
        return Flowable.fromPublisher(client.getDatabase(database).listCollectionNames()).toList();
    }

}
