package club.banyuan.practice2;

public class StringBuffer{
	private String str = "";
	/**
    接收字符串
*/
	public void append(String str){
		this.str += str;
	}
	/**
    接收字符
*/
	public void append(char str){
		this.str += str;
	}
	/**
将之前接收到的字符拼接到一起返回
*/
	public String toString(){
		return this.str;
	}
/**
清除之前的而输入内容
*/
	public void clear(){
		this.str = "";
	}
	/**
将之前的输入内容反转
*/
	public String reverse(){
		return reverseString(str);

	}

	public String reverseString(String str){
		//toCharArray() 方法将字符串转换为字符数组
		char[] string = str.toCharArray();
		char[] reversedChars = new char[string.length];//创建一个新数组接收反转数组
		for(int i = 0;i < string.length;i++){
			reversedChars[string.length - i - 1] = string[i];
		}
		return new String(reversedChars);//String()方法把对象的值转换成字符串
	}
	/**
将指定位置的字符串反转
from 从0起始
to 不包含在内
即[from,to)
例如 abcdefg => reverse(1,3) => acbdefg
*/
	public String reverse(int from, int to){
		if(from > to || to >= str.length()){ //length() 方法用于返回字符串的长度
			System.out.println("输入不合法");
			return null;
		}
		String beforeFrom = str.substring(0, from);//substring()方法返回字符串的子字符串
    	String afterTo = str.substring(to);

    	return beforeFrom + reverseString(str.substring(from, to)) + afterTo;
  	}

  	public static void main(String[] args) {
    	StringBuffer stringBuffer = new StringBuffer();
    	stringBuffer.append("abc");
    	stringBuffer.append('1');
    	System.out.println(stringBuffer.toString());
    	System.out.println(stringBuffer.reverse());
    	System.out.println(stringBuffer.reverse(1, 3));
  }
}

	



