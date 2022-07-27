import java.util.Iterator;

public class ConcurrentHashMap extends Thread {

	static java.util.concurrent.ConcurrentHashMap<String,Float> coursesRating = new java.util.concurrent.ConcurrentHashMap();
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		coursesRating.put("Kubernates",4.8f);
	}

	public static void main(String[] args) throws Exception{
		
		ConcurrentHashMap arrayListProblem = new ConcurrentHashMap();
		arrayListProblem.start();
		coursesRating.put("java",5.0f);
		coursesRating.put("python",4.8f);
		coursesRating.put("AWS",4.5f);
		coursesRating.put("Docker",4.65f);

		Iterator<String> iterator = coursesRating.keySet().iterator();

		while (iterator.hasNext()) {
			Thread.sleep(2000);
			String course = iterator.next();
			System.out.println(coursesRating.get(course));  //how to print the course name instead of course rating.

			if (course.equals("Docker")) {

				coursesRating.remove("Docker");
				coursesRating.put("Node",4.5f);
			}
			coursesRating.put("cpp",4f);
		}
		System.out.println(coursesRating);
	}

}
