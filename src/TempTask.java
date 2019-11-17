import java.util.*;

public class TempTask extends Task{
	
	Date deadlineDate;
	
	public TempTask() {
		super();
		taskType = 1;
		deadlineDate = new Date();
	}
	
	public void setDeadlineDate(int year,int month,int day) {
		deadlineDate.setYear(year);
		deadlineDate.setMonth(month);
		deadlineDate.setDate(day);
	}
}
