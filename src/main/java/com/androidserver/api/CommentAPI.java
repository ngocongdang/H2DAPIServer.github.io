package com.androidserver.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.androidserver.dto.CommentDTO;
import com.androidserver.entity.CommentEntity;
import com.androidserver.service.impl.CommentService;

@RestController
public class CommentAPI {

	@Autowired 
	private CommentService commentService;
	
	@GetMapping(value = "/comment/{status}")
	public ResponseEntity<List<CommentEntity>> search(@PathVariable("status") int status) {
		return ResponseEntity.ok(commentService.findByStatus(status));
	}


	@PostMapping("/comment")
	public ResponseEntity<String> createSong(@RequestBody CommentDTO commentDTO) {
		commentService.save(commentDTO);
		return ResponseEntity.ok("ok");
	}

	@PutMapping(value = "/comment")
	public ResponseEntity<String> updateSong(@RequestBody CommentDTO model) {
		commentService.save(model);
		return ResponseEntity.ok("ok");
	}
}
