import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Solution doesn't consider leap years.
 */
public class Main {

    private static final int DAYS_IN_YEAR = 365;
    private static final int MIN_NUMBER_OF_PEOPLE = 2;
    private static final int MAX_NUMBER_OF_PEOPLE = 100;
    private static final int INC_NUMBER_OF_PEOPLE = 2;

    private static Map<Integer,Boolean> results = new HashMap<>();

    public static void main(String[] args) {

        for (int i=MIN_NUMBER_OF_PEOPLE; i <= MAX_NUMBER_OF_PEOPLE; i+=INC_NUMBER_OF_PEOPLE)
            executeExperiment(i);
        
        for (Integer key : results.keySet().stream().sorted().toList()) {
            System.out.println("number of people: "+key+" | result: "+results.get(key));
        }
    }

    private static void executeExperiment(int numberOfPeople) {
        int[] birthdays = new int[numberOfPeople];

        for (int i=0; i < numberOfPeople; i++)
            birthdays[i] = new Random().nextInt(DAYS_IN_YEAR) + 1;

        int[] sortedBirthdays = Arrays.stream(birthdays).sorted().toArray();

        for (int i=0; i < numberOfPeople-1; i++) {
            if (sortedBirthdays[i] == sortedBirthdays[i+1]) {
                results.put(numberOfPeople, true);
                return;
            }
        }

        results.put(numberOfPeople, false);
    }
}