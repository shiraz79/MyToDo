package org.mtech.mytodo.core;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mtech.mytodo.data.Task;

public class TaskManagerTest extends BaseTest{
	static TaskManager tm;
	
	@Before
	public void setup() {
		try {
			tm = (TaskManager) ctx.lookup("TaskManagerBean/remote");
		} catch (NamingException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testAddTask() throws Exception {
		Task t = new Task();
		t.setName("take kontoauszug");
		Calendar c = Calendar.getInstance();
		c.set(2011, 03, 04);
		t.setStartDate(new Date(c.getTimeInMillis()));
		Task newTask = tm.addTask(t);
		assertNotNull(newTask);
		assertTrue(newTask.getName().equals("take kontoauszug"));
		assertTrue(newTask.getStartDate().compareTo(c.getTime()) == 0);
	}
	
	@Test
	public void testFindTaskById(){
		Integer id = tm.listAllTasks().get(0).getId();
		assertNotNull(tm.findTaskById(id));
	}
	
	@Test
	public void testUpdateTask(){
		Task t = new Task();
		t.setId(2);
		t.setName("mail to dad");
		Calendar c = Calendar.getInstance();
		c.set(2011, 04, 04);
		t.setStartDate(new Date(c.getTimeInMillis()));
		Task updatedTask = tm.upateTask(t);
		assertNotNull(updatedTask);
		assertEquals(updatedTask.getName(),"mail to dad");
		assertTrue(updatedTask.getStartDate().compareTo(c.getTime()) == 0);
	}
	
	@Test
	public void testfindAllTasks(){
		List<Task> lst = tm.listAllTasks();
		assertTrue(lst.size() > 1);
		for (Task t : lst){
			System.out.println(t.getName());
		}
	}
	@Ignore
	@Test
	public void testRemoveTask(){
		List<Task> lstTask = tm.listAllTasks();
		Integer id = lstTask.get(0).getId();
		System.out.println("removing task with id: "+id);
		Task t = tm.findTaskById(id);
		assertNotNull(t);
		tm.removeTask(id);
		//delete confirmation
		assertNull(tm.findTaskById(id));
	}

}
