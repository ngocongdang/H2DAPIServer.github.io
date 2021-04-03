package com.androidserver.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.androidserver.entity.CommentEntity;

public interface CommentReponsitory extends JpaRepository<CommentEntity, Long>{

	@Query(value = "select * from comment where status = ?1", nativeQuery = true)
	public List<CommentEntity> findByStatus(int status);
}
