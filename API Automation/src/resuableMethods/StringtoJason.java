package resuableMethods;

import io.restassured.path.json.JsonPath;

public class StringtoJason {

	public static JsonPath stringtoJason( String response)
	
	{
	JsonPath js1= new JsonPath(response);//pass response which is string
	System.out.println(response);
	return js1;
	
}
}