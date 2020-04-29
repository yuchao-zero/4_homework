## practice
1. 
```
class Clidder  
{ 
    private final void flipper()  
    { 
        System.out.println("Clidder"); 
    } 
} 
  
public class Clidlet extends Clidder  
{ 
    public final void flipper()  
    { 
        System.out.println("Clidlet"); 
    } 
    public static void main(String[] args)  
    { 
        new Clidlet().flipper(); 
    } 
}
//父类方法被pravite修饰，子类无法访问，没有继承
//父类方法被final修饰，子类无法继承
//子类中的flipper方法和父类不构成重写。只是自己的方法
//输出结果为Clidlet
```
2. 
```
class Alpha  //父类
{ 
    static String s = " "; //静态域最先执行
    protected Alpha()  //子类可以访问的构造方法
    { 
        s += "alpha "; //非静态可以引用静态
    } 
} 
class SubAlpha extends Alpha  //子类
{ 
    private SubAlpha()  //私有的构造方法
    { 
        s += "sub "; 
    } 
} 
  
public class SubSubAlpha extends Alpha  //子类
{ 
    private SubSubAlpha()    //私有的构造方法
    { 
        s += "subsub "; 
    } 
    public static void main(String[] args)  
    { 
        new SubSubAlpha(); 
        System.out.println(s); 
    } 
}
//输出： alpha subsub
```
3. 
```
class Grandparent  
{ 
    public void Print()  //方法只有引用才会打印
    { 
        System.out.println("Grandparent's Print()");  //方法被调用时执行
    }  
} 
  
class Parent extends Grandparent  
{ 
    public void Print()  //重写父类方法
    { 
        System.out.println("Parent's Print()");  
    }  
} 
  
class Child extends Parent  
{ 
    public void Print()    
    { 
        super.super.Print(); //编译报错
        System.out.println("Child's Print()");  
    }  
} 
  
public class Main  
{ 
    public static void main(String[] args)  
    { 
        Child c = new Child(); 
        c.Print();  
    } 
} 

```
4. 
```
final class Complex {
 
    private final double re;
    private final double im;
 
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }
 
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}
 
class Main {
  public static void main(String args[])
  {
       Complex c = new Complex(10, 15);
       System.out.println("Complex number is " + c);
  }         
}
//Complex number is (10.0 + 15.0i)
```
5. 
```
class A
{
    String s = "Class A";
}
 
class B extends A
{
    String s = "Class B";
 
    {
        System.out.println(super.s);
    }
}
 
class C extends B
{
    String s = "Class C";
 
    {
        System.out.println(super.s);
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        C c = new C();
 
        System.out.println(c.s);
    }
}
//先加载class文件，再初始化
//父类构造代码块优先于子类构造代码块初始化
//Class A
//Class B
//Class C
```
6. 
```
class A
{
    static
    {
        System.out.println("THIRD");
    }
}
 
class B extends A
{
    static
    {
        System.out.println("SECOND");
    }
}
 
class C extends B
{
    static
    {
        System.out.println("FIRST");
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        C c = new C();
    }
}
//父类静态代码块优先于子类静态代码块加载
//顺序输出
```
7. 
```
class X
{
    static void staticMethod()
    {
        System.out.println("Class X");
    }
}
 
class Y extends X
{
    static void staticMethod()
    {
        System.out.println("Class Y");
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        Y.staticMethod();
    }
}
//Class Y
```
8. 
```
class M
{
    static
    {
        System.out.println('A');
    }
 
    {
        System.out.println('B');
    }
 
    public M()
    {
        System.out.println('C');
    }
}
 
class N extends M
{
    static
    {
        System.out.println('D');
    }
 
    {
        System.out.println('E');
    }
 
    public N()
    {
        System.out.println('F');
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        N n = new N();
    }
}
// ADBCEF
```
9. 
```
class A
{
	static String s = "AAA";

	static
	{
		s = s + "BBB";
	}

	{
		s = "AAABBB";
	}
}

class B extends A
{
	static
	{
		s = s + "BBBAAA";
	}

	{
		System.out.println(s);
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		B b = new B();
	}
}
///AAABBB
```
10. 
```
class X
{
	int i = 101010;   //成员变量

	public X()     //构造方法
	{
		i = i++ + i-- - i;
	}

	static int staticMethod(int i)  //静态方法
	{
		return --i;
	}
}

class Y extends X
{
	public Y()
	{
		System.out.println(staticMethod(i));
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		Y y = new Y();
	}
}
//101010
```
11. 
```
class ClassOne
{
     static int i, j = 191919;
 
     {
         --i;
     }
 
     {
         j++;
     }
}
 
public class ClassTwo extends ClassOne
{
    static
    {
        i++;
    }
 
    static
    {
        --j;
    }
 
    public static void main(String[] args)
    {
        System.out.println(i);
 
        System.out.println(j);
    }
}
//1
//191918
```
12. 
```
class A
{
	int[] a = new int[5];

	{
		a[0] = 10;
	}
}

public class MainClass extends A
{
	{
		a = new int[5];
	}

	{   //调用自身的实例成员
		System.out.println(a[0]);
	}

	public static void main(String[] args)
	{
		MainClass main = new MainClass();
	}
}
//0
```
13. 
```
class A
{
	static int i;//1. i==0

	static
	{
		i++; //2. i==1
	}

	{
		++i; //4. i==1
	}
}

class B extends A
{
	static
	{
		--i; //3. i==0
	}

	{
		i--;  //5. i==0
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		System.out.println(new B().i);
	}
}
//0
```
14. 
```
public class MainClass
{
	public MainClass(int i, int j)
	{
		System.out.println(method(i, j));
	}
	
	int method(int i, int j)
	{
		return i++ + ++j;//注意i++表达式的值是i自增前的值
	}
	
	public static void main(String[] args) 
	{
		MainClass main = new MainClass(10, 20);
	}
}
//31
```
15. 
```
class X
{
	static
	{
		Y.methodOfY();
	}
}

class Y extends X
{
	static void methodOfY()
	{
		System.out.println("Hi....");
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		Y.methodOfY();
	}
}
//同包下default类可以相互访问
//输出两次
```
16. 
```
class ClassOne
{
	static int i = 111;
	
	int j = 222;
	
	{
		i = i++ - ++j;
	}
}

class ClassTwo extends ClassOne
{
	{
		j = i-- + --j;
	}
}
```


