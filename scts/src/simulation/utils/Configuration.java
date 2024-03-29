package simulation.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import scts.simulations.ConfigValues;

/**
 * 
 * This class is responsible for the input and output of configuration values to and from text files.
 *
 */
public class Configuration {
	
	private String default_file_name = "\\default.txt";
	private String outputFile = "currentConfig.txt";
	private ConfigValues configValues;
	
	public Configuration() {
		configValues = new ConfigValues();
		//readValues(currentFileName);
	}
	
	//Read the configuration values from text file.
	public void readValues(String fileName) {
		try {
			String filePath = new File("").getAbsolutePath();
			filePath = filePath.concat(fileName);
			FileReader fr = new FileReader(filePath);
			BufferedReader textReader = new BufferedReader(fr);
			String line = textReader.readLine();
			while (line != null) {
				//System.out.println("Line ====================== " + line);
				int flag = line.indexOf("=");
				String tempVar = line.substring(0,flag);
				//System.out.println("tempVar ================== " + tempVar);
				String tempValue = line.substring(flag+1, line.length());
				//System.out.println("tempValue ========================== " + tempValue);
				configValues.setConfigValues(tempVar, Integer.parseInt(tempValue));
				line = textReader.readLine();
			}
			textReader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public ConfigValues getData() {
		return configValues;
		
	}

	//Write new configuration values to the text file.
	public void setData(ConfigValues data) {
		File file = new File(outputFile);
		try {
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			
			writer.write("simulationSpeed=" + data.getSimulationSpeed() + "\n");
			writer.write("dockMinTime=" + data.getDockMinTime() + "\n");
			writer.write("dockMaxTime=" + data.getDockMaxTime() + "\n");
			writer.write("undockMinTime=" + data.getUndockMinTime() + "\n");
			writer.write("undockMaxTime=" + data.getUndockMaxTime() + "\n");
			writer.write("qcRemoveMinTime=" + data.getqcRemoveMinTime() + "\n");
			writer.write("qcRemoveMaxTime=" + data.getqcRemoveMaxTime() + "\n");
			writer.write("qcPlaceMinTime=" + data.getqcPlaceMinTime() + "\n");
			writer.write("qcPlaceMaxTime=" + data.getqcPlaceMaxTime() + "\n");
			writer.write("yvPickMinTime=" + data.getyvPickMinTime() + "\n");
			writer.write("yvPickMaxTime=" + data.getyvPickMaxTime() + "\n");
			writer.write("yvDropMinTime=" + data.getyvDropMinTime() + "\n");
			writer.write("yvDropMaxTime=" + data.getyvDropMaxTime() + "\n");
			writer.write("yvTravelToSeaSideMinTime=" + data.getyvTravelToSeaSideMinTime() + "\n");
			writer.write("yvTravelToSeaSideMaxTime=" + data.getyvTravelToSeaSideMaxTime() + "\n");
			writer.write("yvTravelToQAMinTime=" + data.getyvTravelToQAMinTime() + "\n");
			writer.write("yvTravelToQAMaxTime=" + data.getyvTravelToQAMaxTime() + "\n");
			writer.write("minContainers=" + data.getMinContainers() + "\n");
			writer.write("maxContainers=" + data.getMaxContainers() + "\n");
			writer.write("maxStackSize=" + data.getMaxStackSize() + "\n");
			writer.write("initialStackSize=" + data.getInitialStackSize() + "\n");
			writer.write("numQC=" + data.getNumQC() + "\n");
			writer.write("numYV=" + data.getNumYV() + "\n");
			writer.write("timeLimit=" + data.getTimeLimit() + "\n");
			writer.write("numShipsWaiting=" + data.getNumShipsWaiting() + "\n");

			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void reset() {
		this.readValues(default_file_name);
		configValues = this.getData();
		this.setData(configValues);
		
	}
}
