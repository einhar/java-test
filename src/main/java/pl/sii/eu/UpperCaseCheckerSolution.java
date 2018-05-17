package pl.sii.eu;

public class UpperCaseCheckerSolution {
    public static void main(String[] args) {

        final String INPUT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit..";

        /* Implementation */
        UpperCaseChecker functionalInterfaceImpl = input -> input.chars().anyMatch(x -> Character.isUpperCase(x));

        UpperCheck(INPUT, functionalInterfaceImpl);
    }

    public static void UpperCheck(String string, UpperCaseChecker upperCaseChecker) {
        System.out.print("Text: \"" + string);
        if (upperCaseChecker.hasUpperCaseLetters(string)) {
            System.out.print("\" CONTAINS as least one upper case letter.");
        } else {
            System.out.print("\" does NOT CONTAIN any upper case letter.");
        }
    }
}
