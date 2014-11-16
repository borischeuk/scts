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
			writer.write("Total Number of Containers Transferred: " + stats.getTotalContainers() + "\r\n");
			writer.write("Service Time Experienced by the Ship: " + stats.getShipServiceTime() + "\r\n");
			writer.write("Service Time of Quay Crane: " + stats.getQuayCraneUnloadTime() + "\r\n");
			writer.write("Largest Number of Ships Waiting for Unloading: " + stats.getLongestShipQueue() + "\r\n");
			writer.write("Maximum Length of Road Vehicle Queue: " + stats.getMaxRoadVehicleQueue() + "\r\n");
			writer.write("Percentage of Time Spent by Yard Vehicles in Quay Area: " + stats.getYardVehiclePercentageTimeSpentInQA() + "%\r\n");
			writer.write("Percentage of Time Spent by Yard Vehicles in Seaside Transfer Point: " + stats.getYardVehiclePercentageTimeSpentInSeaside() + "%\r\n");

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
