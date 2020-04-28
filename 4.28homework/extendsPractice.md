### jar practice
1. 
```
:practice edz$ java -cp dist/Dog.jar:dist/main.jar club.banyuan.Main
训练狗狗小强
小强: 汪汪
狗狗小强和猫咪汤姆一起玩
汤姆: 喵..
```
2. 
```
edzdeMacBook-Air:practice edz$ java -jar main.jar
训练狗狗小强
小强: 汪汪
狗狗小强和猫咪汤姆一起玩
汤姆: 喵..
```

### extends practice
3. 
```
class A
{
    {
        System.out.println(1);
    }
}
 
class B extends A
{
    {
        System.out.println(2);
    }
}
 
class C extends B
{
    {
        System.out.println(3);
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        C c = new C();
    }
}
//A是B的父类，B是C的父类。main方法中在调用C类的构造方法时优先调用B的构造方法
//B又优先调用A的构造方法，程序会按照顺序打印1 2 3
```
4. 
```
class A
{
    public A()
    {
        System.out.println("Class A Constructor");
    }
}
 
class B extends A
{
    public B()
    {
        System.out.println("Class B Constructor");
    }
}
 
class C extends B
{
    public C()
    {
        System.out.println("Class C Constructor");
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        C c = new C();
    }
}
//类A和类B都创建了无参构造方法
//子类构造方法中不需要显示调用父类构造方法
//子类创建对象时，优先创造父类对象
//顺序打印类ABC输出内容
```
5. 
```
class X
{
    public X(int i)
    {
        System.out.println(1);
    }
}
 
class Y extends X
{
    public Y()
    {
        System.out.println(2);
    }
}
//编译报错，因为父类X没有无参构造方法，子类Y没有显示调用父类Y的构造方法
```
6. 
```
public class A
{
    public A()
    {
        System.out.println(1);
 
        super();
 
        System.out.println(2);
    }
}
//super()必须是构造方法中的第一个语句，编译会报错
```
7. 
```
public class A
{
    public A(int i)
    {
 
    }
}
 
class B extends A
{
 
}
//编译报错，因为没有在子类中有效显示父类A的构造方法
```
8. 
```
public class A
{
    public A()
    {
        super();
 
        this(10);
    }
 
    public A(int i)
    {
        System.out.println(i);
    }
}
//super()和this()的调用都必须放在构造方法中的第一句,
//编译报错
```
9. 
```
class M
{
    int i;
 
    public M(int i)
    {
        this.i = i--;
    }
}
 
class N extends M
{
    public N(int i)
    {
        super(++i); //i自增了
 
        System.out.println(i);
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        N n = new N(26);
    }
}
//输出为27
```
10. 
```
class M
{
    int i = 51;
 
    public M(int j)
    {
        System.out.println(i); //输出51
 
        this.i = j * 10;
    }
}
 
class N extends M
{
    public N(int j)
    {
        super(j);
 
        System.out.println(i);//输出260 
 //子类可以引用父类的成员变量
        this.i = j * 20;
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        N n = new N(26);
 
        System.out.println(n.i); //输出520
    }
}
```
11. 
```
class X
{
    private int m = 48;
}
 
class Y extends X
{
    void methodOfY()
    {
        System.out.println(m);
    }
}
//父类成员m被private修饰，无法访问，编译报错
```
12. 
```
class X
{
    int m = 1111;
 
    {
        m = m++;//m先赋值，再自增 -> m = 1111
// 根据下一题 为什么这里能加载输出 13题不行？
        System.out.println(m); //1111
    }
}
 
class Y extends X
{
    {
        System.out.println(methodOfY());//2200
    }
 
    int methodOfY()
    {    //单目运算符优先级一样都是最高
        return m-- + --m;//m-- == 1110
                          //--m == 1110 
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        Y y = new Y();
    }
}
```
13. 
```
class A
{
	void A()
	{
		System.out.println(1);
	}
}

class B extends A
{
	void B()
	{
		A();
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		new B().B();
	}
}
//为什么只输出一次1？
```
14. 
```
class A
{
	int i = 1212;
}

class B extends A
{
	A a;

	public B(A a)
	{
		this.a = a;
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		A a = new A();

		B b = new B(a);

		System.out.println(a.i);//1212

		System.out.println(b.i);//1212

		System.out.println(b.a.i);//1212

		b.a.i = 2121;

		System.out.println("--------");

		System.out.println(a.i);//2121

		System.out.println(b.i);//1212其实还是原来的值
	}
}
```
15. 
```
class A
{
	int methodOfA(int i)
	{
		i /= 10;

		return i;
	}
}

class B extends A
{
	int methodOfB(int i)
	{
		i *= 20;

		return methodOfA(i);
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		B b = new B();

		System.out.println(b.methodOfB(100));//200
	}
}
```
16. 
```
class One
{
	int x = 2121;
}

class Two
{
	int x = 1212;
	
	{
		System.out.println(x); //1212
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		Two two = new Two();
	}
}
```
