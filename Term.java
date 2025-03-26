import java.util.Comparator;

public class Term implements Comparable<Term> {
    private String query;
    private long weight;

    public String getQuery() {
        return query;
    }

    public long getWeight() {
        return weight;
    }

    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        if (query != null || weight >= 0) {
            this.query = query;
            this.weight = weight;
        }
        else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        return new Comparator<Term>() {
            public int compare(Term o1, Term o2) {
                if (o1.weight > o2.weight) {
                    return -1;
                }
                else if (o1.weight < o2.weight) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        };
    }

    // Compares the two terms in lexicographic order,
    // but using only the first r characters of each query.
    // public static Comparator<Term> byPrefixOrder(int r) {
    //     return new Comparator<Term>() {
    //         public int compare(Term o1, Term o2) {
    //             int temp = Math.min(o1.query.length(), o2.query.length());
    //             temp = Math.min(temp, r);
    //             String str1 = o1.query.substring(0, temp);
    //             String str2 = o2.query.substring(0, temp);
    //             int t = str1.compareTo(str2);
    //             return t;
    //         }
    //     };
    // }
    //

    public static Comparator<Term> byPrefixOrder(int r) {
        return new Comparator<Term>() {
            public int compare(Term o1, Term o2) {
                String o1str = o1.query;
                String o2str = o2.query;
                int temp = Math.min(o1str.length(), o2str.length());
                temp = Math.min(temp, r);
                String str1 = o1.query.substring(0, Math.min(r, o1str.length()));
                String str2 = o2.query.substring(0, Math.min(r, o2str.length()));
                int t = str1.compareTo(str2);
                return t;
            }
        };
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        return this.query.compareTo(that.query);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return weight + "\t" + query + "\n";
    }

    // unit testing (required)
    public static void main(String[] args) {

    }

}

