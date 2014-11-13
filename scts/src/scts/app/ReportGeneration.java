package scts.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import scts.domain.Stats;

public class ReportGeneration {
	
	private String outputFile = "report.txt";
	
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
			
			writer.write("Operational Statistics\r\n");
			writer.write("Total Number of Ships Unloaded: " + stats.getTotalShips() + "\r\n");
			writer.write("Average Number of Ships Unloaded: " + stats.getAvgShips() + "\r\n");
			writer.write("Total Number of Containers Transferred: " + stats.getTotalContainers() + "\r\n");
			writer.write("Average Number of Containers Transferred: " + stats.getAvgContainers() + "\r\n");
			writer.write("Service Time from Arrival to Departure (Non-priority Ships)\r\n");
			writer.write("Maximum: " + stats.getNPMaxServiceTime() + "\r\n");
			writer.write("Minimum: " + stats.getNPMinServiceTime() + "\r\n");
			writer.write("Average: " + stats.getNPAvgServiceTime() + "\r\n");
			writer.write("Service Time from Arrival to Departure (Priority Ships)\r\n");
			writer.write("Maximum: " + stats.getPMaxServiceTime() + "\r\n");
			writer.write("Minimum: " + stats.getPMinServiceTime() + "\r\n");
			writer.write("Average: " + stats.getPAvgServiceTime() + "\r\n");
			writer.write("Longest Service Time Experienced by a Ship: " + stats.getLongestServiceTime() + "\r\n");
			writer.write("Largest Number of Ships Waiting for Unloading: " + stats.getLongestShipQueue() + "\r\n");
			writer.write("Maximum Length of Road Vehicle Queue: " + stats.getMaxRoadVehicleQueue() + "\r\n");
			writer.write("Stack Size\r\n");
			writer.write("Maximum: " + stats.getMaxStackSize() + "\r\n");
			writer.write("Minimum: " + stats.getMinStackSize() + "\r\n");
			writer.write("Average: " + stats.getAvgStackSize() + "\r\n");
			writer.write("Percentage of Time Spent by Yard Vehicles: " + stats.getYardVehiclePercentageTimeSpent() + "\r\n");

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
