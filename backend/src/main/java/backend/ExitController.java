package backend;

import backend.model.DoorwayEvent;
import backend.repositories.IExitRepository;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;

import javax.inject.Inject;
import java.util.List;

@Controller("exit")
public class ExitController {

    private final IExitRepository repo;

    @Inject
    public ExitController(IExitRepository repo) {
        this.repo = repo;
    }

    @Post
    public Single exit(@Body String doorway) {
        return repo.writeExit(doorway);
    }

    @Get
    public Single<List<DoorwayEvent>> getAllExits() {
        return repo.getAllExits();
    }
}