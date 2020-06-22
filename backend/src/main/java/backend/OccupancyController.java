package backend;

import backend.model.DoorwayEvent;
import backend.repositories.IDoorwayRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller("/occupancy")
public class OccupancyController {

    private final IDoorwayRepository repo;

    @Inject
    public OccupancyController(IDoorwayRepository repo) {
        this.repo = repo;
    }

    @Get("{doorway}")
    public Single<Long> getCurrentOccupancy(String doorway) {
        long count = repo.getTotalUnidirectional(doorway, false).blockingGet() -
                repo.getTotalUnidirectional(doorway, true).blockingGet();
        return Single.just(count >= 0 ? count : 0);
    }

    @Get("events")
    public Single<List<DoorwayEvent>> getAllEvents() {
        return repo.getAllCollections().map((c) -> {
            List<DoorwayEvent> events = new ArrayList<>();
            c.forEach(collection -> {
                events.addAll(repo.getAllEvents(collection).blockingGet());
            });
            return events;
        });
    }

    @Post("events/entry/{doorway}")
    public Single<DoorwayEvent> postEntry(String doorway) {
        return repo.writeEvent(doorway, false);
    }

    @Post("events/exit/{doorway}")
    public Single<DoorwayEvent> postExit(String doorway) {
        return repo.writeEvent(doorway, true);
    }

    @Get("events/{doorway}")
    public Single<List<DoorwayEvent>> getEventsByDoorway(String doorway) {
        return repo.getAllEvents(doorway);
    }

    @Get("stats/{doorway}/{day}")
    public Single<Integer> getVisitorsTotalByDay(String doorway, LocalDate day) {
        return null;
    }

}
