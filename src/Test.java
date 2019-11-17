import java.io.IOException;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) throws IOException{
		TotList myTotList = new TotList();
		Viewer viewer = new Viewer(myTotList);
		myTotList.setMainViewer(viewer);
		Data.save(myTotList);
		myTotList.creatNewTaskList(11, "test");
		ArrayList<TaskList> taskLists = myTotList.totList;
		TaskList taskList = taskLists.get(taskLists.size()-1);
		taskList.creatNewTask();
		Task task = taskList.taskList.get(0);
		task.setTaskComplete();
		task.setTaskContent("asfdsbf");
		task.setTaskName("吃");
		System.out.print("hello world");
	}
}
