package JDBC;

public class MarksheetTestModel {

	public static void main(String[] args) throws Exception {
		//testAdd();
		//testdelete(2);
		//testUpdate();
		//testMeritList();
		testget(1);
		

	}

	public static void testget(int i) throws Exception {
       MarksheetBean msb= new MarksheetBean();
       
       msb.setID(i);
		
		MarksheetModel md= new MarksheetModel();
		md.get(msb);
		
	}

	public static void testMeritList() throws Exception {
		MarksheetBean msb= new MarksheetBean();
		
		MarksheetModel md= new MarksheetModel();
		md.MeritList(msb);
		
		
	}

	public static void testUpdate() throws Exception {
MarksheetBean msb= new MarksheetBean();
		
		msb.setRollNo("C106");
		msb.setFname("NAMAN");
		msb.setLname("AHUJA");
		msb.setPhy(95);
		msb.setChem(50);
		msb.setMath(65);
		msb.setID(3);
	
		
		MarksheetModel md= new MarksheetModel();
		md.update(msb);
		
		
	}

	public static void testdelete(int a) throws Exception {
		MarksheetBean msb= new MarksheetBean ();
		
		msb.setID(a);
		
		MarksheetModel md1= new MarksheetModel();
		md1.delete(msb);
		
		
	}

	public static void testAdd() throws Exception {
		MarksheetBean msb= new MarksheetBean();
		
		//msb.setID(3);
		msb.setRollNo("C108");
		msb.setFname("HITESH");
		msb.setLname("KUMAR");
		msb.setPhy(65);
		msb.setChem(80);
		msb.setMath(95);
		
		MarksheetModel md= new MarksheetModel();
		md.add(msb);
		
		
	}
	

}
