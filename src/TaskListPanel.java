import java.awt.*;
import javax.swing.*;

import java.util.*;

public class TaskListPanel {
	TaskList taskListOfPanel;
	JPanel taskListPanel;
	JTextField taskListName;
	JTextField taskListType;
	JButton modifyButton;
	JButton deleteButton;
	JButton sortTaskByTypeButton;
	JButton sortTaskByNameButton;
	JButton sortTaskByIfCompletedButton;
	JTextField taskName;
	JTextField taskType;
	JTextField taskContent;
	JButton creatTaskButton;
	
	TaskListPanel(TaskList taskList){
		taskListOfPanel = taskList;
		taskListPanel = new JPanel();
		taskListPanel.setLayout(new BoxLayout(taskListPanel, BoxLayout.X_AXIS));
		taskListName = new JTextField(20);
		taskListType = new JTextField(20);
		modifyButton = new JButton();
		modifyButton.setText("改");
		deleteButton = new JButton();
		deleteButton.setText("删");
		sortTaskByNameButton = new JButton();
		sortTaskByNameButton.setText("按任务名排序");
		sortTaskByTypeButton = new JButton();
		sortTaskByTypeButton.setText("按类型排序");
		sortTaskByIfCompletedButton = new JButton();
		sortTaskByIfCompletedButton.setText("按是否完成排序");
		taskName = new JTextField(20);
		taskType = new JTextField(20);
		taskContent = new JTextField();
		creatTaskButton = new JButton();
		creatTaskButton.setText("建");
		
		taskListPanel.add(taskListName);
		taskListPanel.add(taskListType);
		taskListPanel.add(modifyButton);
		taskListPanel.add(deleteButton);
		taskListPanel.add(sortTaskByNameButton);
		taskListPanel.add(sortTaskByTypeButton);
		taskListPanel.add(sortTaskByIfCompletedButton);
		taskListPanel.add(taskName);
		taskListPanel.add(taskType);
		taskListPanel.add(creatTaskButton);
		
		modifyButton.addActionListener(taskList);
		deleteButton.addActionListener(taskList);
		
		taskListName.setText(taskList.taskListName);
		taskListType.setText(taskList.taskListType+"");
	}
	
	public String getTaskListName() {
		return taskListName.getText();
	}
	
	public int getTaskListType() {
		int type = Integer.valueOf(taskListType.getText());
		return  type;
	}
	
	public JPanel getTaskListPanel() {
		return taskListPanel;
	}
}
