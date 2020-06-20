package backend.repositories;

import backend.model.DoorwayEvent;
import com.mongodb.reactivestreams.client.MongoClient;
import io.reactivex.Flowable;
import io.reactivex.Single;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

public abstract class DoorwayRepository extends CollectionRepository {

    @Inject
    public DoorwayRepository(String collection, MongoClient client) {
        super(collection, DoorwayEvent.class, client);
    }

    public Single writeNewEvent(String doorway) {
        DoorwayEvent event = new DoorwayEvent();
        event.setDoorway(doorway);
        event.setTime(LocalDateTime.now());
        return Single.fromPublisher(getCollection().insertOne(event));
    }

    public Single<List<DoorwayEvent>> getAllEvents() {
        return Flowable.fromPublisher(getCollection().find()).toList();
    }
}
