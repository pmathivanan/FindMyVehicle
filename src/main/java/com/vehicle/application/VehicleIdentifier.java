package com.vehicle.application;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.bean.Vehicle;
import com.vehicle.database.VehicleDatabase;

@RestController
public class VehicleIdentifier {	

	//private static VehicleDatabase vehicleDatabase = new VehicleDatabase();
	private static HashMap<String,Vehicle> vehicleDatabase = new HashMap<String,Vehicle>();
	static {
	vehicleDatabase.put("MABCDEFGHIJKLMN01", new Vehicle("MABCDEFGHIJKLMN01","FORD","FIGO",2019));
	vehicleDatabase.put("MABCDEFGHIJKLMN02", new Vehicle("MABCDEFGHIJKLMN02","FORD","ASPIRE",2019));
	vehicleDatabase.put("MABCDEFGHIJKLMN11", new Vehicle("MABCDEFGHIJKLMN11","FORD","ECOSPORT",2019));
	vehicleDatabase.put("MABCDEFGHIJKLMN12", new Vehicle("MABCDEFGHIJKLMN12","FORD","ENDEAVOR",2019));
	}

	@RequestMapping("/Vehicle")
	public Vehicle getVehicle(@RequestParam(value="vin") final String vin) throws Exception{
		
		Vehicle vehicle;
		
		try {
			if((vehicle=vehicleDatabase.get(vin)) != null)
			return vehicle;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		return vehicle;

	}
	
	

}
