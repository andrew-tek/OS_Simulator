
public class Job implements Comparable<Job> {
	String name;
	private boolean done;
	private int startTime;
	private int endTime;
	private int overallTimeNeeded;
	private int timeNeeded;
	
	public Job(String name, int time) {
		this.name = name;
		overallTimeNeeded = time;
		timeNeeded = time;
		done = false;
		startTime = 0;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getOverallTimeNeeded() {
		return overallTimeNeeded;
	}

	public void setOverallTimeNeeded(int completionTime) {
		this.overallTimeNeeded = completionTime;
	}

	public int getTimeNeeded() {
		return timeNeeded;
	}

	public void setTimeNeeded(int timeNeeded) {
		this.timeNeeded = timeNeeded;
	}

	@Override
	public int compareTo(Job arg0) {
		return overallTimeNeeded - arg0.getOverallTimeNeeded();
	}


}
