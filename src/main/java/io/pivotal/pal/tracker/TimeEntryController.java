package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    TimeEntryRepository timeEntryRepository;
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
this.timeEntryRepository=timeEntryRepository;
    }
/* public TimeEntryController(TimeEntryRepository timeEntryRtimeepository) {
        return null;
    }*/

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        return new ResponseEntity(timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED);

    }
    @GetMapping("{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        TimeEntry obj=timeEntryRepository.find(timeEntryId);
        if(obj==null){
            return new ResponseEntity(obj, HttpStatus.NOT_FOUND);
        }
        else
        return new ResponseEntity(obj, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity(timeEntryRepository.list(), HttpStatus.OK);
    }
    @PutMapping("{timeEntryId}")
    public ResponseEntity update(@PathVariable long timeEntryId,@RequestBody TimeEntry expected) {
       TimeEntry obj=timeEntryRepository.update(timeEntryId, expected);
        if (obj!=null) {
        return new ResponseEntity(obj, HttpStatus.OK);
    }
    else{
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }}
    @DeleteMapping("{timeEntryId}")
    public ResponseEntity delete(@PathVariable long timeEntryId) {

            timeEntryRepository.delete(timeEntryId);
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);

}}
