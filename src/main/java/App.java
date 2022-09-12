import dao.Dao;
import dao.Impl.DaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Service;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        Dao dao = (Dao) context.getBean("dao");
        dao.save();

        Service service = (Service) context.getBean("service");
        service.save();
    }
}
