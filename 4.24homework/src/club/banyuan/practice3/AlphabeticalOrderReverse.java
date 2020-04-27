package club.banyuan.practice3;

import club.banyuan.practice2.StringBuffer;

public class AlphabeticalOrderReverse{
	//private String str;
	public static String reverseString(String str){
		char[] string = str.toCharArray();
		char[] reversedChars = new char[string.length];
		for(int i = 0;i < string.length;i++){
			reversedChars[string.length - i - 1] = string[i];
		}
		return new String(reversedChars);
	}
	public static void main(String[] args) {
		StringBuffer stringBuffer = new StringBuffer();
    	String target = "To be or not to be";
    	//split()方法根据匹配给定的正则表达式来拆分字符串。
    	String[] words = target.split(" ");
    	for (int i = 0; i < words.length; i++) {
      		stringBuffer.append(reverseString(words[i]));
      		stringBuffer.append(" ");
    	}
    	System.out.println(stringBuffer.toString());
  }

}
