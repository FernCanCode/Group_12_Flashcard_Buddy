package application.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import application.Main;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

// Model.java is a Model Class for this javafx project handles the storage and manipulation of data inputed by the user
public class FBAppModel {
	public static File data = Main.data;
	public static LinkedHashMap <String, String> h = Main.h;
	
	public static void update(LinkedHashMap<String, String> h) throws IOException {
		BufferedWriter w = new BufferedWriter(new FileWriter(Main.data));
		for(Entry<String, String> entry : h.entrySet()) {
			w.write(entry.getKey() + ", " + entry.getValue());
			w.newLine();
		}
		
		w.flush();
		w.close();
	}
	
	public static LinkedHashMap<String, String> hash() throws IOException {
		File f = data;
		if (!f.isFile()) {
			f.createNewFile();
		}
		
		LinkedHashMap<String, String> h = new LinkedHashMap<String, String>();
		BufferedReader r = new BufferedReader(new FileReader(f));
		String line = null;
		
		while ((line = r.readLine()) != null) {
			String arr[] = line.split(", ");
			String key = arr[0].trim();
			String val = arr[1].trim();
			
			if (!key.equals("") && !val.equals("")) {
				h.put(key, val);
			}
		}
		r.close();
		
		update(h);
		return h;
	}
	
	public static Object[][] array(LinkedHashMap<String, String> h) throws IOException {
		Object arr[][] = new Object[h.size()][2];
		Object key[]   = h.keySet().toArray();
		Object val[]   = h.values().toArray();
		for(int i = 0; i < arr.length; i++) {
			arr[i][0] = key[i];
			arr[i][1] = val[i];
		}
		
		return arr;
	}
	
	public static void alert(String type, String text) {
		Alert a = new Alert(AlertType.NONE);
		switch (type) {
			case "CONFIRMATION":
				a.setAlertType(AlertType.CONFIRMATION);
				break;
			case "ERROR":
				a.setAlertType(AlertType.ERROR);
				break;
			case "INFORMATION":
				a.setAlertType(AlertType.INFORMATION);
				break;
			case "WARNING":
				a.setAlertType(AlertType.WARNING);
				break;
		}
		
		a.setContentText(text);
		a.show();
	}
}
