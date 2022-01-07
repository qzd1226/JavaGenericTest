import java.util.ArrayList;
import java.util.List;

public class Order<T> {
    String orderName;
    int orderId;

    //类的内部结构可以使用类的泛型
    //自定义的泛型类
    T orderT;
    public Order(){

    }
    public Order(String orderName,int orderId, T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }
    //如下的三个方法都不是泛型方法
    public T getOrderT(){
        return orderT;
    }
    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
//    静态方法中不能使用类的泛型 原因：静态方法的创建早于实例化，而泛型类需要实例化后才能形成
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }
    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    //换句话说，泛型方法所属的类是不是泛型类没有任何关系
    //泛型方法，可以声明为静态的。原因：泛型参数时在调用方法时确定的。并非在实例化类时确定的
    public <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for(E e : arr){
            list.add(e);
        }
        return list;
    }

}
