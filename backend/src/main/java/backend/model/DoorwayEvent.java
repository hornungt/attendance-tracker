package backend.model;

import java.time.LocalDateTime;

/**
 * Represents a entry or exit through a doorway. Which doorway is implicity stored based on the name of the mongodb collection
 */
public class DoorwayEvent {

    private LocalDateTime time;
    private boolean isExit;

    public DoorwayEvent() {
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public boolean getIsExit() {
        return isExit;
    }

    public void setIsExit(boolean isExit) {
        this.isExit = isExit;
    }
}
