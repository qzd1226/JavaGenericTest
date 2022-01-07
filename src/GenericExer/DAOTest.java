package GenericExer;

import java.util.List;

public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<User>();
        dao.save("1001",new User(1001,29,"李某"));
        dao.save("1002",new User(1002,40,"张某"));
        dao.save("1003",new User(1003,51,"孙某"));
        dao.save("1004",new User(1004,2,"网某"));
        dao.update("1003",new User(1003,20,"钱某"));
        dao.delete("1002");
        List<User> list = dao.list();
        System.out.println(list);
        //list.forEach(System.out::println);


    }
}
