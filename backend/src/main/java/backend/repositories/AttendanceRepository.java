package backend.repositories;


import backend.model.EntryEvent;
import com.mongodb.reactivestreams.client.MongoClient;
import io.reactivex.Flowable;
import io.reactivex.Single;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class AttendanceRepository extends CollectionRepository implements IAttendanceRepository {

    @Inject
    public AttendanceRepository(MongoClient client) {
        super("attendance-tracker", EntryEvent.class, client);
    }

    public Single writeNewEntry(String entrance) {
        EntryEvent entry = new EntryEvent();
        entry.setEntrance(entrance);
        entry.setTime(LocalDateTime.now());
        return Single.fromPublisher(getCollection().insertOne(entry));
    }

    public Single<List<EntryEvent>> getAllEntries() {
        return Flowable.fromPublisher(getCollection().find()).toList();
    }
}
