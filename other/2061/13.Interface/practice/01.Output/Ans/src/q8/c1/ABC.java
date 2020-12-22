package q8.c1;

interface ABC {

  public void methodOne();

  public void methodTwo();
}

interface PQR extends ABC {

  public void methodOne();

  public void methodTwo();
}

class A implements PQR {

  @Override
  public void methodOne() {

  }

  @Override
  public void methodTwo() {

  }
}

class B implements ABC {

  @Override
  public void methodOne() {

  }

  @Override
  public void methodTwo() {

  }
}

class Demo {

  public static void main(String[] args) {
    PQR pqr = new A();
    ABC abc = new B();
    // 因为 PRQ继承了ABC接口，因此 类A的对象可以被看做是 ABC的对象
    ABC abc1 = new A();
  }
}