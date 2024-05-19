import edu.princeton.cs.algs4.MergeX;

import java.util.Arrays;

public class Autocomplete {
    private Term[] terms;

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        MergeX.sort(terms);
        this.terms = terms;
    }

    // Returns all terms that start with the given prefix,
    // in descending order of weight.
    public Term[] allMatches(String prefix) {
        int start = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 1),
                                                    Term.byPrefixOrder(prefix.length()));
        int end = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 1),
                                                 Term.byPrefixOrder(prefix.length()));
        if (start != 1 && end != -1) {
            Term[] temp = Arrays.copyOfRange(terms, start, end);
            Arrays.sort(temp, Term.byReverseWeightOrder());
            return temp;
        }
        return null;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        int start = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 1),
                                                    Term.byPrefixOrder(prefix.length()));
        int end = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 1),
                                                 Term.byPrefixOrder(prefix.length()));
        if (start != 1 && end != -1) {
            return start - end;
        }
        else return 0;
    }

    // unit testing (required)
    public static void main(String[] args) {
    }

}