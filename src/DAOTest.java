import org.testng.annotations.Test;

import java.util.List;

public class DAOTest {
    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();
        dao1.add(new Custmoer());
        List<Custmoer> list = dao1.getfForList();
        StudentDAO dao2 = new StudentDAO();
        dao2.add(new Student());
        List<Student> list2 = dao2.getfForList();
    }
}
