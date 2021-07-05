## 1

满分是120分。2.0级以上为及格
每增加5分，等级就会上升。注意4.3级并不存在。
下表显示了分数与成绩之间的映射关系:
```
grade	points
1.0	    0 - 49.5
1.3	    50 - 59.5
1.7	    60 - 64.5   
从第3行开始就是60 - 64.5  一共有12行 可以循环12次

把第一行第二行和最后一行单独拎出来,而且是每5分提升一个等级

按照正常情况下到第三行应该是60+2*5 - 60+2*5+4.5
第四行应该是     60+3*5 -60+3*5+4.5
以此类推 
但是    每五分一个等级是从60开始的  所以相当于
60+0*5 - 60+0*5+4.5
综上所述 我们可以得一个结论

60+(i-2)*5+" - "+60+(i-2)*5+4.5  

直到倒数第二行都会满足上述结构

然后我们开始去写等级代码:
给一个默认等级 
double grade=1.0;


2.0	    65 - 69.5
2.3	    70 - 74.5
2.7	    75 - 79.5
3.0	    80 - 84.5
3.3	    85 - 89.5
3.7	    90 - 94.5
4.0	    95 - 99.5
4.7	    100 - 104.5
5.0	    105 - 120
```
编写一个方法打印上述表格数据
```
static void printGradeTable()
```

编写一个方法根据分数换算等级
```
static double getGrade(double point)
```

它返回考试中达到的分数，并打印出从0到120的所有分数的分数(步骤为0.5)。
```
static boolean isPass(double point)
```

## 2
编写一个方法，输入一个 单位是byte的字节数，
返回一个字符串，后面使用合适的单位进行标识

```
static String formateByte(long bytes){
	
	
	

}
```

```m
转换结果如下
123  => 123.0 B
15323 => 15.323 KB
15323000 => 15.323 MB
1532300001 => 1.532300001 GB
```