package spike.problems.hackerrank;

import java.util.Arrays;

/**
 * See https://www.hackerrank.com/challenges/angry-professor and
 * src/main/resources/hackerrank/angry-professor-English.pdf
 */
public class AngryProfessor {

    public static void solve(int cancellationThreshold, Integer[] arrivalTimes) {
        long punctualStudents = Arrays.stream(arrivalTimes).filter(o -> o <= 0).count();
        System.out.println(punctualStudents < cancellationThreshold ? "YES" : "NO" );
    }

}
