import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Autocomplete {
    private Term[] terms;

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        if (terms == null) {
            throw new IllegalArgumentException("terms cannot be null");
        }
        try {
            this.terms = terms;
            Arrays.sort(terms);
        }
        catch (NullPointerException e) {
            throw new IllegalArgumentException("terms cannot be null");
        }

    }

    // Returns all terms that start with the given prefix,
    // in descending order of weight.
    public Term[] allMatches(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("prefix cannot be null");
        }
        int len = prefix.length();
        int start = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 1),
                                                    Term.byPrefixOrder(len));
        int end = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 1),
                                                 Term.byPrefixOrder(len));
        if (start != 1 && end != -1) {
            Term[] temp1 = Arrays.copyOfRange(terms, start, end + 1);
            Arrays.sort(temp1, Term.byReverseWeightOrder());
            return temp1;
        }
        else {
            throw new IllegalArgumentException("No matches found");
        }
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("prefix cannot be null");
        }
        int len = prefix.length();
        int start = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 1),
                                                    Term.byPrefixOrder(len));
        int end = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 1),
                                                 Term.byPrefixOrder(len));
        if (start != 1 && end != -1) {
            return end - start + 1;
        }
        else return 0;
    }

    // unit testing (required)
    public static void main(String[] args) {

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int n = in.readInt();
        Term[] terms = new Term[n];
        for (int i = 0; i < n; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }

        // read in queries from standard input and print the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            StdOut.printf("%d matches\n", autocomplete.numberOfMatches(prefix));
            for (int i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }


}