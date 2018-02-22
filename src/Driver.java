import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		String fileName = "testdata1.txt";
		String jobName, jobTime;
		List <Job> listJobs = new ArrayList <Job>();
		
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((jobName = bufferedReader.readLine()) != null) {
                jobTime = bufferedReader.readLine();
                listJobs.add(new Job (jobName, Integer.parseInt(jobTime)));
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
		SchedulingAlgorithm firstComeFirstServe = new FirstComeFirstServe (listJobs);
		firstComeFirstServe.runJobs();
		firstComeFirstServe.calculate();
		firstComeFirstServe.printChart();
		firstComeFirstServe.printStats();
		
		
		SchedulingAlgorithm shortestJobFirst = new ShortestJobFirst(listJobs);
		shortestJobFirst.runJobs();
		shortestJobFirst.calculate();
		shortestJobFirst.printChart();
		shortestJobFirst.printStats();
	}
}
