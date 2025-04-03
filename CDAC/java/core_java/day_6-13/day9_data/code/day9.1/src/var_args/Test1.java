package var_args;

public class Test1 {

	public static void main(String... args) {
		show();
		System.out.println("-----------------");
		int[] ints= {1,2,4,5,6,7};
		show(ints);
		System.out.println("-----------------");
		show(10,20,45,56,78,88);
		

	}
	//this method can accept any no of args (0 - n)
	static void show(int... data)
	{
		for(int i : data)
			System.out.print(i+" ");
		System.out.println();
	}

}
