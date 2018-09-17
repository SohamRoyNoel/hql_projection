package master;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientApp {

	public static void main(String[] args) {
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		Employee emp3 = new Employee();
		Employee emp4 = new Employee();
		Employee emp5 = new Employee();
		Employee emp6 = new Employee();
		
		emp1.setEid(1);
		emp1.setEname("Soham");
		emp1.setEjob("Developer");
		emp1.setEsal(20000.00);
		
		emp2.setEid(2);
		emp2.setEname("Aditya");
		emp2.setEjob("Manager");
		emp2.setEsal(12000.00);
		
		emp3.setEid(3);
		emp3.setEname("Ankit");
		emp3.setEjob("Manager");
		emp3.setEsal(15000.00);
		
		emp4.setEid(4);
		emp4.setEname("Nick");
		emp4.setEjob("Clerk");
		emp4.setEsal(10000.00);
		
		emp5.setEid(5);
		emp5.setEname("Tom");
		emp5.setEjob("Clerk");
		emp5.setEsal(9000.00);
		
		emp6.setEid(6);
		emp6.setEname("John");
		emp6.setEjob("Analyst");
		emp6.setEsal(13000.00);
		
		SessionFactory sessfact=new Configuration().configure().buildSessionFactory();
		Session session=sessfact.openSession();
		session.beginTransaction();
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		session.save(emp5);
		session.save(emp6);
		session.getTransaction().commit();
		String hql="select e.ename,e.ejob from Employee e";
		Query query=session.createQuery(hql);
		List results=query.list();
		Iterator itr=results.iterator();
		while(itr.hasNext())
		{
			//Employee empl=(Employee)itr.next();
			//System.out.println(empl.getEid()+"===>"+empl.getEname()+"====>"+empl.getEjob()+"====>"+empl.getEsal());
			Object[] row=(Object[])itr.next();
			System.out.println(row[0]+"============>"+row[1]);
		}
	}
	

}
