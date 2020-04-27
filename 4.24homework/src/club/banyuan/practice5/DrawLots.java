import java.util.Scanner;

public class DrawLots{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);  //调用scanner
		System.out.println("请输入任意数字开始抽签：");  
		scan.nextInt();  
		int num = randomInt(1,100);

		if(1 <= num && num <=5){
			System.out.println("大吉");
		}
		if(6 <= num && num <=15){
			System.out.println("中吉");
		}
		if(16 <= num && num <=30){
			System.out.println("小吉");
		}
		if(31 <= num && num <=60){
			System.out.println("吉");
		}
		if(61 <= num && num <=80){
			System.out.println("末吉");
		}
		if(81 <= num && num <=95){
			System.out.println("凶");
		}
		if(96 <= num && num <=100){
			System.out.println("大凶");
		}
		
		System.out.println("输入0退出抽签：");  
		int end = scan.nextInt(); 
		if(end == 0){
			return;
		} 

}  
  
	public static int randomInt(int from, int to) { 

		int number = (int) (Math.random() * (to - from + 1)) + from;  

		return number;  
	}  
}
