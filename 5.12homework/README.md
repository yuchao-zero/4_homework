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
//加载类A的时候首先加载了A的静态部分，
//类C是类A的成员内部类，类A已创建对象
//递归？
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
        A a = new A() { };//抽象类不能实例化
    }
}
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
//不能通过编译。内部类依赖于外部类的实例创建对象
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
         
        return new Q().s+s;
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
//输出PPPQQQPPPQQQ？

```

#### 17. 

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
         
        a.methodA1(10);
         
        a.methodA2(10);
         
        B b = new B();
         
        b.a.methodA1(10);
         
        b.a.methodA2(10);
    }
}

```

#### 18. 以下代码能否通过编译，为什么
```
class One
{
    void methodOne()
    {
        public class Two
        {
             
        }
    }
}
```


#### 19.

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
        One one = new One();
         
        One.Two two = one.new Two();
         
        One.Three three = new One.Three();
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
```

#### 21.
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
        new X() 
        {   
            void methodX()
            {
                System.out.println(s1+" "+s2);
            }
        }.methodX();
         
        new X.Y() 
        {   
            void methodY() 
            {
                System.out.println(s1+" "+s2);
            }
        }.methodY();
    }
}
```

#### 22. 在下面的示例中，如何访问“内部类”的“i”字段？
```
class OuterClass
{
    static class InnerClass
    {
        int i;
    }
}
```

#### 23.
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
```

#### 24.
```
class A
{   
    abstract class B
    {
        abstract void method();
    }
     
    {
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
```

#### 25.
```
class X
{   
    void methodX()
    {
        class Y
        {
            static void methodY()
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
```

#### 27.
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
		
		private static int getSum() 
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

#### 28.
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
        System.out.println(data * LocalClass()); 
    } 
} 

```

#### 29.
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
		Anonymous inner = new Anonymous() 
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

```

#### 30.
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
        System.out.printf("%d", outer.getData()); 
        inner.main(args); 
    } 
} 
```

#### 31.
```
interface OuterInterface 
{ 
    public void InnerMethod(); 
    public interface InnerInterface 
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
        obj.InnerMethod(); 
    } 
} 
```
