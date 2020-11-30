package club.service.util;

import club.service.entity.Product;
import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/24 10:23 上午
 */
public class ArrayList {

  private int count;
  private  Object [] str;

  public ArrayList() {
      str=new Object[0];
  }

  /**
   * 更新数组指定下标的元素
   *
   * @param index   待更新的元素下标
   * @param element 更新后的元素对象
   * @return 被替换掉的旧对象
   */
  public Object set(int index, Object element) {
    if(index<0 || index>str.length){
      System.out.println("输入下标超出了...");
      return null;
    }
    Object st=str[index];
    str[index]=element;
    return st;
  }
  /**
   * 查询指定位置下标的元素
   *
   * @param index 需要判断index是否合法
   * @return 返回查找到的元素，找不到返回null
   */
  public Object get(int index) {
    if(index<0 || index>str.length){
      System.out.println("输入下标超出了...");
      return null;
    }
    return str[index];
  }

  /**
   * 清空集合内容
   */
  public void clear() {
    //TODO
    str=null;
  }

  /**
   * 删除指定下标的元素
   *
   * @param index 元素下标
   * @return 将删除的元素返回，如果下标不合理，返回null
   */
  public Object remove(int index) {
    if(index<0 || index>str.length){
      System.out.println("输入下标超出了...");
      return null;
    }
    Object st=str[index];
    for (int i = index; i < str.length; i++) {
        if(i==str.length-1){
          str[i]=null;
        }else{
          str[i]=str[i+1];
        }
    }
    str=Arrays.copyOf(str, str.length-1);
    count--;
    return  st;
  }

  /**
   * 查找并删除元素
   *
   * @param o 通过目标元素 equals 方法判断是否匹配， 需要判断o是否为null，如果传入null，则用== 进行比较
   * @return
   */
  public boolean remove(String o) {  //传递一个字符串编号
      if(o==null){
        System.out.println("传入的数据不正确");
        return false;
      }
    for (int i = 0; i < str.length; i++) {
      Product  product=(Product)str[i];
      if(product.getNumber().equals(o)){
        //又是删除
        Object st= remove(i);
          if(st!=null){
            return true;
          }
      }
    }
    return false;
  }


  /**
   * 添加一个元素
   *
   * @param o
   * @return 添加成功后返回true 失败返回false
   */
  public boolean add(Object o) {
    str=Arrays.copyOf(str, str.length+1);
    str[str.length-1]=o;
    count++;
    return true;
  }

  /**
   * @return 数组中没有元素，返回true
   */
  public boolean isEmpty() {
    //TODO
    return count==0;
  }

  /**
   * 返回数组中保存的元素个数
   *
   * @return
   */
  public int size() {

    return count;

  }


  public static void main(String[] args) {

    ArrayList arrayList = new ArrayList();
    arrayList.add(""+1);
    arrayList.add(""+2);
    arrayList.add(""+3);
    arrayList.add(""+4);
    arrayList.add(""+5);


//
  //  System.out.println(arrayList.isEmpty());

    System.out.println(arrayList.remove("2"));
    for (int i = 0; i < arrayList.size(); i++) {
      System.out.println(arrayList.get(i));
    }

//
//    System.out.println(arrayList.remove(Integer.valueOf(4)));
//
//    System.out.println("============");
//
//    for (int i = 0; i < arrayList.size(); i++) {
//      System.out.println(arrayList.get(i));
//    }
    arrayList.set(0, ""+200);
//    System.out.println("+++++++++++++");
    for (int i = 0; i < arrayList.size(); i++) {
      System.out.println(arrayList.get(i));
    }

  }


}
