package backend.repositories;

import backend.model.DoorwayEvent;
import io.reactivex.Single;

import java.util.List;

public interface IDoorwayRepository {

    Single<DoorwayEvent> writeEvent(String doorway, boolean isExit);
    Single<List<DoorwayEvent>> getAllEvents(String doorway);
    Single<List<DoorwayEvent>> getAllUnidirectional(String doorway, boolean isExit);
    Single<List<String>> getAllCollections();
    Single<Long> getTotalUnidirectional(String doorway, boolean isExit);
}
