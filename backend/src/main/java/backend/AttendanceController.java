package backend;

import backend.model.EntryEvent;
import backend.repositories.IAttendanceRepository;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;

import javax.inject.Inject;
import java.util.List;

/*
 * TODO
 *  remove stats-tracker github repo
 *  create attendance-tracker github repo
 *  move this project into attendance-tracker
 *  create features to handle ExitEvents
 *  create another/modify existing mongodb collection to account for ExitEvents
 *  implement the following endpoints:
 *   get all entries on a day
 *   get all entries between two times
 *   get current number of attendees
 */

@Controller("attendance")
public class AttendanceController {

    private final IAttendanceRepository repo;

    @Inject
    public AttendanceController(IAttendanceRepository repo) {
        this.repo = repo;
    }

    @Post
    public Single enter(@Body String entrance) {
        return repo.writeNewEntry(entrance);
    }

    @Get
    public Single<List<EntryEvent>> getAllEntries() {
        return repo.getAllEntries();
    }
}
