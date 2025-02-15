package custom;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Part1CustomClass {

    public static void main(String[] args) {

        List<Course> courses = List.of(
                new Course("Spring","Framework",98,20000),
                new Course("Spring Boot","Framework",95,18000),
                new Course("API","Microservices",97,22000),
                new Course("Microservices","Microservices",96,25000),
                new Course("FullStack","FullStack",91,14000),
                new Course("AWS","Cloud",92,21000),
                new Course("Azure","Cloud",99,21000),
                new Course("Docker","Container",92,20000),
                new Course("Kubernetes","Container",91,20000)
        );

        //allMatch , noneMatch, anyMatch

        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;

        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;

        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;

        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan90Predicate));

        System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));

        System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));

        System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan90Predicate));

        Predicate<Course> studentCountGreaterThan20 = course -> course.getNoOfStudents() >20000;

        Predicate<Course> studentCountLessThan25 = course -> course.getNoOfStudents() <= 25000;

        Predicate<Course> studentCountGreaterThan25 = course -> course.getNoOfStudents() >25000;

        System.out.println("Students Count");

        System.out.println(courses.stream().allMatch(studentCountLessThan25));
        System.out.println(courses.stream().noneMatch(studentCountGreaterThan25));
        System.out.println(courses.stream().anyMatch(studentCountGreaterThan20));

        //1st way
        System.out.println(courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents)).collect(Collectors.toList()));


        //2nd way
        Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);

        Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();

        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews
                = Comparator.comparing(Course::getNoOfStudents)
                        .thenComparing(Course::getReviewScore)
                        .reversed();

        System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasing)
                .map(Course::getNoOfStudents)
                .limit(5)
                .collect(Collectors.toList()));

        System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasing)
                .map(Course::getNoOfStudents)
                .skip(5)
                .collect(Collectors.toList()));

        System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasing)
                .map(Course::getNoOfStudents)
                .skip(2)
                .limit(5)
                .collect(Collectors.toList()));

        System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasing).collect(Collectors.toList()));

        //[Microservices:25000:96, API:22000:97, AWS:21000:92, Azure:21000:99, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]

        System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasing)
                        .takeWhile(course -> course.getReviewScore() >= 95)
                        .collect(Collectors.toList()));

        System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasing)
                .dropWhile(course -> course.getReviewScore() >= 95)
                .collect(Collectors.toList()));

        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews)
                .collect(Collectors.toList()));

        System.out.println(
                courses.stream().max(comparingByNoOfStudentsAndNoOfReviews)
        );

        System.out.println(
                courses.stream().min(comparingByNoOfStudentsAndNoOfReviews)
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreLessThan90Predicate)
                        .min(comparingByNoOfStudentsAndNoOfReviews)
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreLessThan90Predicate)
                        .min(comparingByNoOfStudentsAndNoOfReviews)
                        .orElse(new Course("Kubernetes","Container",91,20000))
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan90Predicate)
                        .findFirst()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan90Predicate)
                        .findAny()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .sum()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .average()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .count()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .max()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .min()
        );

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory))
        );

        //Output
        //{Container=[Docker:20000:92, Kubernetes:20000:91], Cloud=[AWS:21000:92, Azure:21000:99], FullStack=[FullStack:14000:91], Microservices=[API:22000:97, Microservices:25000:96], Framework=[Spring:20000:98, Spring Boot:18000:95]}


        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
        );

        //{Container=2, Cloud=2, FullStack=1, Microservices=2, Framework=2}

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
        );
        //{Container=Optional[Docker:20000:92], Cloud=Optional[Azure:21000:99], FullStack=Optional[FullStack:14000:91], Microservices=Optional[API:22000:97], Framework=Optional[Spring:20000:98]}

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName,Collectors.toList())))
        );
        //{Container=[Docker, Kubernetes], Cloud=[AWS, Azure], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}

    }
}
