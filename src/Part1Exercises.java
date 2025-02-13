import java.util.List;

public class Part1Exercises {

    public static void main(String args[]){

        List<Integer> numbers = List.of(1,4,5,6,8,9,23,12);

        int  num = 4;

        printOddNumbers(numbers);

        List<String> courses =
                List.of("Spring", "Spring Boot", "API" , "Microservices",
                        "AWS", "PCF","Azure", "Docker", "Kubernetes");

        printCoursesIndividually(courses);

        //Print Courses Containing the word "Spring"

        printAWordFromTheList(courses);

        //Print Courses Whose Name has atleast 4 letters
        printCoursesHavingAtleastNLetters(courses,num);

        //Print the Square of even numbers
        printSquareOfEvenNumbers(numbers);

        //Print the cubes of odd numbers
        printCubeOfOddNumbers(numbers);

        //Print the number of characters in each course name
        printNumberOfCharacterInCourse(courses);
    }

    private static void printNumberOfCharacterInCourse(List<String> courses) {

        courses.stream()
                .map(course -> course +" " +course.length())
                .forEach(System.out::println);

        courses.stream()
                .map(course -> course.chars().count())
                .forEach(System.out::println);
    }

    private static void printCubeOfOddNumbers(List<Integer> numbers) {

        numbers.stream()
                .filter(num -> num %2 !=0)
                .map(num -> num * num * num)
                .forEach(System.out::println);
    }

    private static void printSquareOfEvenNumbers(List<Integer> numbers) {

        numbers.stream()
                .filter(num -> num %2 == 0)
                .map(num -> num + " "+num * num)
                .forEach(System.out::println);
    }

    private static void printCoursesHavingAtleastNLetters(List<String> courses, int num) {

        //1st approach
        courses.stream()
                .filter(course -> course.chars().count() >=num )
                .forEach(System.out::println);

        //2nd approach
        courses.stream()
                .filter(course -> course.length() >=num)
                .forEach(System.out::println);
    }

    private static void printAWordFromTheList(List<String> courses) {

        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printCoursesIndividually(List<String> courses) {

        courses.stream().forEach(System.out::println);
    }

    private static void printOddNumbers(List<Integer> numbers) {

        //1st logic
        numbers.stream()
                .filter(num -> num %2 ==1) //filter the odd number from this list
                .forEach(System.out::println); // print the list
        //2nd logic
        numbers.stream()
                .filter(num -> num %2 !=0 )
                .forEach(System.out::println);
    }
}
