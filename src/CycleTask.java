import java.util.*;

public class CycleTask extends Task{
	
	Date todoDate;
	int taskCycle;
	
	public CycleTask() {
		super();
		taskType = 2;
		todoDate = new Date();
		taskCycle = 0;
	}
	
	public void settodoDate(int year,int month,int day) {
		todoDate.setYear(year);
		todoDate.setMonth(month);
		todoDate.setDate(day);
	}
	
	public void setTaskCycle(int cycle) {
		taskCycle = cycle;
	}
}
