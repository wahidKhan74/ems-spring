package com.simplilearn.ems.ems.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

public class Auditable {
	
	@Column(name="created_at")
	private Date createdAt = new Date();
	
	@Column(name="modified_at")
	private Date modifiedAt = new Date();
	
	@Column(name="deleted_at")
	private Date deletedAt = new Date();

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	
}
