package ApiPayload;

public class PayloadforPOJO {

	public static String AddPlace()
	{
		return "{\r\n"
				+ "	\"instructor\": \"rashmi bhandari\",\r\n"
				+ "	\"URL\": \"rashmibhandari.com\",\r\n"
				+ "	\r\n"
				+ "	\"courses\": {\r\n"
				+ "	  \"webautomation\":\r\n"
				+ "	  [\r\n"
				+ "	  {\r\n"
				+ "			\"title\": \"Selenium Python\",\r\n"
				+ "			\"price\": 10,\r\n"
				+ "			\"copies\": 6\r\n"
				+ "		},\r\n"
				+ "		{\r\n"
				+ "			\"title\": \"Selenium Python2\",\r\n"
				+ "			\"price\": 20,\r\n"
				+ "			\"copies\": 7\r\n"
				+ "		}],\r\n"
				+ "		\r\n"
				+ "		\"API\":\r\n"
				+ "		[\r\n"
				+ "		{\r\n"
				+ "			\"title\": \"Cypress\",\r\n"
				+ "			\"price\": 40,\r\n"
				+ "			\"copies\": 4\r\n"
				+ "		},\r\n"
				+ "		{\r\n"
				+ "			\"title\": \"Cypress2\",\r\n"
				+ "			\"price\": 42,\r\n"
				+ "			\"copies\": 5\r\n"
				+ "		}],\r\n"
				+ "		\r\n"
				+ "		\"UIautomation\":[\r\n"
				+ "		{\r\n"
				+ "			\"title\": \"RPA\",\r\n"
				+ "			\"price\": 45,\r\n"
				+ "			\"copies\": 10\r\n"
				+ "		},\r\n"
				+ "		{\r\n"
				+ "			\"title\": \"RPA\",\r\n"
				+ "			\"price\": 45,\r\n"
				+ "			\"copies\": 10\r\n"
				+ "		}\r\n"
				+ "	]\r\n"
				+ "}\r\n"
				+ "}";
	}
}
