package backend.repositories;

import backend.model.DoorwayEvent;
import com.mongodb.reactivestreams.client.MongoClient;
import io.reactivex.Single;

import javax.inject.Inject;
import java.util.List;

public class ExitRepository extends DoorwayRepository implements IExitRepository {

    @Inject
    public ExitRepository(MongoClient client) {
        super("exit-tracker", client);
    }

    @Override
    public Single writeExit(String doorway) {
        return super.writeNewEvent(doorway);
    }

    @Override
    public Single<List<DoorwayEvent>> getAllExits() {
        return super.getAllEvents();
    }
}
