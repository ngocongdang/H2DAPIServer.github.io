package com.androidserver.converter;

import org.springframework.stereotype.Component;

import com.androidserver.dto.CommentDTO;
import com.androidserver.entity.CommentEntity;

@Component
public class CommentConverter {

	public CommentEntity dtoToEntity(CommentDTO dto, CommentEntity entity) {

		entity.setContent(dto.getContent());
		entity.setStatus(dto.getStatus());
		return entity;

	}

	public  CommentEntity dtoToEntity(CommentDTO dto) {
		CommentEntity comentEntity = new CommentEntity();
		comentEntity.setContent(dto.getContent());
		comentEntity.setStatus(dto.getStatus());
		return comentEntity;

	}

	public CommentDTO entityToDTO(CommentEntity entity) {
		CommentDTO dto = new CommentDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setContent(entity.getContent());
		dto.setStatus(entity.getStatus());
		
		return dto;
	}
}
