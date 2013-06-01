package de.tuxsim.controller;

import java.util.Enumeration;

import gnu.io.*;

public class COMPort {

	public COMPort() {
		CommPortIdentifier serialPortId;
	    CommPortIdentifier sSerialPortId;
	    Enumeration enumComm;
	    SerialPort serialPort;
	
	    
	    enumComm = CommPortIdentifier.getPortIdentifiers();
	    while (enumComm.hasMoreElements()) {
	     	serialPortId = (CommPortIdentifier) enumComm.nextElement();
	     	if(serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
	    		System.out.println(serialPortId.getName());
	    	}
	    }

		System.out.println("Finished successfully");
	}
	
}
