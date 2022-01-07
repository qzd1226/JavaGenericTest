import org.testng.annotations.Test;

import java.util.*;
import java.util.Map.Entry;

/**
 * 泛型的使用：
 * 1，jdk5.0新增的特性
 * 2、在集合中使用泛型：
 *  总结：
 *  一：集合接口或集合类在jdk5.0时都修改为带泛型的结构
 *  二：在实例化集合类时，可以指明具体的泛型类型
 *  三：指明完以后，在集合类或接口中凡事定义类或接口时，内部结构(比如方法，构造器，内部结构)
 *  使用到类的泛型的位置，都指定为实例化时泛型的类型
 *      比如： add(E e) --->实例化后： add(Integer e);
 *  四：泛型的类型必须是类，不能是基本数据类型（需要用到基本数据类型，必须使用其包装类)
 *  五：如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object
 * 3、如何自定义泛型结构：泛型类，泛型接口，泛型方法(GenericTest1)
 *
 *
 */
public class GenericTest
{
    //在集合中不使用泛型的情况
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(90);
        list.add(81);
        list.add(88);
        //问题一：类型不安全
        list.add("Tom");
        for(Object score:list){
            //问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer)score;
            System.out.println(stuScore);

        }
    }
    //在集合中使用泛型的情况,以ArrayList为例
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(78);
        list.add(90);
        list.add(81);
        list.add(88);
        //list.add("Tom"); //编译时就会进行类型检查保证数据安全
        //方式一：
//        for(Integer score: list){
//            //避免了强转操作
//            int stuScore = score;
//            System.out.println(stuScore);
//        }
        //方式二:
        Iterator<Integer> iterator= list.iterator();
        while(iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }
    //在集合中使用泛型的情况，以HashMap为例
    @Test
    public void test3(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("小明",88);
        map.put("jack",78);
        map.put("jerry",98);
        //map.put(98,"mike"); //编译无法通过
        //泛型的嵌套
        Set<Entry<String,Integer>> entry = map.entrySet();
        Iterator<Entry<String,Integer>> iterator = entry.iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Integer> entry1 = iterator.next();
            String key = entry1.getKey();
            Integer value = entry1.getValue();
            System.out.println(key + "======" + value);
        }
    }
}
