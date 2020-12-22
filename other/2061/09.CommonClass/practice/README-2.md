#### 1.设计一个方法，可以实现获取任意范围内的随机数。包括负数，例如输入randomInt(-10,5)

```
tips:  

double Math.random()
将返回一个 double类型的数字，数字的范围在[0,1)之间
Math类位于java.lang 包下，可以不需要import就可以使用

或者使用

Random类，该类位于java.util 包下，需要使用import导入, 即 import java.util.Random;
int nextInt(int n)
该方法接收一个int类型的数值（必须大于0），返回一个int数值，范围在[0,n) 之间，n为传入的数值

Random random = new Random();
random.nextInt(12); // 将随机生成 [0,12) 之间的数字
```
```
int randomInt(int from, int to){
}
```
#### 2.定义一个StringBuffer类对象, 对外提供方法接收字符串或字符，通过一个方法将之前接收到的字符拼接到一起返回

```
tips:  

可以使用但不限于以下API

char charAt(int)
通过String对象调用，获取当前String对象指定位置上的字符。可参考example下的StringDemo

char[] toCharArray()
将String对象转换成对应的char数组对象，例如
"abcdef".toCharArray() 将返回一个char数组，内容为{'a','b','c','d','e','f'}

new String(char[])
可以使用该构造方法将一个char数组转成与之对应的String对象。例如
String str = "1234";
char[] chars = str.toCharArray(); // 返回 {'1','2','3','4'} 这样的字符数组
String newStr = new String(chars); // 返回 1234 的String对象

String substring(int)
通过String对象调用，传入一个int数值，返回一个新的String对象，将调用方法的String对象的部分字符串提取作为新的字符串的内容

String substring(int,int)
可以接收两个数值参数，指定提取字符串的起始和结束位置

substring  API可以参考 example/StringDemo 的演示内容

```
```java
/**
    接收字符串
*/
void append(String str)
```

```
/**
    接收字符
*/
void append(Char str)
```

```
/**
将之前接收到的字符拼接到一起返回
*/
String toString()
```

```
/**
清除之前的而输入内容
*/
void clear()
```

```
/**
将之前的输入内容反转
*/
String reverse()
```

```
/**
将指定位置的字符串反转
from 从0起始
to 不包含在内
即[from,to)
例如 abcdefg => reverse(1,3) => acbdefg
*/
String reverse(int from, int to)
```

#### 3. 编写一个程序，将下面的一段文本中的各个单词的字母顺序翻转，
"To be or not to be"，将变成"oT eb ro ton ot eb."。

```
tips:
split(String)
将调用的String对象拆分成String数组，根据传入的String内容进行切割，参考example/StringDemo
```


#### 4. 猜数字
```
猜一猜4个不重复的数字，请输入4个数字：  
1234
包含了1个正确的数字  
这些数字位置错误

请输入4个数字：
2314  
包含了1个正确的数字  
1个数字的位置正确 

请输入4个数字：
5367
包含了3个正确的数字
2个数字位置正确

请输入4个数字：
5396
回答正确
```

#### 5.抽签程序

出现的概率

|大吉 | 中吉 | 小吉 | 吉 | 末吉 | 凶  | 大凶 |
| ----|----|----|----|----|----|---- |
| 5% | 10% | 15% | 30% | 20% | 15% | 5%|

抽签程序，输入任意内容，抽一张，展示内容

输入0退出
