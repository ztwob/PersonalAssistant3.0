import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
/*
 * 这是总表
 */
public class TotList implements ActionListener{
	ArrayList<TaskList> totList;
	Viewer mainViewer;
	int numberOfTaskList;//总表中任务清单的数量

	public TotList() {
		totList = new ArrayList<TaskList>();
	}

	public void setMainViewer(Viewer viewer) {
		mainViewer = viewer;
	}

	public void creatNewTaskList(int type,String name) {//创建你任务清单
		TaskList newTaskList;
		newTaskList = new TaskList(this,numberOfTaskList,type,name);
		numberOfTaskList++;
		totList.add(newTaskList);
		mainViewer.creatTaskListPanel(newTaskList);
	}

	public void deleteTaskList(TaskList taskList) {
		mainViewer.deleteTaskListPanel(taskList.taskListPanel);
		totList.remove(taskList);
		numberOfTaskList--;
	}

	public void sortTaskListByType() {//按任务清单的type排序
		final Comparator<TaskList> typeComparator = new Comparator<TaskList>() {
			 public int compare(TaskList x, TaskList y) {
				 return x.taskListType-y.taskListType;
			 }
		};
		Collections.sort(totList,typeComparator);
		for(int i=0 ; i<totList.size() ; i++) {
			totList.get(i).setTaskListIndex(i);
		}
		mainViewer.sortTaskListPanel();
	}

	public void sortTaskListByNumber() {//按任务清单的的任务数排序
		final Comparator<TaskList> numberComparator = new Comparator<TaskList>() {
			 public int compare(TaskList x, TaskList y) {
				 return x.numberOfTask-y.numberOfTask;
			 }
		};
		Collections.sort(totList,numberComparator);
		for(int i=0 ; i<totList.size() ; i++) {
			totList.get(i).setTaskListIndex(i);
		}
		mainViewer.sortTaskListPanel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonName;
		buttonName = e.getActionCommand();
		if(buttonName.equals("把任务清单按任务数排序")) {
			sortTaskListByNumber();
		}
		else if(buttonName.equals("把任务清单按任务清单种类排序")) {
			sortTaskListByType();
		}
		else if(buttonName.equals("创建新的任务清单")) {
			String name;
			int type;
			name = mainViewer.getCreatTaskListName();
			type = mainViewer.getCreatTaskListType();
			creatNewTaskList(type,name);
		}
	}
}
