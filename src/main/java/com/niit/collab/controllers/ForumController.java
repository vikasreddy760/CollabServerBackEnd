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

import com.niit.collab.dao.ForumDAO;
import com.niit.collab.model.Forum;
import com.niit.collab.model.Forum;
import com.niit.collab.model.Forum;

@RestController
public class ForumController {
@Autowired
private ForumDAO forumDAO;


@PostMapping(value="/createForum")
public ResponseEntity<Forum> addforum(@RequestBody Forum forum){
	System.out.println("hello");
	forumDAO.saveOrUpdate(forum);
	return new ResponseEntity<Forum>(forum,HttpStatus.OK);
}

@PutMapping(value="/updateForum")
public ResponseEntity<Forum> updateforum(@RequestBody Forum forum){
	System.out.println("hello");
	forumDAO.saveOrUpdate(forum);
	return new ResponseEntity<Forum>(forum,HttpStatus.OK);
}
@GetMapping(value="/forum")
public ResponseEntity<List<Forum>> listforum(){
	System.out.println("list of forum");
	List<Forum> forum =forumDAO.list();
	return new ResponseEntity<List<Forum>>(forum,HttpStatus.OK);
}
@DeleteMapping(value="/deleteforum/{forumid}")
public ResponseEntity<Forum> deleteforum(Forum forum,@PathVariable("forumid") int forumid){
	Forum forum1=forumDAO.get(forumid);
	forumDAO.delete(forum1);
	return new ResponseEntity<Forum>(forum,HttpStatus.OK);
}
}