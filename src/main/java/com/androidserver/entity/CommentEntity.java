package com.androidserver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity{

	@Column(name  ="content")
	private String content;
	
	@Column(name= "status")
	private int status;

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;

	@ManyToOne()
	@JoinColumn(name = "song_Id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private SongEntity song;

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public SongEntity getSong() {
		return song;
	}

	public void setSong(SongEntity song) {
		this.song = song;
	}

	
	
	
	
	
	
	
}
