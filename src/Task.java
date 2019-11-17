public class Task {
	int isComplete;
	int taskType;
	String taskName;
	String taskContent;
	TaskList taskListOfTaskList;
	public Task() {
		isComplete = 0;
		taskType = 0;
	}
	
	static public Task cloneTask(Task task) {
		if(task.taskType==0) {
			Task newtask = new Task();
			newtask.taskType = task.taskType;
			newtask.isComplete = task.isComplete;
			newtask.taskName = task.taskName;
			newtask.taskContent = task.taskContent;
			return newtask;
		}else if(task.taskType==1) {
			TempTask newtask = new TempTask();
			TempTask tempTask = (TempTask)task;
			newtask.taskType = tempTask.taskType;
			newtask.isComplete = tempTask.isComplete;
			newtask.taskName = tempTask.taskName;
			newtask.taskContent = tempTask.taskContent;
			newtask.deadlineDate = tempTask.deadlineDate;
			return newtask;
		}else if(task.taskType==2) {
			CycleTask newtask = new CycleTask();
			CycleTask cycleTask = (CycleTask)task;
			newtask.taskType = cycleTask.taskType;
			newtask.isComplete = cycleTask.isComplete;
			newtask.taskName = cycleTask.taskName;
			newtask.taskContent = cycleTask.taskContent;
			newtask.todoDate = cycleTask.todoDate;
			newtask.taskCycle = cycleTask.taskCycle;
			return newtask;
		}else if(task.taskType==3) {
			LongTask newtask = new LongTask();
			LongTask longTask = (LongTask)task;
			newtask.taskType = longTask.taskType;
			newtask.isComplete = longTask.isComplete;
			newtask.taskName = longTask.taskName;
			newtask.taskContent = longTask.taskContent;
			newtask.deadlineDate = longTask.deadlineDate;
			for(int i=0 ; i<longTask.subtaskList.size() ; i++) {
				newtask.addTask(Task.cloneTask(longTask.subtaskList.get(i)));
			}
			return newtask;
		}
		return null;
	}
	
	public void setTaskComplete() {
		isComplete = 1;
	}
	
	public void setTaskName(String name) {
		taskName = name;
	}
	
	public void setTaskContent(String content) {
		taskContent = content;
	}
	
	public void setTaskListOfTask(TaskList taskList) {
		taskListOfTaskList = taskList;
	}
}
