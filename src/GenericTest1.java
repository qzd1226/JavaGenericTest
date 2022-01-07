import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *  * 3、如何自定义泛型结构：泛型类，泛型接口，泛型方法(GenericTest1)
 */
public class GenericTest1 {
    @Test
    public void test1(){
        //如果定义了泛型 实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果定义了类是泛型，建议实例化时要指明泛型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("abc");

        //建议：实例化时直径类的泛型：
        Order<String> order1 = new Order<String>("oderA",1001,"order:描述");
        order1.setOrderT("hello");

    }
    @Test
    public void test2(){
        SubOrder sub1 = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型的类型。则实例化子类对象时，不再需要指明泛型
        sub1.setOrderT(123);
        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("abc");
    }
    @Test
    public void test3(){
        //泛型不同的引用下不能互相赋值
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
        //泛型不同的引用不能相互赋值
        //list1 = list2 // 编译不过
    }
    //测试泛型方法
    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }
}
