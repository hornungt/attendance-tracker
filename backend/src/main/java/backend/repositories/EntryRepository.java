package backend.repositories;

import backend.model.DoorwayEvent;
import com.mongodb.reactivestreams.client.MongoClient;
import io.reactivex.Single;

import javax.inject.Inject;
import java.util.List;

public class EntryRepository extends DoorwayRepository implements IEntryRepository {

    @Inject
    public EntryRepository(MongoClient client) {
        super("entry-tracker", client);
    }

    public Single writeEntry(String doorway) {
        return super.writeNewEvent(doorway);
    }

    public Single<List<DoorwayEvent>> getAllEntries() {
        return super.getAllEvents();
    }
}
