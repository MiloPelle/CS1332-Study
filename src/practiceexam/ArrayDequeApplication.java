package practiceexam;

import java.util.ArrayDeque;

/**
 * Spring 2026 Practice Exam 1 - Question 8: ArrayDeque - Application [15 points]
 *
 * Given a String s, return whether the string is a valid set of parentheses.
 * An input string is valid if all open brackets are closed by the same type
 * of brackets, all open brackets are closed in the correct order, and every
 * close bracket has a corresponding open bracket of the same type.
 *
 * Requirements:
 *  - Your code should be as efficient, in both space and time, as possible.
 *  - You may not assume any other method in the ArrayDeque class is implemented.
 *  - Your solution must use an ArrayDeque.
 *
 * Examples:
 *  s = "()[]{}" -> true
 *  s = "({[]})" -> true
 *  s = "()(()"  -> false
 */
public class ArrayDequeApplication {

    /**
     * Determines whether the given string is a valid set of parentheses.
     *
     * @param s the string containing only brackets
     * @throws IllegalArgumentException if the string is null or empty
     * @return boolean whether given string is a valid set of parentheses
     */
    public static boolean validParentheses(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        ArrayDeque arr = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            arr.addLast(s.charAt(i));
        }
        
        int parentheses = 0;
        int brackets = 0;
        int squiggles = 0;

        while (arr.size() != 0) {
            char pop = (char) arr.removeLast();
            switch (pop) {
                case ')':
                    parentheses++;
                case '(':
                    parentheses--;
                case ']':
                    brackets++;
                case '[':
                    brackets--;
                case '}':
                    squiggles++;
                case '{':
                    squiggles--;
                default:
                    if (parentheses < 0 || brackets < 0 || squiggles < 0) {
                        return false;
                    }
            }
        }
        return (parentheses == 0 && brackets == 0 && squiggles == 0);

    } // END OF METHOD
} // END OF CLASS
