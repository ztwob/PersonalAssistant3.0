import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import java.lang.*;
import java.util.*;

public class Viewer {
	JFrame viewerFrame;
	JPanel viewerPanel;
	
	JLabel appNameLabel;
	JButton sortTaskListByTypeButton;
	JButton sortTaskListByNumberButton;
	JButton saveButton;
	
	JButton creatTaskListButton;
	JTextField creatTaskListType;
	JTextField creatTaskListName;
	JPanel creatTaskListPanel;
	
	TotList totList;
	
	ArrayList<TaskListPanel> taskListPanelList;
	
	public Viewer(TotList list) {
		totList = list;
		viewerFrame = new JFrame();
		viewerPanel = new JPanel();
		viewerFrame.setVisible(true);
		viewerFrame.setSize(1000, 800);
		viewerFrame.setContentPane(viewerPanel);
		
		appNameLabel = new JLabel();
		appNameLabel.setText("个人助理");
		appNameLabel.setFont(new Font(null,Font.PLAIN,25));
		viewerPanel.add(appNameLabel);
		
		//viewerPanel.setLayout(new BoxLayout(viewerPanel, BoxLayout.Y_AXIS));
		viewerPanel.setLayout(new FlowLayout());
		
		saveButton = new JButton();
		saveButton.setText("存");
		saveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Data.save(totList);
				
			}
		});
		
		sortTaskListByNumberButton = new JButton();
		sortTaskListByTypeButton = new JButton();
		sortTaskListByNumberButton.setText("把任务清单按任务数排序");
		sortTaskListByTypeButton.setText("把任务清单按任务清单种类排序");
		viewerPanel.add(saveButton);
		viewerPanel.add(sortTaskListByNumberButton);
		viewerPanel.add(sortTaskListByTypeButton);
		sortTaskListByNumberButton.addActionListener(totList);
		sortTaskListByTypeButton.addActionListener(totList);
		
		creatTaskListPanel = new JPanel();
		creatTaskListButton = new JButton();
		creatTaskListName = new JTextField(30);
		creatTaskListType = new JTextField(30);
		viewerPanel.add(creatTaskListPanel);
		creatTaskListPanel.setLayout(new FlowLayout());
		creatTaskListButton.setText("创建新的任务清单");
		creatTaskListPanel.add(creatTaskListButton);
		creatTaskListButton.addActionListener(totList);
		creatTaskListPanel.add(creatTaskListName);
		creatTaskListPanel.add(creatTaskListType);
		
		taskListPanelList = new ArrayList<TaskListPanel>();
	}
	
	public void deleteTaskListPanel(TaskListPanel taskListPanel) {
		taskListPanelList.remove(taskListPanel);
		viewerPanel.remove(taskListPanel.getTaskListPanel());
	}
	
	public void sortTaskListPanel() {
		final Comparator<TaskListPanel> indexComparator = new Comparator<TaskListPanel>() {
			 public int compare(TaskListPanel x, TaskListPanel y) {
				 return x.taskListOfPanel.taskListIndex-y.taskListOfPanel.taskListIndex;
			 }
		};
		Collections.sort(taskListPanelList,indexComparator);
		for(int i=0 ; i<taskListPanelList.size(); i++) {
			viewerPanel.remove(taskListPanelList.get(i).getTaskListPanel());
		}
		for(int i=0 ; i<taskListPanelList.size(); i++) {
			viewerPanel.add(taskListPanelList.get(i).getTaskListPanel());
		}
	}
	
	public void creatTaskListPanel(TaskList taskList) {
		TaskListPanel newTaskListPanel = new TaskListPanel(taskList);
		taskListPanelList.add(newTaskListPanel);
		viewerPanel.add(newTaskListPanel.getTaskListPanel());
		taskList.setTaskListPanel(newTaskListPanel);
	}
	
	public String getCreatTaskListName() {
		return creatTaskListName.getText();
	}
	
	public int getCreatTaskListType() {
		int type = Integer.valueOf(creatTaskListType.getText());
		return type;
	}
	
	public void test() {
		/*JFrame frame = new JFrame("Hello World");
		frame.setSize(1000, 800);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.setContentPane(panel);
		/*JTextField textField;
		textField = new JTextField();
		panel.add(textField);
		textField.setBounds(200, 200, 500, 20);
		JButton button;
		button = new JButton();
		button.setBounds(0, 0, 100, 100);
		panel.setLayout(new FlowLayout());
		button.setName("Button");
		panel.add(button);*/
	}
}
