package backend.repositories;

import backend.model.DoorwayEvent;
import io.reactivex.Single;

import java.util.List;

/**
 * Used for dependency injection
 *
 * defines methods used to give more meaning to methods in DoorwayRepository.java
 */
public interface IExitRepository {
    Single writeExit(String doorway);
    Single<List<DoorwayEvent>> getAllExits();
}
