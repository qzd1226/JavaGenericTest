package java2;

import org.testng.annotations.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1，泛型在继承方面的体现
 *
 * 2，通配符的使用
 */
public class GenericTest {
    /**
     * 1，泛型在继承方面的体现
     * 虽然类A是类B的父类，但是G<A> G<B>二者不具备子父类关系，二者是并列关系
     * 补充： 类A是类B的父类， A<G> 是B<G>的父类
     */
    @Test
    public void test1(){
        Object obj = null;
        String str = "子类";
        obj = str;
        System.out.println(obj);
        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时的list1 list2不具有子父类关系
        //list1 = list2 编译出错
        //编译不通过
        // Date date = new Date();
        //str = date;
        /**
         * 反证法
         * 假设list1 = list2;
         * list1.add(123); 导致混入非String数据(list1 list2指的地址相同)
         */
    }
    @Test
    public void test2(){
        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;
        list1 = list3;
        list2 = list3;
    }
    /**
     * 通配符的使用
     *   通配符：？
     *   类A是类B的父类，G<A>,G<B>是没有关系的，二者共同的父类是:G<?>
     */
    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list = null; //此时 List<?>作为 List<Object>和List<String>的通用父类
        list = list1;
        list = list2;
        print(list1);
        print(list2);
        //
        List<String> list3 = new ArrayList<>();
        list3.add("aa");
        list3.add("bb");
        list3.add("cc");
        list = list3;
        //添加：对于List<?>就不能想其内部添加数据
        //除了添加null之外
        //list.add()
        list.add(null);
        //获取 允许读通配符中的数据，读取的数据的类型是Object
        Object obj = list.get(0);


    }
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
    /**
     * 3.有限制条件的通配符的使用
     *      ? extends A:
     *      G<?, extends A>可以作为G<A>,G<B>的父类的，其中B是A的子类
     *
     *      ? super A:
     *      G<?, super A>可以作为G<A>,G<B>的父类的，其中B是A的父类
     */
    @Test
    public void test4(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;
        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
        //list1 = list5;

        //list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据
        list1 = list4;
        Person  p = list1.get(0);
       //写入数据
        //编译不通过
        //list1.add(new Student());
        //list1.add(new Person());
        //list1.add(new Object());

        list2.add(new Person());
        list2.add(new Student());
        //编译不通过
        //list2.add(new Object());

    }
}
