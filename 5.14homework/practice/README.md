#### 1.
```
class Main {
   public static void main(String args[]) {
      try {
         throw 10; //语法错误，throw后面吗必须是throwable的对象或者其子类的对象
      }
      catch(int e) {////语法错误，throw后面吗必须是throwable的对象或者其子类的对象
         System.out.println("Got the  Exception " + e);
      }
  }
}
```

#### 2.
```
class Test extends Exception { }
  
class Main {
   public static void main(String args[]) { 
      try {
         throw new Test();//抛出异常
      }
      catch(Test t) {
         System.out.println("Got the Test Exception");
      }
      finally {
         System.out.println("Inside finally block ");
      }
  }
}
//输出：Got the Test Exception
//输出：Inside finally block 
```
#### 3.
```
class Main {
   public static void main(String args[]) {
      int x = 0;
      int y = 10;
      int z = y/x;
  }
}
//抛出异常：Exception in thread "main" java.lang.ArithmeticException: / by zero
//异常结束
```
#### 4.
```
class Base extends Exception {}
class Derived extends Base  {}
 
public class Main {
  public static void main(String args[]) {
   // some other stuff
   try {
       // Some monitored code
       throw new Derived();
    }
    catch(Base b)     { 
       System.out.println("Caught base class exception"); 
    }
    catch(Derived d)  { 
       System.out.println("Caught derived class exception"); 
    }
  }
} 
//异常错误
//catch按照顺序捕捉，如果父类在前，子类无法执行，应将子类放在父类前面（抛出子类异常会被父类异常的catch捕捉）
```
#### 5.
```
class Test
{
    public static void main (String[] args)
    {
        try
        {
            int a = 0;
            System.out.println ("a = " + a);
            int b = 20 / a;
            System.out.println ("b = " + b);
        }
 
        catch(ArithmeticException e)
        {
            System.out.println ("Divide by zero error");
        }
 
        finally
        {
            System.out.println ("inside the finally block");
        }
    }
}
//打印a = 0   
//打印Divide by zero error
//打印inside the finally block
```
#### 6.
```
class Test
{
    public static void main(String[] args)
    {
        try
        {
            int a[]= {1, 2, 3, 4};
            for (int i = 1; i <= 4; i++)
            {
                System.out.println ("a[" + i + "]=" + a[i] + "n");
            }
        }
         
        catch (Exception e)
        {
            System.out.println ("error = " + e);
        }
         
        catch (ArrayIndexOutOfBoundsException e)//编译报错
        {
            System.out.println ("ArrayIndexOutOfBoundsException");
        }
    }
}
//编译报错。catch按照顺序捕捉，如果父类在前，子类无法执行，应将子类放在父类前面（抛出子类异常会被父类异常的catch捕捉）
```
#### 7.
```
class Test
{
    String str = "a";
 
    void A()
    {
        try
        {
            str +="b"; //ab
            B();
        }
        catch (Exception e)
        {
            str += "c"; //abdec
        }
    }
 
    void B() throws Exception
    {
        try
        {
            str += "d"; //abd
            C();
        }
        catch(Exception e)
        {
            throw new Exception(); //方法体内的异常在finally执行之后抛出
            //catch里面抛了异常，但是没有被此方法处理，所以此方法中非finally代码块中的程序不会被执行
        }
        finally
        {
            str += "e"; //abde
        }
 
        str += "f"; //异常发生时，方法体内剩下的程序不会被执行(因为catch抛了异常，方法体内没有catch接住并处理）
 
    }
     
    void C() throws Exception
    {
        throw new Exception();
    }
 
    void display()
    {
        System.out.println(str);
    }
 
    public static void main(String[] args)
    {
        Test object = new Test();
        object.A();
        object.display();
    }
 
}
//输出abdec

```
#### 8.
```
class Test
{   int count = 0;
 
    void A() throws Exception { //因为方法中catch到异常后没有抛出，方法签名中的throws Exception声明可以取消
        try
        {
            count++;
             
            try
            {
                count++;
 
                try
                {
                    count++;
                    throw new Exception();
 
                }
                 
                catch(Exception ex)
                {
                    count++;
                    throw new Exception();
                }
            }
             
            catch(Exception ex)
            {
                count++;    //未抛出异常
            }
        }
         
        catch(Exception ex) //未被执行
        {
            count++;
        }
 
    }
 
    void display()
    {
        System.out.println(count);
    }
 
    public static void main(String[] args) throws Exception
    {
        Test obj = new Test();
        obj.A();
        obj.display();
    }
}
//输出5
```

#### 9.方法返回值是
```
public int myMethod(){

  try {

  return 1;

  }

  Catch (Exception e){ //catch  not Catch

  return 2;

  }

  finally{

  return 3;

 }

}
//返回3
//如果try中或catch中有return语句，那么在return语句执行之前，将执行finally中内容
```
#### 10.

```
 try {

      File file = new File("filename.txt");

      Scanner sc = new Scanner(file);

      throw new IOException();
    }

    catch (FileNotFoundException e) {

      System.out.println("FileNotFoundException called!!!");

    }

    catch (IOException e) {

      System.out.println("IOException called!!!");

    }
//打印 FileNotFoundException called!!!
//打印 IOException called!!!

```
#### 11.

```
public class Test {
 
    private static String result = "";
 
    public static void main(String[] args) {
        test(1);//返回值result值是"1245"
        result += "*";//"1245*"
        test(0);
        System.out.println(result);
    }
 
    public static void test(int i) {
 
        result += "1"; //1//1245*1
        try {
            if (i == 0) {  //false
                throw new RuntimeException("");
            }
            result += "2";
        } catch (Exception e) {
            result += "3"; //1245*13
            return; //
        } finally {
            result += "4";
        }
        result += "5";
    }
}
```

###
```
try {

      File file = new File("filename.txt");

      Scanner sc = new Scanner(file);

      throw new IOException();
    }

    catch (IOException e) {

      System.out.println("IOException called!!!");

    } 
//FileNotFoundException是IOException的子类
```
