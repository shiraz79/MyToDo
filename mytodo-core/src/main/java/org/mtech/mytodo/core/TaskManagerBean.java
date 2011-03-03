package org.mtech.mytodo.core;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.mtech.mytodo.data.Task;

@Stateless
@Remote(value = { TaskManager.class })
public class TaskManagerBean implements TaskManager {
	Logger logger = Logger.getLogger(TaskManagerBean.class);
	
	@PersistenceContext(unitName = "mytodo")
	EntityManager em;

	@Override
	public Task addTask(Task t) {
		logger.info("adding task");
		em.persist(t);
		return t;
	}

	@Override
	public Task upateTask(Task t) {
		Task task = em.merge(t);
		return task;
	}

	@Override
	public Task findTaskById(Integer id) {
		Task t = em.find(Task.class, id);
		return t;
	}

	@Override
	public List<Task> listAllTasks() {
		Query q = em.createNamedQuery(Task.QUERY_FIND_ALL_TASKS);
		return q.getResultList();
	}

	@Override
	public void removeTask(Task task) {
		logger.info("removing task with id: "+ task.toString());
		em.remove(em.merge(task));		
	}

	@Override
	public void removeTask(Integer id) {
		Task t = em.find(Task.class, id);
		logger.info("removing task with id: "+ t.toString());
		em.remove(t);		
	}
	
}
