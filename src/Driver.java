import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		String [] fileName = {"testdata1.txt", "testdata2.txt", "testdata3.txt"};
		String jobName, jobTime;
		int totalTime;
		for (int i = 0; i < fileName.length; i++) {
			List <Job> listJobs = new ArrayList <Job>();
			totalTime = 0;
			System.out.println("-------------------" + fileName[i] + "------------------");
			try {
				FileReader fileReader = new FileReader(fileName[i]);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
	
	            while((jobName = bufferedReader.readLine()) != null) {
	                jobTime = bufferedReader.readLine();
	                listJobs.add(new Job (jobName, Integer.parseInt(jobTime)));
	                totalTime += Integer.parseInt(jobTime);
	                
	            }   
	
	            // Always close files.
	            bufferedReader.close();  
			}
			catch (FileNotFoundException ex) {
				System.out.println("Unable to open " + fileName);
			}
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");                  
	        }
			System.out.println("First Come First Serve");
			SchedulingAlgorithm firstComeFirstServe = new FirstComeFirstServe (listJobs);
			firstComeFirstServe.runJobs();
			firstComeFirstServe.calculate();
			firstComeFirstServe.printChart();
			firstComeFirstServe.printStats();
			
			System.out.println("Shortest Job First");
			SchedulingAlgorithm shortestJobFirst = new ShortestJobFirst(listJobs);
			shortestJobFirst.runJobs();
			shortestJobFirst.calculate();
			shortestJobFirst.printChart();
			shortestJobFirst.printStats();
			
			System.out.println("Round Robin Slice of 2");
			SchedulingAlgorithm roundRobinTwo = new RoundRobinTwo(listJobs);
			roundRobinTwo.runJobs();
			roundRobinTwo.calculate();
			roundRobinTwo.printStats();
			
			System.out.println("Round Robin Slice of 5");
			SchedulingAlgorithm roundRobinFive = new RoundRobinFive(listJobs);
			roundRobinFive.runJobs();
			roundRobinFive.calculate();
			roundRobinFive.printStats();
		}
	}
}
