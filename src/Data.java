import java.io.*;
import java.util.ArrayList;

public class Data {
	static File file;
	static PrintWriter output;
	
	static public void solve(Task task) {
		output.println(task.taskType);
		output.println(task.isComplete);
		output.println(task.taskName);
		output.println(task.taskContent);
		if(task.taskType == 1) {
			TempTask tempTask = (TempTask)task;
			output.println(tempTask.deadlineDate);
		}
		else if(task.taskType == 2) {
			CycleTask cycleTask = (CycleTask)task;
			output.println(cycleTask.todoDate);
			output.println(cycleTask.taskCycle);
		}
		else if(task.taskType == 3) {
			LongTask longTask = (LongTask)task;
			output.println(longTask.deadlineDate);
			output.println(longTask.numberOfSubtask);
			for(int i=0; i<longTask.subtaskList.size(); i++) {
				solve(longTask.subtaskList.get(i));
			}
		}
	}
	
	static public void save(TotList totList) {
		file = new File("1.txt");
		try{
			output = new PrintWriter(file);
		}catch (IOException e) {}
		finally{}
		output.println(totList.numberOfTaskList);
		ArrayList<TaskList> taskLists = totList.totList;
		ArrayList<Task> taskList;
		for(int i=0 ; i<taskLists.size() ; i++){
			output.println(taskLists.get(i).numberOfTask);
			output.println(taskLists.get(i).taskListType);
			output.println(taskLists.get(i).taskListName);
			taskList = taskLists.get(i).taskList;
			for(int j=0 ; j<taskList.size() ; j++) {
				solve(taskList.get(i));
			}
		}
		output.close();
	}
}
