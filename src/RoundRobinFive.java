import java.util.ArrayList;
import java.util.List;

public class RoundRobinFive extends SchedulingAlgorithm {
	private int jobsLeft;
	public RoundRobinFive (List <Job> jobs) {
		this.jobs = new ArrayList<Job>();
		for (Job j : jobs) {
			this.jobs.add(j.clone());
		}
		jobsLeft = jobs.size();
		time = 0;
		avgProcessTime = 0;
		avgWaitTime = 0;
		avgTurnAroundTime = 0;
	}
	
	@Override
	void runJobs() {
		time = 0;
		System.out.println("Job \t Start \t End \t Output");
		while (jobsLeft > 0) {
			for (Job j : jobs) {
				if (!j.isDone()) {
					if (j.getTimeNeeded() > 5) {
						System.out.println(j.getName() + " \t " + time + " \t " + (time + 2));
						j.setTimeNeeded(j.getTimeNeeded() - 2);
						time += 2;
					}
					else if (j.getTimeNeeded() <= 5) {
						time += j.getTimeNeeded();
						System.out.println(j.getName() + " \t " + (time - j.getTimeNeeded()) + " \t " + time + " \t " + time);
						j.setDone(true);
						j.setEndTime(time);
						
						jobsLeft--;
					}
				}
				
			}
		}
		
	}

	@Override
	void printChart() {
		
		
	}
	public int getJobsLeft() {
		return jobsLeft;
	}
	public void setJobsLeft(int jobsLeft) {
		this.jobsLeft = jobsLeft;
	}

}
