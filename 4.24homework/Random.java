import java.util.Scanner;

public class Random {  
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);  //调用scanner
		System.out.println("from：");  
		int from = scan.nextInt();  
		System.out.println("to：");  
		int to = scan.nextInt();  

		//测试,生成10个随机数
		for (int x = 0; x < 10; x++) {    
			int num = randomInt(from, to);  
			 
			System.out.println(num);  
		}  
}  
  
public static int randomInt(int from, int to) { 

	int number = (int) (Math.random() * (to - from + 1)) + from;  

	return number;  
}  
}  