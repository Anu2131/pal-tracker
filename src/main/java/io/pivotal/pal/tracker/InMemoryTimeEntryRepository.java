package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    HashMap<Long,TimeEntry> map=new HashMap<>();
    long counter=0;
    public TimeEntry create(TimeEntry timeEntry) {
    timeEntry.setId(++counter);
    map.put(timeEntry.getId(),timeEntry);
        return map.get(timeEntry.getId());
    }

    public TimeEntry find(long id) {

        return map.get(id);
    }

    public List list() {
        return new ArrayList(map.values()) ;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(map.containsKey(id)){
        timeEntry.setId(id);
        map.put(timeEntry.getId(),timeEntry);
        return timeEntry;
    }
    else
    return null;
    }

    public void delete(long id) {
        map.remove(id);
    }
}
