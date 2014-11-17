package simulation.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import scts.simulations.Stats;

/**
 * 
 * This class is responsible for outputting the simulation data to a text file.
 *
 */
public class ReportGeneration {
	
	private String outputFile = "report.txt";
	
	//It outputs the data in stats to a text file.
	public void generateFile(Stats stats) {
		int i = 0;
		File file = new File(outputFile);
		while (file.exists()) {
			i++;
			outputFile = "report_" + i + ".txt";
			file = new File(outputFile);
		}
		try {
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			
			DecimalFormat df = new DecimalFormat("#.00");
			
			writer.write("Operational Statistics\r\n");
			writer.write("Total Number of Ships Unloaded: " + stats.getTotalShips() + "\r\n");
			writer.write("Total Number of Containers Transferred: " + stats.getTotalContainers() + "\r\n");
			writer.write("Service Time Experienced by the Ship: " + stats.getShipServiceTime() + "\r\n");
			writer.write("Service Time of Quay Crane: " + stats.getQuayCraneUnloadTime() + "\r\n");
			//writer.write("Largest Number of Ships Waiting for Unloading: " + stats.getLongestShipQueue() + "\r\n");
			//writer.write("Maximum Length of Road Vehicle Queue: " + stats.getMaxRoadVehicleQueue() + "\r\n");
			writer.write("Percentage of Time Spent by Yard Vehicles in Quay Area: " + df.format(stats.getYardVehiclePercentageTimeSpentInQA()) + "%\r\n");
			writer.write("Percentage of Time Spent by Yard Vehicles in Seaside Transfer Point: " + df.format(stats.getYardVehiclePercentageTimeSpentInSeaside()) + "%\r\n");

			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Runtime.getRuntime().exec("notepad.exe " + outputFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
