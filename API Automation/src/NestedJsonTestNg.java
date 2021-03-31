import org.testng.Assert;
import org.testng.annotations.Test;
import ApiPayload.ResponseBodyMock;
import io.restassured.path.json.JsonPath;
import resuableMethods.StringtoJason;

public class NestedJsonTestNg {

	@Test
			public static void NestedJsonTestNg()
		{
			
			
				
				String response1= ResponseBodyMock.responsebodymock1();
				
				System.out.println(response1);
				JsonPath Jse= StringtoJason.stringtoJason(response1);
				
				//Number of courses 
				int count = Jse.getInt("courses.size()");
				System.out.println(count);
				
				//purchase amount
				double amount = Jse.getDouble("dashboard.purchaseAmount");
				System.out.println(amount);
				
				//Title of first course
				String Titlefirstcourse = Jse.get("courses[0].title");
				System.out.println(Titlefirstcourse);
				
				
				//all course titles and respective prices.
				int Totalcount = Jse.getInt("courses.size()");
				System.out.println(Totalcount);
				
				int x;
				for( x = 0; x<Totalcount;x++)
				{
					
					String Titlefirstcourse1 = Jse.get("courses["+x+"].title");
					int price =Jse.getInt("courses["+x+"].price");
					System.out.println("Title of course  " + Titlefirstcourse1 );
					System.out.println("Price of course  " + price);
					
				}
				
				//number of copies sold by RPA
				
				
				int y;
				for( y = 0; y<Totalcount;y++)
				{
					
					String Titlefirstcourse1 = Jse.get("courses["+y+"].title");
					System.out.println("Title of course  " + Titlefirstcourse1 );
				    if (Titlefirstcourse1.equalsIgnoreCase("RPA"))
				    {
				    	int copies = Jse.get("courses["+y+"].copies");
				    	
					System.out.println("copies sold by RPA  " + copies);
					break;
					
				    }
				}
				
				   //Verify sum of all course prices matches purchase amout
				    
				    int z;
				    
				    double totaladdition = 0;
					for( z = 0; z<Totalcount;z++)
					{
						
						double price = Jse.getDouble("courses["+z+"].price");
						int copies = Jse.getInt("courses["+z+"].copies");
						totaladdition = totaladdition + (price*copies);
					
					}
						if(amount == totaladdition)
						{
					   System.out.println("AMount matches");
						}
						else
							System.out.println("AMount NOTTT matches");
					    }
				    
				}
		


				
		

		


			


		
			
		

	
