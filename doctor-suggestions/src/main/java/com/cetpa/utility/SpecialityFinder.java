package com.cetpa.utility;

import java.util.HashMap;
import java.util.Map;

public class SpecialityFinder 
{
	public static Map<String,String> map=new HashMap<>();
	static {
		map.put("Arthritis","Orthopedic");
		map.put("Backpain","Orthopedic");
		map.put("Tissue injuries","Orthopedic");
		map.put("Dysmenorrhea","Gynecology");
		map.put("Skin Infection","Dermatology");
		map.put("Skin Burn","Dermatology");
		map.put("Ear Pain","ENT");
	}
}
