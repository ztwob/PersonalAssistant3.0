import java.util.*;

public class LongTask extends Task{
	
	Date deadlineDate;
	ArrayList<Task>subtaskList;
	int numberOfSubtask;
	
	public LongTask() {
		super();
		taskType = 3;
		deadlineDate = new Date();
		subtaskList = new ArrayList<Task>();
		numberOfSubtask = 0;
	}
	
	public void setDeadlineDate(int year,int month,int day) {
		deadlineDate.setYear(year);
		deadlineDate.setMonth(month);
		deadlineDate.setDate(day);
	}
	
	public void addTask(Task task) {
		numberOfSubtask++;
		Task newtask = Task.cloneTask(task);
		subtaskList.add(newtask);
	}
	
	public Task getTaskOfIndex(int index) {
		return subtaskList.get(index);
	}
	
	public void creatNewTask() {
		numberOfSubtask++;
		subtaskList.add(new Task());
	}
	
	public void deleteTask(int index) {
		subtaskList.remove(index);
	}
	
	public void deleteTask(Task task) {
		subtaskList.remove(task);
	}
	
	public int getIndexOfTask(Task task) {
		return subtaskList.indexOf(task);
	}
}
