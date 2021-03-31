package pojo2;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeSerialDeserial {
	
	@Test(priority = 1)
	public static void EmpSerialMethod() throws  JsonProcessingException 
	
	{
	
		//Creating Object on EmployeePOJO Class
		Employee emp= new Employee();
	    
		
		
		//Set values of Variables of emp object on Employee Pojo Class
		

emp.setFName("rashmi");
emp.setLname("bhandri");
emp.setAge(30);
		

		// Converting a Java class object to a JSON payload as string = Pass POJO Class object to the Object Mapper to get JSON Payload
		
		ObjectMapper x = new ObjectMapper();
		String JsonPayload = x.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		//with defaultpretty printer to print as Json
		System.out.println(JsonPayload);
	}
	
	//exception suggestion came by itself
	@Test(priority = 2)
	public static void EmpDeSerialMethod() throws  JsonProcessingException 
	
	{
	
		//Creating Object on EmployeePOJO Class
		Employee emp= new Employee();
		
		emp.setFName("Akhil");
		emp.setLname("bhandri");
		emp.setAge(40);
		
		// Converting a Java class object to a JSON payload as string = Pass POJO Class object to the Object Mapper to get JSON Payload
		
				ObjectMapper x = new ObjectMapper();
				String JsonPayload = x.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		// Read from the JasonObject to Java Object		
				Employee employee2 = x.readValue(JsonPayload, Employee.class);
			
				System.out.println("First Name of employee : "+employee2.getFName());
				System.out.println("Last Name of employee : "+employee2.getLname());
				System.out.println("Age of employee : "+employee2.getAge());
				
	}
		
}
