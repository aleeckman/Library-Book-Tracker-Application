package hw1;

// DO NOT MODIFY this file for your submission!

public class ExpensiveComputeToy {
    private static int numberOfTimesExpensiveSetupCalled = 0;
    public static void performExpensiveLogSetup() {
        numberOfTimesExpensiveSetupCalled++;
        System.out.println("Performing 'expensive' setup lazily...");
        int meaning = (int)Math.sqrt(Math.pow(42, 2));
        System.out.println("Beep boop. " + meaning + "... Done.");
    }

    public static int getNumberOfTimesExpensiveSetupCalled() {
        return numberOfTimesExpensiveSetupCalled;
    }
}
