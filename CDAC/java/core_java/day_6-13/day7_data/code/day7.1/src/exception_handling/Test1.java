package exception_handling;

public class Test1 {

	public static void main(String[] args) {
		try {
			String[] names = { "aa", "bb", "cc" };
			System.out.println(names[30]);
			int a = 10;
			int b = 10;
			System.out.println("Result - " + (a / b));
			System.out.println("Parsed int value " + Integer.parseInt("-sfasdf234"));
			String s = null;
			System.out.println("char at 0th index " + s.charAt(0));
			System.out.println("end of try ....");
		}
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println(1);
//		}
		catch (NullPointerException e) {
			System.out.println(2);
		}
		catch (Exception e) {
			//get message
			System.out.println(e.getMessage());
			System.out.println("--------------------");
			//toString
			System.out.println(e);
			System.out.println("--------------------");
			e.printStackTrace();
			
		}
		System.out.println("main continues.....");
		/*
		 * no javac err ! Javac DOES NOT force handling of the un chked exceptions as
		 * well as Error
		 */
	}

}
