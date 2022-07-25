import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ArraySetProblem extends Thread {

	static CopyOnWriteArraySet<String> courses = new CopyOnWriteArraySet();
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		courses.add("Kubernates");
	}

	public static void main(String[] args) throws Exception{
		
		ArraySetProblem arrayListProblem = new ArraySetProblem();
		arrayListProblem.start();
		courses.add("java");
		courses.add("python");
		courses.add("AWS");
		courses.add("Docker");

		Iterator<String> iterator = courses.iterator();

		while (iterator.hasNext()) {
			Thread.sleep(2000);
			String course = iterator.next();
			System.out.println(course);

			if (course.equals("Docker")) {

				courses.remove("Docker");
				courses.add("Node");
			}
			courses.add("cpp");
		}
		System.out.println(courses);
	}

}
