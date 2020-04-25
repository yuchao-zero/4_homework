package club.banyuan;

public class Person{
	private String name;
	private int age;

	public Person(String name, int age) {
    	this.name = name;
    	this.age = age;
    }

    public Person(){

    }

    public Person(String name){
    	this.name = name;
    }

    public void speak(){
    	System.out.println(name +age);
    }
}