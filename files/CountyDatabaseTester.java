import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CountyDatabaseTester {
	public static void main(String[] args) throws Exception{
		try {
			testEmpty();
			System.out.println("test empty finish");
			testSmallDatabase();
			System.out.println("test small finish");
			testLargerDatabase();
			System.out.println("test large finish");
			testExceptions();
			System.out.println("test exception finish");
			System.out.println("Testing CountyDatabase Completed Successfully\n\n");
		} catch (IOException e) {
			System.out.println("Was unable to create file");
		} catch (Exception e) {
			System.out.println("Student's code threw unexpected exception. Fix" +
					" if possible and re-run tests.");
			e.printStackTrace();
		}

		try {
			System.out.println("============= Running tests on CountyDBMain" +
					"=============\n\n");
			System.out.println("=============== First run tests on sample input file" +
					"===============\n\n");
			System.setIn(new FileInputStream("sampleMainInput.txt"));

			String[] sampleMainArgs = {"sampleInput.txt"};

			CountyDBMain.main(sampleMainArgs);
			
			System.out.println("=============== Then run tests on new input file" +
					"===============\n\n");
			System.setIn(new FileInputStream("MainInput.txt"));

			String[] mainArgs = {"testInput.txt"};

			CountyDBMain.main(mainArgs);
			
		} catch (FileNotFoundException e) {
			System.out.println("Could not write to file");
		} catch (Exception e) {
			System.out.println("Student's code threw unexpected exception. Fix" +
					" if possible and re-run tests.");
			e.printStackTrace();
		}
	}
	
	public static void testEmpty() throws Exception{
		CountyDatabase database = new CountyDatabase();
		
		try {
			if (database.containsCounty("test") == true) {
				System.out.println("containsCounty returns true for empty database");
			}
		} catch (Exception e) {
			System.out.println("containsCounty threw exception on empty database");
		}
		
		try {
			if (database.containsStorm("test") == true) {
				System.out.println("containsStorm returns true for empty database");
			}
		} catch (Exception e) {
			System.out.println("containsStorm threw exception on empty database");
		}
	
		try {
			if (database.hasStorm("test", "test") == true) 
				System.out.println("hasStorm returns true for empty database");
		} catch (Exception e) {
			System.out.println("hasStorm threw exception on empty database");
		}	

		try {
			if (database.getStormsWithDamageAmount(9) != null) 
				System.out.println("getStormsWithDamageAmount doesn't return null for empty database");
		} catch (Exception e) {
			System.out.println("getStormsWithDamageAmount threw exception on empty database");
		}	
		
		try {
			if (database.getStormsWithDate("test") != null)
				System.out.println("getStormsWithDate doesn't return null for empty database");
		} catch (Exception e) {
			System.out.println("getStormsWithDate threw exception for empty database");
		}
		
		try {
			if (database.getStormsWithName("test") != null)
				System.out.println("getStormsWithName doesn't return null for empty database");
		} catch (Exception e) {
			System.out.println("getStormsWithName threw exception for empty database");
		}
		
		try {
			if (database.getStormsFromCounty("test") != null)
				System.out.println("getStormsFromCounty doesn't return null for empty database");
		} catch (Exception e) {
			System.out.println("getStormsFromCounty threw exception for empty database");
		}
		
		try {
			database.printThreeMostExpensiveStorms();
		} catch (Exception e) {
			System.out.println("printThreeMostExpensiveStorms threw exception for empty database");
		}
		
		try {
			if (database.removeCounty("test") == true)
				System.out.println("removeCounty returns true for empty database");
		} catch (Exception e) {
			System.out.println("removeCounty threw exception for empty database");
		}
		
		try {
			if (database.removeStormsWithName("test") == true)
				System.out.println("removeStormsWithName returns true for empty database");
		} catch (Exception e) {
			System.out.println("removeStormsWithName threw exception for empty database");
		}
		
		try {
			if (database.removeStormsWithDamageAmount(10) == true)
				System.out.println("removeStormsWithDamageAmount returns true for empty database");
		} catch (Exception e) {
			System.out.println("removeStormsWithDamageAmount threw exception for empty database");
		}
		
		try {
			if (database.size() != 0)
				System.out.println("size() incorrect for empty database");
		} catch (Exception e) {
			System.out.println("size() threw exception for empty database");
		}
	}
	
	public static void testSmallDatabase() throws Exception{
		CountyDatabase database = new CountyDatabase();
		try {
			database.addCounty("testc");
		} catch (Exception e) {
			System.out.println("addCounty threw exception in small database test, check code to fix and re-run tester");
			return;
		}
		try {
			database.addStorm(new Storm("storm", "1/2/2014", 0), "testc");
		} catch (Exception e) {
			System.out.println("addStorm threw exception in small database test, check code to fix and re-run tester");
			return;
		}

		try {
			if (database.containsCounty("testc") == false) {
				System.out.println("containsCounty returns false when county in database in small database test");
			}
		} catch (Exception e) {
			System.out.println("containsCounty threw exception when county in database in small database test");
		}

		try {
			if (database.containsCounty("t") == true) {
				System.out.println("containsCounty returns true when county is NOT in database in small database test");
			}
		} catch (Exception e) {
			System.out.println("containsCounty threw exception when county is NOT in database in small database test");
		}

		try {
			if (database.containsStorm("storm") == false) {
				System.out.println("containsStorm returns false when storm is in database in small database test");
			}
		} catch (Exception e) {
			System.out.println("containsStorm threw exception when storm is in database in small database test");
		}

		try {
			if (database.containsStorm("s") == true) {
				System.out.println("containsStorm returns true when storm is NOT in database in small database test");
			}
		} catch (Exception e) {
			System.out.println("containsStorm threw exception when storm is NOT in database in small database test");
		}

		try {
			if (database.hasStorm("storm", "testc") == false) {
				System.out.println("hasStorm returns false when storm is in specified county in small database test");
			}
		} catch (Exception e) {
			System.out.println("hasStorm threw exception when storm is in specified county in small database test");
		}

		try {
			if (database.hasStorm("storm", "tes") == true) {
				System.out.println("hasStorm returns true when specified county is NOT in database in small database test");
			}
		} catch (Exception e) {
			System.out.println("hasStorm threw exception when specified county is NOT in database in small database test");
		}

		try {
			if (database.hasStorm("s", "testc") == true) {
				System.out.println("hasStorm returns true when storm is NOT in specified county in small database test");
			}
		} catch (Exception e) {
			System.out.println("hasStorm threw exception when storm is NOT in specified county in small database test");
		}

		try {
			if (database.getStormsWithDamageAmount(9) != null) 
				System.out.println("getStormsWithDamageAmount doesn't return null in small database test");
		} catch (Exception e) {
			System.out.println("getStormsWithDamageAmount threw exception instead of returning null in small database test");
		}
		
		try {
			if (database.getStormsWithDamageAmount(0).size() != 1) 
				System.out.println("getStormsWithDamageAmount incorrect in small database test");
		} catch (Exception e) {
			System.out.println("getStormsWithDamageAmount threw exception when there is a storm with damage amount in small database test");
		}
		
		try {
			if (database.getStormsWithDate("1") != null)
				System.out.println("getStormsWithDate doesn't return null in small database test");
		} catch (Exception e) {
			System.out.println("getStormsWithDate threw exception instead of returning null in small database test");
		}

		try {
			if (database.getStormsWithDate("1/2/2014").size() != 1)
				System.out.println("getStormsWithDate incorrect in small database test");
		} catch (Exception e) {
			System.out.println("getStormsWithDate threw exception when there is a storm with date in small database test");
		}
		
		try {
			if (database.getStormsWithName("t") != null)
				System.out.println("getStormsWithName doesn't return null in small database test");
		} catch (Exception e) {
			System.out.println("getStormsWithName threw exception instead of returning null in small database test");
		}

		try {
			if (database.getStormsWithName("storm").size() != 1)
				System.out.println("getStormsWithName incorrect in small database test");
		} catch (Exception e) {
			System.out.println("getStormsWithName threw exception when there is a storm with name in small database test");
		}
		
		try {
			if (database.getPercentageOfStormsNoDamage() != 100)
				System.out.println("getPercentageOfStormsNoDamage incorrect in small database test");
		} catch (Exception e) {
			System.out.println("getPercentageOfStormsNoDamage threw exception in small database test");
		}
		
		try {
			if (database.getStormsFromCounty("c") != null)
				System.out.println("getStormsFromCounty doesn't return null in small database test");
		} catch (Exception e) {
			System.out.println("getStormsFromCounty threw exception instead of returning null in small database test");
		}

		try {
			if (database.getStormsFromCounty("testc").size() != 1)
				System.out.println("getStormsFromCounty incorrect in small database test");
		} catch (Exception e) {
			System.out.println("getStormsFromCounty threw exception when there is a storm in county in small database test");
		}
		
		try {
			if (database.removeStormsWithName("s") == true)
				System.out.println("removeStormsWithName returns true when NO storm in small database test");
		} catch (Exception e) {
			System.out.println("removeStormsWithName threw exception when NO storm in small database test");
		}
		
		try {
			if (database.removeStormsWithName("storm") == false)
				System.out.println("removeStormsWithName returns false when there is storm in small database test");
		} catch (Exception e) {
			System.out.println("removeStormsWithName threw exception when there is storm in small database test");
		}
		
		try {
			database.addStorm(new Storm("storm", "1/2/2014", 0), "testc");
		} catch (Exception e) {
			System.out.println("addStorm threw exception after removal of storm in small database test");
		}
		
		try {
			if (database.removeStormsWithDamageAmount(10) == true)
				System.out.println("removeStormsWithDamageAmount returns true when NO storm in small database test");
		} catch (Exception e) {
			System.out.println("removeStormsWithDamageAmount threw exception when NO storm in small database test");
		}
		
		try {
			if (database.removeStormsWithDamageAmount(0) == false)
				System.out.println("removeStormsWithDamageAmount returns false when there is storm in small database test");
		} catch (Exception e) {
			System.out.println("removeStormsWithDamageAmount threw exception when there is storm in small database test");
		}
		
		try {
			database.addStorm(new Storm("storm", "1/2/2014", 0), "testc");
		} catch (Exception e) {
			System.out.println("addStorm threw exception after removal of storm in small database test");
		}
		
		try {
			if (database.removeCounty("t") == true)
				System.out.println("removeCounty returns true when county NOT in database in small database test");
		} catch (Exception e) {
			System.out.println("removeCounty threw exception in small database test");
		}
		
		try {
			if (database.removeCounty("testc") == false)
				System.out.println("removeCounty returns false when county is in database in small database test");
		} catch (Exception e) {
			System.out.println("removeCounty threw exception in small database test");
		}
		
		try {
			database.addCounty("county");
		} catch (Exception e) {
			System.out.println("addCounty threw exception after removal of county in small database test");
		}

		try {
			if (database.size() != 1)
				System.out.println("size() incorrect in small database test");
		} catch (Exception e) {
			System.out.println("size() threw exception in small database test");
		}
	}

	public static void testLargerDatabase() throws Exception{
		CountyDatabase database = new CountyDatabase();
		for (int i = 0; i < 800; i++) {
			String countyName = "county" + i/2;
			try {
				database.addCounty(countyName);
			} catch (Exception e) {
				System.out.println("addCounty threw exception in large database test, check code to fix and re-run tester");
				return;
			}
			try {
				database.addStorm(new Storm("storm" + i%2, "date" + i/2, 0), countyName);
			} catch (Exception e) {
				System.out.println("addStorm threw exception in large database test, check code to fix and re-run tester");
				return;
			}
		}
		
		for (int i = 800; i < 1000; i++) {
			String countyName = "county" + i/2;
			try {
				database.addCounty(countyName);
			} catch (Exception e) {
				System.out.println("addCounty threw exception in large database test, check code to fix and re-run tester");
				return;
			}
			try {
				database.addStorm(new Storm("storm" + i%2, "date" + i/2, 100), countyName);
			} catch (Exception e) {
				System.out.println("addStorm threw exception in large database test, check code to fix and re-run tester");
				return;
			}
		}
		
		try {
			database.addStorm(new Storm("stormtest", "date", 220), "a");
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("addStorm didn't throw IllegalArgumentException if county not in database large database test");
		}

		try {
			if (database.containsCounty("county1") == false) {
				System.out.println("containsCounty wrong when county in database in large database test");
			}
		} catch (Exception e) {
			System.out.println("containsCounty threw exception when county in database in large database test");
		}

		try {
			if (database.containsCounty("c") == true) {
				System.out.println("containsCounty returns true when county is NOT in database in large database test");
			}
		} catch (Exception e) {
			System.out.println("containsCounty threw exception when county is NOT in database in large database test");
		}

		try {
			if (database.containsStorm("storm0") == false) {
				System.out.println("containsStorm returns false when storm is in database in large database test");
			}
		} catch (Exception e) {
			System.out.println("containsStorm threw exception when storm is in database in large database test");
		}

		try {
			if (database.containsStorm("s") == true) {
				System.out.println("containsStorm returns true when storm is NOT in database in large database test");
			}
		} catch (Exception e) {
			System.out.println("containsStorm threw exception when storm is NOT in database in large database test");
		}

		try {
			if (database.hasStorm("storm0", "county1") == false) {
				System.out.println("hasStorm returns false when storm is in specified county in large database test");
			}
		} catch (Exception e) {
			System.out.println("hasStorm threw exception when storm is in specified county in large database test");
		}

		try {
			if (database.hasStorm("storm", "tes") == true) {
				System.out.println("hasStorm returns true when specified county is NOT in database in large database test");
			}
		} catch (Exception e) {
			System.out.println("hasStorm threw exception when specified county is NOT in database in large database test");
		}

		try {
			if (database.hasStorm("s", "county1") == true) {
				System.out.println("hasStorm returns true when storm is NOT in specified county in large database test");
			}
		} catch (Exception e) {
			System.out.println("hasStorm threw exception when storm is NOT in specified county in large database test");
		}

		try {
			if (database.getStormsWithDamageAmount(9) != null) 
				System.out.println("getStormsWithDamageAmount doesn't return null in large database test");
		} catch (Exception e) {
			System.out.println("getStormsWithDamageAmount threw exception instead of returning null in large database test");
		}
		
		try {
			if (database.getStormsWithDamageAmount(0).size() != 800) 
				System.out.println("getStormsWithDamageAmount incorrect in large database test");
		} catch (Exception e) {
			System.out.println("getStormsWithDamageAmount threw exception when there is a storm with damage amount in large database test");
		}
		
		try {
			if (database.getStormsWithDate("aaa") != null)
				System.out.println("getStormsWithDate doesn't return null in large database test");
		} catch (Exception e) {
			System.out.println("getStormsWithDate threw exception instead of returning null in large database test");
		}

		try {
			if (database.getStormsWithDate("date0").size() != 2)
				System.out.println("getStormsWithDate incorrect in large database test");
		} catch (Exception e) {
			System.out.println("getStormsWithDate threw exception when there is a storm with date in large database test");
		}
		
		try {
			if (database.getStormsWithName("aaa") != null)
				System.out.println("getStormsWithName doesn't return null in large database test");
		} catch (Exception e) {
			System.out.println("getStormsWithName threw exception instead of returning null in large database test");
		}

		try {
			if (database.getStormsWithName("storm0").size() != 500)
				System.out.println("getStormsWithName incorrect in large database test");
		} catch (Exception e) {
			System.out.println("getStormsWithName threw exception when there is a storm with name in large database test");
		}
		
		try {
			if (database.getPercentageOfStormsNoDamage() != 80)
				System.out.println("getPercentageOfStormsNoDamage incorrect in large database test");
		} catch (Exception e) {
			System.out.println("getPercentageOfStormsNoDamage threw exception in large database test");
		}
		
		try {
			if (database.getStormsFromCounty("c") != null)
				System.out.println("getStormsFromCounty doesn't return null in large database test");
		} catch (Exception e) {
			System.out.println("getStormsFromCounty threw exception instead of returning null in large database test");
		}

		try {
			if (database.getStormsFromCounty("county0").size() != 2)
				System.out.println("getStormsFromCounty incorrect in large database test");
		} catch (Exception e) {
			System.out.println("getStormsFromCounty threw exception when there is a storm in county in large database test");
		}
		
		try {
			if (database.removeStormsWithName("s") == true)
				System.out.println("removeStormsWithName returns true when NO storm in large database test");
		} catch (Exception e) {
			System.out.println("removeStormsWithName threw exception when NO storm in large database test");
		}
		
		try {
			if (database.removeStormsWithName("storm0") == false) {
				System.out.println("removeStormsWithName returns false when there are storms in large database test");
			}
			try {
				if (database.getStormsFromCounty("county100").size() != 1)
					System.out.println("removeStormsWithName did not remove storms in large database test");
			} catch (Exception e) {
				System.out.println("removeStormsWithName caused exception while fetching storms from county after removal in large database test");
			}
		} catch (Exception e) {
			System.out.println("removeStormsWithName threw exception when there is storm in large database test");
		}
		
		try {
			if (database.removeStormsWithDamageAmount(2222) == true)
				System.out.println("removeStormsWithDamageAmount returns true when NO storm in large database test");
		} catch (Exception e) {
			System.out.println("removeStormsWithDamageAmount threw exception when NO storm in large database test");
		}
		
		try {
			if (database.removeStormsWithDamageAmount(0) == false) {
				System.out.println("removeStormsWithDamageAmount returns false when there are storma in large database test");
			}
			try {
				if (database.getStormsFromCounty("county100").size() != 0)
					System.out.println("removeStormsWithDamageAmount did not remove storms in large database test");
			} catch (Exception e) {
				System.out.println("removeStormsWithDamageAmount caused exception while fetching storms from county after removal in large database test");
			}
		} catch (Exception e) {
			System.out.println("removeStormsWithDamageAmount threw exception when there are storms in large database test");
		}
		
		try {
			if (database.size() != 500)
				System.out.println("size() incorrect before removal of county of in large database test");
		} catch (Exception e) {
			System.out.println("size() threw exception before removal of county in large database test");
		}
		
		try {
			if (database.removeCounty("t") == true)
				System.out.println("removeCounty returns true when NO county in large database test");
		} catch (Exception e) {
			System.out.println("removeCounty threw exception when NO county in large database test");
		}
		
		try {
			if (database.removeCounty("county0") == false) {
				System.out.println("removeCounty returns false when there is county in large database test");
			}
			try {
				if (database.size() != 499)
					System.out.println("removeCounty didn't remove county in large database test");
			} catch (Exception e) {
				System.out.println("size() threw exception after removal of county in large database test");
			}
		} catch (Exception e) {
			System.out.println("removeCounty threw exception when there is county in large database test");
		}
	}
	
	public static void testExceptions() throws Exception{
		CountyDatabase database = new CountyDatabase();
		try {
			database.addCounty("testc");
		} catch (Exception e) {
		}
		
		try {
			database.addStorm(new Storm("storm", "1/2/2014", 0), "testc");
		} catch (Exception e) {
		}
		
		try {
			database.addCounty(null);
			System.out.println("addCounty(null) didn't throw exception");
		} catch(IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("addCounty(null) threw wrong exception type");
		}
		
		try {
			database.addStorm(null, null);
			System.out.println("addStorm(null, null) didn't throw exception");
		} catch(IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("addStorm(null, null) threw wrong exception type");
		}
		
		try {
			database.containsCounty(null);
			System.out.println("containsCounty(null) didn't throw exception");
		} catch(IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("containsCounty(null) threw wrong exception type");
		}
		
		try {
			database.containsStorm(null);
			System.out.println("containsStorm(null) didn't throw exception");
		} catch(IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("containsStorm(null) threw wrong exception type");
		}
	
		try {
			database.hasStorm(null, null);
			System.out.println("hasStorm(null,null) didn't throw exception");
		} catch(IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("hasStorm(null,null) threw wrong exception type");
		}	

		try {
			database.getStormsWithDamageAmount(null);
			System.out.println("getStormsWithDamageAmount(null) didn't throw exception");
		} catch(IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("getStormsWithDamageAmount(null) threw wrong exception type");
		}
		
		try {
			database.getStormsWithDate(null);
			System.out.println("getStormsWithDate(null) didn't throw exception");
		} catch(IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("getStormsWithDate(null) threw wrong exception type");
		}
		
		try {
			database.getStormsWithName(null);
			System.out.println("getStormsWithName(null) didn't throw exception");
		} catch(IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("getStormsWithName(null) threw wrong exception type");
		}
		
		try {
			database.getStormsFromCounty(null);
			System.out.println("getStormsFromCounty(null) didn't throw exception");
		} catch(IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("getStormsFromCounty(null) threw wrong exception type");
		}
		
		try {
			database.removeCounty(null);
			System.out.println("removeCounty(null) didn't throw exception");
		} catch(IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("removeCounty(null) threw wrong exception type");
		}
		
		try {
			database.removeStormsWithName(null);
			System.out.println("removeStormsWithName(null) didn't throw exception");
		} catch(IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("removeStormsWithName(null) threw wrong exception type");
		}
		
		try {
			database.removeStormsWithDamageAmount(null);
			System.out.println("removeStormsWithDamageAmount(null) didn't throw exception");
		} catch(IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("removeStormsWithDamageAmount(null) threw wrong exception type");
		}
	}
}
