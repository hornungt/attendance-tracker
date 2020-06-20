package backend.model;

import java.time.LocalDateTime;

public class EntryEvent {
    private String entrance;
    private LocalDateTime time;

    public EntryEvent() {
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
