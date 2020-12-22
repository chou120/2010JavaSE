import java.util.ArrayList;

public class ClassDemo {

  public static void main(String[] args) {
    MyClass providerClass = new MyClass();
    providerClass.fieldList = new ArrayList<>();
    providerClass.methodList = new ArrayList<>();

    MyField idField = new MyField();
    idField.fieldName = "id";
    idField.fieldType = "int";

    MyField nameField = new MyField();
    nameField.fieldName = "name";
    nameField.fieldType = "String";

    MyField descField = new MyField();
    descField.fieldName = "desc";
    descField.fieldType = "String";

    providerClass.fieldList.add(idField);
    providerClass.fieldList.add(nameField);
    providerClass.fieldList.add(descField);

    MyMethod myMethod = new MyMethod();
    myMethod.methodName = "getName";
    myMethod.modifier = "public";
    myMethod.returnType = "String";
    providerClass.methodList.add(myMethod);

  }
}
