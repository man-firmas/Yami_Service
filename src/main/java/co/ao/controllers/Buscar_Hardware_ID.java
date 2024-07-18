package co.ao.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Buscar_Hardware_ID {
   
    private static String sn = null;

    @SuppressWarnings("empty-statement")
   public static final String getSerialNumber() {
		
		try {       
    String command = "wmic csproduct get UUID";
    StringBuilder output = new StringBuilder();

   Process SerNumProcess  = Runtime.getRuntime().exec(command);
    BufferedReader sNumReader = new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));

    @SuppressWarnings("UnusedAssignment")
    String line = "";
    while ((line = sNumReader.readLine()) != null) {
        output.append(line).append("\n");
    }
    String MachineID=output.toString().substring(output.indexOf("\n"), output.length()).trim();;
    System.out.println(MachineID);
    sn = MachineID;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}		

		return sn;
	}
}
