package backend.repositories;

import backend.model.DoorwayEvent;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import io.reactivex.Flowable;
import io.reactivex.Single;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class DoorwayRepository extends CollectionRepository<DoorwayEvent> implements IDoorwayRepository {

    @Inject
    public DoorwayRepository(MongoClient client) {
        super(DoorwayEvent.class, client);
    }

    @Override
    public Single<DoorwayEvent> writeEvent(String doorway, boolean isExit) {
        DoorwayEvent event = new DoorwayEvent();
        event.setTime(LocalDateTime.now());
        event.setIsExit(isExit);
        return Single.fromPublisher(getCollection(doorway).insertOne(event)).map(success -> event);
    }

    @Override
    public Single<List<DoorwayEvent>> getAllEvents(String doorway) {
        return Flowable.fromPublisher(getCollection(doorway).find()).toList();
    }

    @Override
    public Single<List<DoorwayEvent>> getAllUnidirectional(String doorway, boolean isExit) {
        return Flowable.fromPublisher(getCollection(doorway).find(eq("isExit", isExit))).toList();
    }

    @Override
    public Single<Long> getTotalUnidirectional(String doorway, boolean isExit) {
        return Single.fromPublisher(getCollection(doorway).countDocuments(eq("isExit", isExit)));
    }
}
