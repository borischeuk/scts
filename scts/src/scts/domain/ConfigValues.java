package scts.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import scts.app.Configuration;

public class ConfigValues {

	private int simulationSpeed;
	private int dockMinTime;
	private int dockMaxTime;
	private int undockMinTime;
	private int undockMaxTime;
	private int qcRemoveMinTime;
	private int qcRemoveMaxTime;
	private int qcPlaceMinTime;
	private int qcPlaceMaxTime;
	private int yvPickMinTime;
	private int yvPickMaxTime;
	private int yvDropMinTime;
	private int yvDropMaxTime;
	private int yvTravelToSeaSideMinTime;
	private int yvTravelToSeaSideMaxTime;
	private int yvTravelToQAMinTime;
	private int yvTravelToQAMaxTime;
	private int minContainers;
	private int maxContainers;
	private int maxStackSize;
	private int initialStackSize;
	private int numQC;
	private int numYV;
	private int timeLimit;
	private int numShipsWaiting;
	private String inputFileName = "\\currentConfig.txt";
	
	public enum Var {
		simulationSpeed,
		dockMinTime,
		dockMaxTime,
		undockMinTime,
		undockMaxTime,
		qcRemoveMinTime,
		qcRemoveMaxTime,
		qcPlaceMinTime,
		qcPlaceMaxTime,
		yvPickMinTime,
		yvPickMaxTime,
		yvDropMinTime,
		yvDropMaxTime,
		yvTravelToSeaSideMinTime,
		yvTravelToSeaSideMaxTime,
		yvTravelToQAMinTime,
		yvTravelToQAMaxTime,
		minContainers,
		maxContainers,
		maxStackSize,
		initialStackSize,
		numQC,
		numYV,
		timeLimit,
		numShipsWaiting
	}
	
	public ConfigValues() {
		try {
			String filePath = new File("").getAbsolutePath();
			filePath = filePath.concat(inputFileName);
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
				this.setConfigValues(tempVar, Integer.parseInt(tempValue));
				line = textReader.readLine();
			}
			textReader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void setConfigValues(String name, int value) {
		switch (Var.valueOf(name)) {
		case simulationSpeed:
			this.simulationSpeed = value;
			break;
		case dockMinTime:
			this.dockMinTime = value;
			break;
		case dockMaxTime:
			this.dockMaxTime = value;
			break;
		case undockMinTime:
			this.undockMinTime = value;
			break;
		case undockMaxTime:
			this.undockMaxTime = value;
			break;
		case qcRemoveMinTime:
			this.qcRemoveMinTime = value;
			break;
		case qcRemoveMaxTime:
			this.qcRemoveMaxTime = value;
			break;
		case qcPlaceMinTime:
			this.qcPlaceMinTime = value;
			break;
		case qcPlaceMaxTime:
			this.qcPlaceMaxTime = value;
			break;
		case yvPickMinTime:
			this.yvPickMinTime = value;
			break;
		case yvPickMaxTime:
			this.yvPickMaxTime = value;
			break;
		case yvDropMinTime:
			this.yvDropMinTime = value;
			break;
		case yvDropMaxTime:
			this.yvDropMaxTime = value;
			break;
		case yvTravelToSeaSideMinTime:
			this.yvTravelToSeaSideMinTime = value;
			break;
		case yvTravelToSeaSideMaxTime:
			this.yvTravelToSeaSideMaxTime = value;
			break;
		case yvTravelToQAMinTime:
			this.yvTravelToQAMinTime = value;
			break;
		case yvTravelToQAMaxTime:
			this.yvTravelToQAMaxTime = value;
			break;
		case minContainers:
			this.minContainers = value;
			break;
		case maxContainers:
			this.maxContainers = value;
			break;
		case maxStackSize:
			this.maxStackSize = value;
			break;
		case initialStackSize:
			this.initialStackSize = value;
			break;
		case numQC:
			this.numQC = value;
			break;
		case numYV:
			this.numYV = value;
			break;
		case timeLimit:
			this.timeLimit = value;
			break;
		case numShipsWaiting:
			this.numShipsWaiting = value;
			break;
		default:
			break;
		}
	}

	
	// get values
	public int getSimulationSpeed() {
		return simulationSpeed;
	}
	
	public int getDockMinTime() {
		return dockMinTime;
	}
	
	public int getDockMaxTime() {
		return dockMaxTime;
	}
	
	public int getUndockMinTime() {
		return undockMinTime;
	}
	
	public int getUndockMaxTime() {
		return undockMaxTime;
	}
	
	public int getqcRemoveMinTime() {
		return qcRemoveMinTime;
	}
	
	public int getqcRemoveMaxTime() {
		return qcRemoveMaxTime;
	}
	
	public int getqcPlaceMinTime() {
		return qcPlaceMinTime;
	}
	
	public int getqcPlaceMaxTime() {
		return qcPlaceMaxTime;
	}
	
	public int getyvPickMinTime() {
		return yvPickMinTime;
	}
	
	public int getyvPickMaxTime() {
		return yvPickMaxTime;
	}
	
	public int getyvDropMinTime() {
		return yvDropMinTime;
	}
	
	public int getyvDropMaxTime() {
		return yvDropMaxTime;
	}
	
	public int getyvTravelToSeaSideMinTime() {
		return yvTravelToSeaSideMinTime;
	}
	
	public int getyvTravelToSeaSideMaxTime() {
		return yvTravelToSeaSideMaxTime;
	}
	
	public int getyvTravelToQAMinTime() {
		return yvTravelToQAMinTime;
	}
	
	public int getyvTravelToQAMaxTime() {
		return yvTravelToQAMaxTime;
	}
	
	public int getMinContainers() {
		return minContainers;
	}
	
	public int getMaxContainers() {
		return maxContainers;
	}
	
	public int getMaxStackSize() {
		return maxStackSize;
	}
	
	public int getInitialStackSize() {
		return initialStackSize;
	}
	
	public int getNumQC() {
		return numQC;
	}
	
	public int getNumYV() {
		return numYV;
	}

	public int getTimeLimit() {
		return timeLimit;
	}
	
	public int getNumShipsWaiting() {
		return numShipsWaiting;
	}
	
}
