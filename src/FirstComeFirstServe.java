import java.util.ArrayList;
import java.util.List;

public class FirstComeFirstServe extends SchedulingAlgorithm{
	public FirstComeFirstServe (List <Job> jobs) {
		this.jobs = new ArrayList<Job>();
		for (Job j : jobs) {
			this.jobs.add(j.clone());
		}
		time = 0;
		avgProcessTime = 0;
		avgWaitTime = 0;
		avgTurnAroundTime = 0;
	}
	@Override
	void runJobs() {
		time = 0;
		for (Job j : jobs) {
			j.setStartTime(time);
			time += j.getOverallTimeNeeded();
			j.setEndTime(time);
			j.setTimeNeeded(0);
			j.setDone(true);
		}	
	}

	@Override
	void printChart() {
		System.out.println("Job \t Start \t End \t Output");
		for (Job j : jobs) {
			System.out.println(j.getName() + " \t " + j.getStartTime() + " \t "
					+ j.getEndTime() + " \t " + j.getEndTime());
		}
		System.out.println();
		
	}

}
