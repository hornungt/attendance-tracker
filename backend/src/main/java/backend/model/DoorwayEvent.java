package backend.model;

import java.time.LocalDateTime;

public class DoorwayEvent {
    private String doorway;
    private LocalDateTime time;

    public DoorwayEvent() {
    }

    public String getDoorway() {
        return doorway;
    }

    public void setDoorway(String doorway) {
        this.doorway = doorway;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
