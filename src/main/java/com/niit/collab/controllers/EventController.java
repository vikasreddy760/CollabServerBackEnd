package com.niit.collab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collab.dao.EventDAO;
import com.niit.collab.dao.EventDAO;
import com.niit.collab.model.Event;
  
     @RestController
    public class EventController {

		@Autowired
		private EventDAO eventDAO;	
		
@PostMapping(value="/createEvent")
public ResponseEntity<Event> addevent(@RequestBody Event event){
    System.out.println("hello");
    eventDAO.saveOrUpdate(event);
    return new ResponseEntity<Event>(event,HttpStatus.OK);
   
}
@PutMapping(value="/updateEvent")
public ResponseEntity<Event> updateevent(@RequestBody Event event){
	System.out.println("hello");
	eventDAO.saveOrUpdate(event);
	return new ResponseEntity<Event>(event,HttpStatus.OK);
}

@GetMapping(value="/event")
public ResponseEntity<List<Event>> listevent(){
	System.out.println("list of event");
	List<Event> event =eventDAO.list();
	return new ResponseEntity<List<Event>>(event,HttpStatus.OK);
}

@DeleteMapping(value="/deleteevent/{eventid}")
public ResponseEntity<Event> deleteevent(Event event,@PathVariable("eventid") int eventid){
	Event event1=eventDAO.get(eventid);
	eventDAO.delete(event1);
	return new ResponseEntity<Event>(event,HttpStatus.OK);
}

}


