package Domain;

import java.util.ArrayList;
import java.util.Objects;

public class Event extends Entity {

    private String id, name, date, length, startTime;

    /**
     * Constructor
     * @param id
     * @param name
     * @param date
     * @param length
     * @param startTime
     */
    public Event(String id, String name, String date, String length, String startTime) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.length = length;
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id.equals(event.id) &&
                name.equals(event.name) &&
                date.equals(event.date) &&
                length.equals(event.length) &&
                startTime.equals(event.startTime);
    }

    /**
     * Used for the full text search functionality
     * @return
     */
    @Override
    public String toString() {
        return "Event{" +
                "id='" + getId() + '\'' +
                ", Name='" + getName() + '\'' +
                ", Date='" + getDate() + '\'' +
                ", Length='" + getLength() + '\'' +
                ", StartTime='" + getStartTime() + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    @Override
    public ArrayList<String> getSearchableFields() {
        return null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
