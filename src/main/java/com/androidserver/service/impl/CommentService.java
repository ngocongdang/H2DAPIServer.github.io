package com.androidserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.androidserver.converter.CommentConverter;
import com.androidserver.dto.CommentDTO;
import com.androidserver.entity.CommentEntity;
import com.androidserver.entity.SongEntity;
import com.androidserver.entity.UserEntity;
import com.androidserver.reponsitory.CommentReponsitory;
import com.androidserver.reponsitory.SongReponsitory;
import com.androidserver.reponsitory.UserReponsitory;

@Service
public class CommentService {

	@Autowired 
	private CommentReponsitory commentReponsitory;
	
	@Autowired
	private CommentConverter commentConverter;
	
	@Autowired 
	private UserReponsitory userReponsitory;
	
	@Autowired 
	private SongReponsitory songReponsitory;
	
	public List<CommentEntity> findByStatus(int status) {
		return commentReponsitory.findByStatus(status);
	}
	
	
	public void save(CommentDTO stock) {
    	CommentEntity commentEntity = new CommentEntity();
    	if(stock.getId() !=null) {
    		CommentEntity oldEntity = commentReponsitory.findOne(stock.getId());
    		commentEntity = commentConverter.dtoToEntity(stock, oldEntity);
    	}else {
    		commentEntity = commentConverter.dtoToEntity(stock);
		}
    	UserEntity userEntity = userReponsitory.findOne(stock.getUserId());
    	SongEntity songEntity = songReponsitory.findOne(stock.getSongId());
    	commentEntity.setUserEntity(userEntity);
    	commentEntity.setSong(songEntity);
    	commentEntity =commentReponsitory.save(commentEntity);
    }
	

}
