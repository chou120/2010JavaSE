## 看代码写输出结果

## 1

```
public class Test implements Runnable { 
    public void run() 
    { 
        System.out.printf("A "); 
        System.out.printf("B "); 
    } 
    public static void main(String[] args) 
    { 
        Test obj = new Test(); 
        Thread thread = new Thread(obj); 
          
        thread.start(); 
        System.out.printf("C "); 
        try 
        { 
            thread.join(); 
        }  
        catch (InterruptedException e)  
        { 
            e.printStackTrace(); 
        } 
        System.out.println("D"); 
    } 
} 
```

a) A B C D
b) C A B D
c)  a 或 b
d) a 和 b



## 2

```
public class Test implements Runnable 
{ 
    public void run() 
    { 
        System.out.printf("A "); 
    } 
    public static void main(String[] args) throws InterruptedException 
    { 
        Thread thread1 = new Thread(new Test()); 
        thread1.start(); 
        thread1.start(); 
        System.out.println(thread1.getState()); 
    } 
} 
```

a) A A TERMINATED
b) A TERMINATED
c) Compilation Error
d) Runtime Error



## 3

```
public class Test extends Thread implements Runnable 
{ 
    public void run() 
    { 
        System.out.printf("A "); 
    } 
    public static void main(String[] args) throws InterruptedException 
    { 
        Test obj = new Test(); 
        obj.run(); 
        obj.start(); 
    } 
} 
```

a) 运行错误
b) 编译错误
c) A  A
d) 以上都不是

## 4

```
class myThread implements Runnable { 
    public void run() { 
        Test.obj.notify(); 
    } 
} 
  
public class Test implements Runnable { 
    public static Test obj; 
    private int data; 
    public Test() { 
        data = 10; 
    } 
    public void run() { 
        obj = new Test(); 
        obj.wait(); 
        obj.data += 20; 
          
        System.out.println(obj.data); 
    } 
    public static void main(String[] args) throws InterruptedException { 
        Thread thread1 = new Thread(new Test()); 
        Thread thread2 = new Thread(new myThread()); 
          
        thread1.start(); 
        thread2.start(); 
      
        System.out.printf(" A - ");    
    } 
} 
```

a) 30 A –
b) A  – 30
c) A  –
d) 编译错误



## 5

```
class Test extends Thread { 
		public void run() { 
        System.out.println("Run"); 
    } 
} 
class Myclass { 
		public static void main(String[] args) { 
        Test t = new Test(); 
        t.start(); 
    } 
} 
```

1. 创建了1个线程
2. 创建了2个线程
3. 取决于操作系统
4. 没有创建线程
   

## 6

```
class Test extends Thread { 
		public void run() { 
        System.out.println("Run"); 
    } 
} 
class Myclass { 
		public static void main(String[] args) { 
        Test t = new Test(); 
        t.run(); 
    } 
} 
```

1. 创建了1个线程
2. 创建了2个线程
3. 取决于操作系统
4. 没有创建线程



## 7

```
class Test extends Thread { 
		public void run() { 
        System.out.println("Run"); 
    } 
} 
class Myclass { 
		public static void main(String[] args) { 
        Test t = new Test(); 
        t.start(); 
        System.out.println("Main"); 
    } 
} 
```

Options:

1. Main Run
2. Run Main
3. 1和2都有可能



## 8



```
class Test implements Runnable { 
		public void run() { 
        System.out.println("Run"); 
    } 
} 
class Myclass { 
		public static void main(String[] args) { 
        Test t = new Test(); 
        t.start(); 
        System.out.println("Main"); 
    } 
} 
```

1. Main Run
2. Run Main
3. 编译错误
4. 1和2都有可能

## 9

```
class Test implements Runnable { 
		public void run() { 
        System.out.println("Run"); 
    } 
} 
class Myclass { 
		public static void main(String[] args) { 
        Thread t1 = new Thread(); 
        t1.start(); 
        System.out.println("Main"); 
    } 
} 
```

1. Run
2. Main
3. 编译错误
4. Run Main