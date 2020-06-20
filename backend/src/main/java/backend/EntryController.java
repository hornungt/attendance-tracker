package backend;

import backend.model.DoorwayEvent;
import backend.repositories.IEntryRepository;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;

import javax.inject.Inject;
import java.util.List;

/*
 * TODO
 *  implement the following endpoints (for Entry and Exit controllers):
 *   get all entries on a day
 *   get all entries between two times
 *   get current number of attendees
 */

@Controller("entry")
public class EntryController {

    private final IEntryRepository repo;

    @Inject
    public EntryController(IEntryRepository repo) {
        this.repo = repo;
    }

    @Post
    public Single enter(@Body String doorway) {
        return repo.writeEntry(doorway);
    }

    @Get
    public Single<List<DoorwayEvent>> getAllEntries() {
        return repo.getAllEntries();
    }
}
