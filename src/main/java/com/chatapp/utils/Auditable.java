package com.chatapp.utils;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm a", timezone = "Asia/Kolkata")
	@Column(name = "created_on", nullable = false, updatable = false)
	private LocalDateTime createdOn;

	@UpdateTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm a", timezone = "Asia/Kolkata")
	@Column(name = "modified_on")
	private LocalDateTime modifiedOn;

	public Auditable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Auditable(LocalDateTime createdOn, LocalDateTime modifiedOn, Integer createdBy, Integer modifiedBy) {
		super();
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Override
	public String toString() {
		return "Auditable [createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + "]";
	}

}
