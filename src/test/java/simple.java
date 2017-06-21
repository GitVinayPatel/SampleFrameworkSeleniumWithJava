import factory.DataProviderFactory;

public class simple {
	//private static final String String = null;

	public static void main(String[] args) {
	
		String emptype = DataProviderFactory.getExcel().getdata("TestData",1,12);
		System.out.println(emptype);
		
		
		
		String strArray[] = emptype.split(" ");
		//System.out.println("String Array is : ");
		for(int i=0; i < strArray.length; i++){
	         if(strArray[i].equalsIgnoreCase("STU"))
	         {
	        	 System.out.println("STU");
	         }
	         else if(strArray[i].equalsIgnoreCase("FLX"))
	         {
	        	 System.out.println("FLX");
	         }
	         else if(strArray[i].equalsIgnoreCase("EXT"))
	         {
	        	 System.out.println("EXT");
	         }
	     }
		
		
	}

}
