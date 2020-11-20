### 第一个任务
修改(补全)Hammer代码
### 第二个任务
思考setXXX()里面的变量名能不能改  this
### 第三个任务
现有学生模板,有以下其属性:
  学生名   stuName
  学号     stuId
  学生成绩  stuScore
  学生住址  stuAddress;

3年五班 有6个学生  进行一次测试,根据测试的成绩进行降序排序
Student[] student=new Student[6];


### 综合练习
有用户User类 属性  username   password   userId  address  iphone

有商品类 Product  属性  proName(商品名称)  proPrice(商品价格)
                      proId(商品编号)  proAddress(商品产地) proWeight(商品重量)
有订单类 Order    属性：username(用户名) iphone(用户联系方式)  address(用户地址,也就是商品即将发出的目的地)
                proName(商品名称) proPrice(商品价格) count(商品数量)

--- 完成用户登录功能
public boolean  login(User user){

}
--- 用户登录成功之后,可以看到所有的商品列表信息
/*
  完成所有商品显示功能
**/
public   Product[] getAllProduct(){

}
--- 用户可以有购买商品的功能,删除以购买的商品
public void  addProductToUser(Product product){

}
delete
public void  delProductToUser(Product product){

}



















