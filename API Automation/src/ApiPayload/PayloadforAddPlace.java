package ApiPayload;

public class PayloadforAddPlace {
	// method created as static so this method from the object PayloadforAddplace can be directly called without creating object
	public static String AddPlace()
	{
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"RashmiAkhil424 Academy\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layourrt, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://rahulshettyacademy.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}";
		
					
	}

	public static String addbook()
	{
		return "{\r\n"
				+ "	\"name\": \"rashnnnmi\",\r\n"
				+ "	\"isbn\": \"bcsd\",\r\n"
				+ "	\"aisle\": \"328\",\r\n"
				+ "	\"author\": \"Rashdemi B\"\r\n"
				+ "}";
		
	}
	
	
	public static String addbookparam(String isbn, int aisle) {
		// TODO Auto-generated method stub
		return "{\r\n"
		+ "	\"name\": \"dededed\",\r\n"
		+ "	\"isbn\": \""+isbn+"\",\r\n"
		+ "	\"aisle\": \""+aisle+"\"\",\r\n"
		+ "	\"author\": \"gygdyed B\"\r\n"
		+ "}";
	}
}
