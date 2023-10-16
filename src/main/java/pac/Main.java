package pac;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
	
	//Creo variables estaticas globales para poder trabajar con las diferentes funciones
	private static Transaction trans;
	private static Modulo modulo1;
	private static Modulo modulo2;
	private static Modulo modulo3;
	private static Modulo modulo4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("INICIO DEL PROGRAMA...");
		//configuramos la conexion
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder()
											.configure().build());
		
		Session session = sessionFactory.openSession();
		
		System.out.println("Configuracion REALIZADA...");
		
		//llamamos a los metodos para insertar datos
		meterModulos(session);
		meterProfesor(session);
		meterAlumnos(session);
		
		//cerramos session y sessionFactory
		session.close();
		sessionFactory.close();
		
		//parar confirmar que ha finalizado
		System.out.println("Conexion finalizada...");

	}
	
	//funcion para insertar modulos
	public static void meterModulos(Session session) {
		
		trans = session.beginTransaction();
		modulo1 = new Modulo("Programacion B", "M03B");
		modulo2 = new Modulo("Acceso a Datos", "M06");
		modulo3 = new Modulo("Desarrollo de interfaces", "M07");
		modulo4 = new Modulo("Proyecto DAM", "M13");
		
		//guardo los registos de modulos en la BD
		session.persist(modulo1);
		session.persist(modulo2);
		session.persist(modulo3);
		session.persist(modulo4);
		
		//confirmamos la transaccion para que los datos se guarden en la BD
		trans.commit();
		
		//imprimo mensaje por pantalla de los modulos
		System.out.println(modulo1.toString());
		System.out.println(modulo2.toString());
		System.out.println(modulo3.toString());
		System.out.println(modulo4.toString());
		
		
	}
	
	//funcion para insertar profesor
	public static void meterProfesor(Session session) {
		
		trans = session.beginTransaction();
		
		Profesor profesor1 = new Profesor("Hassabis", "Mujer");
		
		//guardo registro profesor
		session.persist(profesor1);
		
		//confirmo transaccion
		trans.commit();
		
		System.out.println(profesor1.toString());
		
		
		
	}
	
	//funcion para insertar alumnos
	public static void meterAlumnos(Session session) {
		
		trans = session.beginTransaction();
		
		/*Creamos cada alumno y al conjunto Set se crea con un HashSet, iniciandolo con un array
		de objetos de tipo Modulo que hemos creado anteriormente cada uno de ellos con los modulos
		que le corresponden*/
		Alumno alumno1 = new Alumno("Sandberg", "USA", 26, "Mujer", 
				new HashSet<Modulo>(Arrays.asList(modulo1,modulo2,modulo3,modulo4)));
		Alumno alumno2 = new Alumno("Fei-Fei Li", "China", 21, "Mujer", 
				new HashSet<Modulo>(Arrays.asList(modulo1,modulo2,modulo3)));
		Alumno alumno3 = new Alumno("Sophie Wilson", "Reino Unido", 19, "Mujer", 
				new HashSet<Modulo>(Arrays.asList(modulo3,modulo4)));
		Alumno alumno4 = new Alumno("Aya Soffer", "Israel", 35, "Mujer", 
				new HashSet<Modulo>(Arrays.asList(modulo2,modulo3,modulo4)));
		
		//guardo los registos de los alumnos en la BD
		session.persist(alumno1);
		session.persist(alumno2);
		session.persist(alumno3);
		session.persist(alumno4);
		
		//confirmo la transaccion
		trans.commit();
		
		//imprimimos el mensaje por pantalla
		System.out.println(alumno1.toString());
		System.out.println(alumno2.toString());
		System.out.println(alumno3.toString());
		System.out.println(alumno4.toString());
		
		
		
	}
	
	

}
