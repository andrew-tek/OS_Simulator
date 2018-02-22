import java.util.ArrayList;
import java.util.List;

public abstract class SchedulingAlgorithm {
	protected List <Job> jobs;
	protected int time = 0;
	protected double avgProcessTime;
	protected double avgWaitTime;
	protected double avgTurnAroundTime;
	
	public SchedulingAlgorithm () {
		avgProcessTime = 0;
		avgWaitTime = 0;
		avgTurnAroundTime = 0;
	}
	public SchedulingAlgorithm (List <Job> jobs) {
		this.jobs = new ArrayList <Job> (jobs);
		time = 0;
		avgProcessTime = 0;
		avgWaitTime = 0;
		avgTurnAroundTime = 0;
	}
	
	abstract void runJobs();
	abstract void printChart();
	
	public void calculate() {
		avgProcessTime = 0;
		avgWaitTime = 0;
		avgTurnAroundTime = 0;
		for (Job j : jobs) {
			avgProcessTime += j.getOverallTimeNeeded();
			avgTurnAroundTime += j.getEndTime();
		}
		avgProcessTime /= jobs.size();
		avgTurnAroundTime /= jobs.size();
		avgWaitTime = avgTurnAroundTime - avgProcessTime;
	}
	
	public void printStats() {
		System.out.println("Average Process Time:\t" + avgProcessTime + "\n"
				+ "Average Wait Time:\t" + avgWaitTime + "\n"
				+ "Average Turnaround Time:" + avgTurnAroundTime + "\n");
	}
	public void addJob (Job job) {
		jobs.add(job);
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public double getAvgProcessTime() {
		return avgProcessTime;
	}
	public void setAvgProcessTime(int avgProcessTime) {
		this.avgProcessTime = avgProcessTime;
	}
	public double getAvgWaitTime() {
		return avgWaitTime;
	}
	public void setAvgWaitTime(int avgWaitTime) {
		this.avgWaitTime = avgWaitTime;
	}
	public double getAvgTurnAroundTime() {
		return avgTurnAroundTime;
	}
	public void setAvgTurnAroundTime(int avgTurnAroundTime) {
		this.avgTurnAroundTime = avgTurnAroundTime;
	}


}
