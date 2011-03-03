package org.mtech.mytodo.core;

import java.util.List;

import org.mtech.mytodo.data.Task;

public interface TaskManager {
	public Task addTask(Task t);
	public Task upateTask(Task t);
	public Task findTaskById(Integer id);
	public List<Task> listAllTasks();
	public void removeTask(Task task);
	void removeTask(Integer id);
}
