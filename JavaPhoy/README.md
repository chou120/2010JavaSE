面试题：
1:看程序写结果（先判断有没有问题，如果没有，写出结果）
class Fu
{
	public void show()
	{
		System.out.println("fu show");
	}
}

class Zi extends Fu
{
	public void show()
	{
		System.out.println("zi show");
	}

	public void method()
	{
		System.out.println("zi method");
	}
}
class Test
{
	public static void main(String[] args)
	{
		Fu f = new Zi();
		f.method();
	}
}

2:看程序写结果（先判断有没有问题，如果没有，写出结果）
class A
{
	public void show()
	{
		show2();
	}
	
	public void show2()
	{
		System.out.println("我");
	}
}
class B extends A 
{
	public void show2()
	{
		System.out.println("爱");
	}
}
class C extends B 
{
	public void show()
	{
		super.show();
	}
	
	public void show2()
	{
		System.out.println("你");
	}
}
 
public class Test 
{
	public static void main(String[] args) 
	{
		A a = new B();
		a.show();
 
		B b = new C();
		b.show();
	}
}

### 游戏:三英战吕布
有武器类 Weapon类
    属性:
        name
    行为:
    public void    attack(Figther  fighter1,Figther  fighter2)
       该方法里面执行的是 fighter1 对  fighter2进行攻击

有战斗人员 Fighter类
    属性如下:
        name
        武器(Weapon)
        生命值（hp）   
    行为如下:
            //攻击方法
           public void  attack(Figther  fighter){
                weapon.attack(this,fighter);
            }
            //自身攻击伤害(随机100到200之间的攻击力)
            public int attack(){
            }    
现有武器的子类

战八蛇矛  有属于自己的攻击力属性(自定义)
双股剑    同上(可以有暴击)
青龙偃月刀 同上(每次攻击是人物攻击的两倍)

方天画戟   同上(每次攻击是人物攻击的1.5倍,并且自带20%的武器伤害效果)    100 150   150*1.2

//在测试类得出
三英分别要多少回合才能战胜吕布
















     
        
