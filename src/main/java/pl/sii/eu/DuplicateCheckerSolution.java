package pl.sii.eu;

import java.util.HashSet;
import java.util.Set;

public class DuplicateCheckerSolution {
    public static void main(String[] args) {

        final String INPUT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit..";

        /* Implementation */
        DuplicateChecker functionalInterfaceImpl = (String input) -> {
            input = input.replaceAll("\\s","");
            Set<Character> set = new HashSet<>();

            for (Character c : input.toCharArray()) {
                if (set.contains(c)) {
                    return true;
                } else {
                    set.add(c);
                }
            }

            return false;
        };

        DuplicateCheck(INPUT, functionalInterfaceImpl);
    }

    public static void DuplicateCheck(String string, DuplicateChecker duplicateChecker) {
        System.out.print("Text: \"" + string);
        if (duplicateChecker.hasDuplicateCharacters(string)) {
            System.out.print("\" CONTAINS at least one duplicate.");
        } else {
            System.out.print("\" does NOT CONTAIN any duplicate.");
        }
    }
}
