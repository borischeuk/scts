package scts.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import scts.domain.ConfigValues;
import scts.ui.*;

public class Configuration {
	
	private String default_file_name = "default.txt";
	private ConfigValues configValues;
	private String[] data;
	
	public Configuration() {
		configValues = new ConfigValues();
		//readDefaultValues();
	}
	
	public Configuration(String[] data) {
		setConfigValues(data);
	}
	
	public void readDefaultValues() {
		try {
			FileReader fr = new FileReader(default_file_name);
			BufferedReader textReader = new BufferedReader(fr);
			int i = 0;
			while(textReader.readLine() != null) {
				data[i] = textReader.readLine();
				i++;
			}
			textReader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void setConfigValues(String[] data) {
		int dockMaxTime = 20;
		configValues.setDockMaxTime(dockMaxTime);
	}
}
