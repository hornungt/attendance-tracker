package backend.repositories;

import backend.model.EntryEvent;
import io.reactivex.Single;

import java.util.List;

public interface IAttendanceRepository {
    Single writeNewEntry(String entrance);
    Single<List<EntryEvent>> getAllEntries();
}
