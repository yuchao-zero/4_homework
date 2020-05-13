### 写出以下程序的输出结果

#### 1. 以下代码能否通过编译，为什么//
```
class Outer{
 public static void main(String[] args){
  new Inner(); //编译报错。静态方法不能调用非静态方法
 } 
 class Inner { 
  Inner() {} 
 }  
}
```
#### 2. 以下代码能否通过编译，为什么
```
static class Outer{//编译报错。外部类上一级程序单元是包，不能使用static修饰
 public static void main(String[] args){
 //
 }
 private class Inner{//内部类被private修饰，只能在外部类的内部访问
  Inner() {} 
 }
}
```

#### 3.
```
class Outer {//外部类
 String s1 = "Java";
 String s2 = "2";

 public static void main(String[] args) { //main方法
  Outer outer = new Outer();  
 }
 Outer() { //外部类构造器
  Inner inner = new Inner();  
 }
 class Inner {//内部类
  String s1 = "Certification";
  String s2 = "Exam";
        
  Inner() {//内部类构造器
   System.out.println(Outer.this.s1);//输出Java
   System.out.println(this.s1);//输出Certification
   System.out.println(s2);//输出Exam
  }
 }
}
```
#### 4. 以下代码能否通过编译，为什么
```
class A
{
    class B
    {
        static void methodB() //编译报错。内部类不能有静态方法
        {
            System.out.println("Method B");
        }
    }
}
//成员内部类看起来像是外部类的一个成员，所以可以像类的成员一样拥有多种权限修饰
//内部类方法不能被static修饰，因为内部类依赖外部类的对象，而静态方法又是脱离对象，声明为static会冲突
```
#### 5.//
```
class OuterInnerStatic {
 static String s1 = "Java"; 
 static String s2 = "2";
 public static void main(String[] args) { 
  Inner inner = new Inner();  
}

 static class Inner {//静态内部类可以有构造方法，静态是不需要实例化，不是不能
  String s1 = "Certification";
  String s2 = "Exam";
  Inner() {//构造方法
   System.out.println(OuterInnerStatic.s1); //Java
   System.out.println(this.s1);//Certification
   System.out.println(s2);//Exam
  }
 }
}

```
#### 6.
```
class X
{
    static int x = 3131;
     
    static class Y
    {
        static int y = x++;
         
        static class Z
        {
            static int z = y++;
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        System.out.println(X.x); //3131
         
        System.out.println(X.Y.y);//3131
         
        System.out.println(X.Y.Z.z);//3131
    }
}
```

#### 7. 在下面的示例中，如何访问"XYZ"类的"i"字段？
```
class ABC
{
    class XYZ
    {
        int i = 111;
    }
}
//需要创建一个内部类的对象来访问
```

#### 8. 运行以下程序时，它是否在控制台上打印“SUCCESS”？//
```
class A
{
    {
        new B();
    }
     
    static class B
    {
        {
            new A().new C();
        }
    }
     
    class C
    {
        {
            System.out.println("SUCCESS");
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        new A();
    }
}
//main方法里面创建了类A的一个对象，
//静态内部类只有在创建对象的时候才会被加载
//内部类不会在其外部类被加载的同时被加载
//递归死循环，new B的时候new了 A，new A的时候又去new B 循环调用
```

#### 9. 以下代码能否通过编译，为什么//
```
class A
{
    String s = "AAA";
     
    void methodA()
    {
        System.out.println(s);
    }
     
    static class B
    {
        void methodB()
        {
            methodA();//静态内部类不能调用外部类的非静态方法
        }
    }
}
//不能
```

#### 10.
```
abstract class A
{
    {
        System.out.println(1);
    }
     
    static
    {
        System.out.println(2);
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        A a = new A() { };//创建了一个A的子类，并且是一个局部内部类
    }
}
//顺序打印 2 1
```
#### 11.//
```
class A
{
    static String s = "AAA";
     
    class B
    {
        String s = "BBB";
         
        void methodB()
        {
            System.out.println(s);
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        A a = new A();
         
        System.out.println(a.s); //输出AAA
         
        A.B b = a.new B();
         
        System.out.println(b.s);//输出BBB
         
        b.methodB();//输出BBB
    }
}
```

#### 12. 以下代码能否通过编译，为什么
```
class A
{
    void methodOne()
    {
        class B
        {
            void methodTwo()
            {
                System.out.println("Method Two");
            }
        }
    }
     
    void methodThree()
    {
        new B().methodTwo();
    }
}
//不能通过编译。局部内部类依赖于外部类的实例创建对象
```

#### 13//
```
class X
{
    {
        System.out.println(1);
    }
     
    static
    {
        System.out.println(2);
    }
     
    public X()
    {
        new Y();
    }
     
    static class Y
    {
        {
            System.out.println(3);
        }
         
        static
        {
            System.out.println(4);
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        X x = new X();
         
        X.Y y = new X.Y(); //调用了构造代码块内容
    }
}
//内部类和静态内部类都是延时加载的，也就是说只有在明确用到内部类时才加载。只使用外部类时不加载。
//加载顺序：静态代码块 构造代码块 构造方法
//依次输出：2 1 4 3 3
```

#### 14. 以下代码能否通过编译，为什么//
```
class A
{
    class B
    {
        {
            System.out.println(1);
        }
         
        static
        {
            System.out.println(2);
        }
    }
}
//不能。因为成员内部类里不能有静态域
```

#### 15.
```
class ABC
{
    int i = 10101;
     
    {
        i--; 
    }
     
    public ABC()
    {
        --i;
    }
     
    class XYZ
    {
        int i = this.i;//i == 1;
         
        {
            i++;
        }
         
        public XYZ() 
        {
            ++i;
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        ABC abc = new ABC();
         
        System.out.println(abc.i); //输出10099
         
        ABC.XYZ xyz = abc.new XYZ();
         
        System.out.println(xyz.i);//输出2
         
        ABC.XYZ xyz1 = new ABC().new XYZ();
         
        System.out.println(xyz1.i);//输出2
    }
}
```
#### 16.
```
class P
{
    String s = "PPP";
     
    {
        System.out.println(s);
    }
     
    String methodP()
    {
        class Q
        {
            String s = P.this.s+"QQQ";
             
            {
                System.out.println(s);
            }
        }
         
        return new Q().s+s; //s是外部类方法的s。如果在外部类使用内部类成员变量，需要使用内部类对象引用
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        P p = new P();
         
        System.out.println(p.methodP());
    }
}
//输出PPP
//输出PPPQQQ
//输出PPPQQQPPP

```

#### 17. //

```
class A
{
    void methodA1(int i)
    {
        System.out.println(i+++i);
    }
     
    void methodA2(int i)
    {
        System.out.println(--i-i--);
    }
}
 
class B
{
    A a = new A()
    {
        void methodA1(int i)
        {
            System.out.println(++i+i++);
        }
         
        void methodA2(int i)
        {
            System.out.println(i---i);
        }
    };
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        A a = new A();
         
        a.methodA1(10);//输出：21
         
        a.methodA2(10);//输出：0
         
        B b = new B();
         
        b.a.methodA1(10);//输出22
         
        b.a.methodA2(10);//输出1
    }
}

```

#### 18. 以下代码能否通过编译，为什么//
```
class One
{
    void methodOne()
    {
        public class Two //编译报错。局部内部类（和局部变量一样）不能被访问修饰符修饰
        {
             
        }
    }
}
```


#### 19.//

```
class One
{
    {
        System.out.println("ONE");
    }
     
    class Two
    {
        {
            System.out.println("TWO");
        }
    }
     
    static
    {
        System.out.println("THREE");
    }
     
    static class Three
    {
        {
            System.out.println("FOUR");
        }
         
        static
        {
            System.out.println("FIVE");
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        One one = new One(); //打印THREE ONE
         
        One.Two two = one.new Two();//打印TWO
         
        One.Three three = new One.Three();//打印FIVE FOUR
    }
}
```

#### 20. 以下代码能否通过编译，为什么
```
class A
{
    class B extends A
    {
        class C extends B
        {
            class D extends C
            {
                 
            }
        }
    }
}
//???
```

#### 21.//
```
abstract class X
{
    static String s1 = "STATIC";
     
    String s2 = "NON-STATIC";
     
    abstract void methodX(); 
     
    static abstract class Y
    {
        String s1 = "NON-STATIC";
         
        static String s2 = "STATIC";
         
        abstract void methodY();
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        //抽象类X的子类
        new X() 
        {   
            void methodX() //重写父类X的方法
            {
                System.out.println(s1+" "+s2);
            }
        }.methodX();//匿名内部类的写法，构成多态，调用的是子类（匿名内部类）的方法
         //打印STATIC NON-STATIC
        
        //抽象静态内部类的子类
        new X.Y() 
        {   
            void methodY() //重写内部类Y的方法
            {
                System.out.println(s1+" "+s2);
            }
        }.methodY();//打印NON-STATIC STATIC
    }
}
```

#### 22. 在下面的示例中，如何访问“内部类”的“i”字段？//
```
class OuterClass
{
    static class InnerClass
    {
        int i;
    }
}
//实例化内部类，通过内部类的对象调用：new OuterClass.InnerClass().i
```

#### 23.//
```
class X
{   
    static
    {
        class Y
        {   
            {
                System.out.println(1);
            }
        }
    }
     
    {
        class Y
        {
            {
                System.out.println(2);
            }
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        new X();
    }
}
//程序正常结束，不输出内容。因为成员内部类的构造代码块只有在加载内部类的时候才被加载，无论成员内部类是不是在外部类的静态代码块还是构造代码块
//而内部类的加载需要new内部类的对象来触发
```

#### 24.//
```
class A
{   
    abstract class B
    {
        abstract void method();
    }
     
    {
        //抽象内部类的子类对象
        new B()
        {
             
            @Override
            void method()
            {
                System.out.println("BBB");
            }
        }.method();
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        new A();
    }
}
//打印BBB
```

#### 25.//
```
class X
{   
    void methodX()
    {
        class Y
        {
            static void methodY()//编译报错。非静态局部内部类不能有静态方法
            {
                 
            }
        }
    }
}
```

#### 26. 如何在class A以外的其他类中实例化 class B
```
class A
{
    void methodA()
    {
        class B
        {
             
        }
    }
}
//???
```

#### 27.//
```
public class Outer 
{ 
	public static int temp1 = 1; 
	private static int temp2 = 2; 
	public int temp3 = 3; 
	private int temp4 = 4; 
	
	public static class Inner 
	{ 
		private static int temp5 = 5; 
		
		private static int getSum() //静态方法不能调用非静态成员
		{ 
			return (temp1 + temp2 + temp3 + temp4 + temp5); 
		} 
	} 
	
	public static void main(String[] args) 
	{ 
		Outer.Inner obj = new Outer.Inner(); 
		System.out.println(obj.getSum()); 
	} 
	
} 

```

#### 28.//
```
public class Outer  
{ 
    private static int data = 10; 
    private static int LocalClass() 
    { 
        class Inner 
        { 
            public int data = 20; 
            private int getData() 
            { 
                return data; 
            } 
        }; 
        Inner inner = new Inner(); 
        return inner.getData(); 
    } 
      
    public static void main(String[] args) 
    { 
        System.out.println(data * LocalClass()); //输出200
    } 
} 

```

#### 29.//
```
interface Anonymous 
{ 
	public int getValue(); 
} 
public class Outer 
{ 
	private int data = 15; 
	public static void main(String[] args) 
	{ 
		Anonymous inner = new Anonymous()//匿名内部类 
				{ 
					int data = 5; 
					public int getValue() 
					{ 
						return data; 
					} 
					public int getData() 
					{ 
						return data; 
					} 
				}; 
		Outer outer = new Outer(); 
		System.out.println(inner.getValue() + inner.getData() + outer.data); 
	} 
} 
//匿名内部类中存在独有方法，无法调用

```

#### 30.//
```
public class Outer 
{ 
    private int data = 10; 
      
    class Inner 
    { 
        private int data = 20; 
        private int getData() 
        { 
            return data; 
        } 
        public void main(String[] args) 
        { 
            Inner inner = new Inner(); 
            System.out.println(inner.getData()); 
              
        } 
    } 
    private int getData() 
    { 
        return data; 
    } 
    public static void main(String[] args) 
    { 
        Outer outer = new Outer(); 
        Outer.Inner inner = outer.new Inner(); 
        System.out.printf("%d", outer.getData()); //没有换行符
        inner.main(args); 
    } 
} 
//打印1020
```

#### 31.//
```
interface OuterInterface //外部接口
{ 
    public void InnerMethod(); 
    public interface InnerInterface //内部接口，默认static
    { 
        public void InnerMethod(); 
    } 
} 
public class Outer implements OuterInterface.InnerInterface, OuterInterface 
{ 
    public void InnerMethod() 
    { 
        System.out.println(100); 
    } 
      
      
    public static void main(String[] args) 
    { 
        Outer obj = new Outer(); 
        obj.InnerMethod(); //输出100
    } 
} 
```
