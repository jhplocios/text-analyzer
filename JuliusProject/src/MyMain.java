import java.sql.Timestamp;
import java.util.Map;

public class MyMain {
	public static void main(String[] args) {
		System.out.println("--------------------Single Thread 3 Iteration----------------------------");
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		for(int i=0; i<100;i++) {
	  		FileUtility1 fu = new FileUtility1();
	  		System.out.println(fu.processFile(args[0], ResultType.SENTENCES));
	  		System.out.println(fu.processFile(args[0], ResultType.PARAGRAPHS));
	  		System.out.println(fu.processFile(args[0], ResultType.WORDS));
	  		System.out.println(fu.processFile(args[0], ResultType.CHARACTERS));
			
		}
		Timestamp endTime = new Timestamp(System.currentTimeMillis());
		System.out.println("START : " + startTime + " and END : " + endTime  );
		System.out.println("--------------------- 4 Thread 3 Iteration------------------------------");
		for(int i=0; i<100;i++) {
			startTime = new Timestamp(System.currentTimeMillis());
			Thread t1 = new FileProcessor( args[0], ResultType.SENTENCES);
			Thread t2 = new FileProcessor( args[0], ResultType.PARAGRAPHS);
			Thread t3 = new FileProcessor( args[0], ResultType.WORDS);
			Thread t4 = new FileProcessor( args[0], ResultType.CHARACTERS);
			t1.start();
			t2.start();
			t3.start();
			t4.start();
		}
		endTime = new Timestamp(System.currentTimeMillis());
		System.out.println("START : " + startTime + " and END : " + endTime  );
	}

}
