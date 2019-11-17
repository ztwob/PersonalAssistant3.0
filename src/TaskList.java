import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class TaskList implements ActionListener{
	ArrayList<Task> taskList;
	String taskListName;
	int taskListIndex;
	int taskListType;
	int numberOfTask;
	TotList totListOfTaskList;
	TaskListPanel taskListPanel;
	public TaskList(TotList totList,int index,int type,String name) {
		taskList=new ArrayList<Task>();
		taskListIndex = index;
		taskListType = type;
		numberOfTask = 0;
		taskListName = name;
		totListOfTaskList = totList;
	}
	
	public void actionPerformed(ActionEvent e) {
		String buttonName;
		buttonName = e.getActionCommand();
		if(buttonName.equals("改")) {
			setTaskListName(taskListPanel.getTaskListName());
			setTaskListType(taskListPanel.getTaskListType());
		}
		else if(buttonName.equals("删")) {
			totListOfTaskList.deleteTaskList(this);
		}
	}
	
	public void setTaskListPanel(TaskListPanel panel) {
		taskListPanel = panel;
	}
	
	public void sortTaskByType() {//按任务的type排序
		final Comparator<Task> typeComparator = new Comparator<Task>() {
			 public int compare(Task x, Task y) {
				 return x.taskType-y.taskType;
			 }
		};
		Collections.sort(taskList,typeComparator);
	}
	
	public void sortTaskByName() {//按任务的name字典序排序
		final Comparator<Task> typeComparator = new Comparator<Task>() {
			 public int compare(Task x, Task y) {
				 return x.taskName.compareTo(y.taskName);
			 }
		};
		Collections.sort(taskList,typeComparator);
	}
	
	public void sortTaskByIfCompleted() {//按任务是否完成排序
		final Comparator<Task> typeComparator = new Comparator<Task>() {
			 public int compare(Task x, Task y) {
				 return x.isComplete-y.isComplete;
			 }
		};
		Collections.sort(taskList,typeComparator);
	}
	
	public void setTaskOfIndexLong(int index) {
		taskList.set(index, new LongTask());
	}
	
	public void setTaskOfIndexCycle(int index) {
		taskList.set(index, new CycleTask());
	}
	
	public void setTaskOfIndexTemp(int index) {
		taskList.set(index, new TempTask());
	}
	
	public void addTask(Task task) {
		numberOfTask++;
		Task newtask = Task.cloneTask(task);
		newtask.setTaskListOfTask(this);
		taskList.add(newtask);
	}
	
	public int getIndexOfTask(Task task) {
		return taskList.indexOf(task);
	}
	
	public Task getTaskOfIndex(int index) {
		return taskList.get(index);
	}
	
	public void creatNewTask() {
		Task task = new Task();
		numberOfTask++;
		task.setTaskListOfTask(this);
		taskList.add(task);
	}
	
	public void deleteTask(int index) {
		numberOfTask--;
		taskList.remove(index);
	}
	
	public void deleteTask(Task task) {
		numberOfTask--;
		taskList.remove(task);
	}
	
	public void setTaskListName(String name) {
		taskListName = name;
	}
	
	public void setTaskListType(int type) {
		taskListType = type;
	}
	
	public void setTaskListIndex(int index) {
		taskListIndex = index;
	}
}
