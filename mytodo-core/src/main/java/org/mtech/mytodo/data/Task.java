package org.mtech.mytodo.data;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(query="select t from Task t", name = Task.QUERY_FIND_ALL_TASKS)
public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String QUERY_FIND_ALL_TASKS = "findAllTasks";
	
	@Id
	@GeneratedValue 
	private int id;

	@Column(nullable = false)
	private String name;

	private Date endDate;

	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date taskCreatedAt;

	public java.util.Date getTaskCreatedAt() {
		return taskCreatedAt;
	}

	public void setTaskCreatedAt(java.util.Date taskCreatedAt) {
		this.taskCreatedAt = taskCreatedAt;
	}

	public Task() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
