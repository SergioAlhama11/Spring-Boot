package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;
	
	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	
	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}
	
}

public class FP04CustomClass {

	public static void main(String[] args) {
		
		List<Course> courses = 	List.of(
				new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000),
				new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("Full Stack", "FullStack", 91, 14000),
				new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000),
				new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000)
		);
		
		//allMatch, noneMatch, anyMatch
		
		Predicate<Course> reviewScoreGraterThan50Predicate = course -> course.getReviewScore() > 50;
		Predicate<Course> reviewScoreGraterThan90Predicate = course -> course.getReviewScore() > 90;
		Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;
		
		System.out.println(courses.stream().allMatch(reviewScoreGraterThan50Predicate)); // Devuelve true si todos los elementos de la lista cumple con el predicado
		System.out.println(courses.stream().anyMatch(reviewScoreGraterThan90Predicate)); // Devuelve true si alguno de los elementos de la lista cumple con el predicado
		System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate)); // Devuelve true si ninguno de los elementos de la lista cumple con el predicado
		
		Comparator<Course> comparingByNoOfStudentsComparatorIncreasing = Comparator.comparingInt(Course::getNoOfStudents);
		
		System.out.println(courses.stream().sorted(comparingByNoOfStudentsComparatorIncreasing).collect(Collectors.toList()));

		Comparator<Course> comparingByNoOfStudentsComparatorDecreasing = Comparator.comparingInt(Course::getNoOfStudents).reversed();
		
		System.out.println(courses.stream().sorted(comparingByNoOfStudentsComparatorDecreasing).collect(Collectors.toList()));
		
		Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator.comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore).reversed();

		System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).collect(Collectors.toList()));
		
		Comparator<Course> comparingByNameLength = Comparator.comparingInt(course -> course.getName().length());
		
		System.out.println(courses.stream().sorted(comparingByNameLength).collect(Collectors.toList()));
	}

}
