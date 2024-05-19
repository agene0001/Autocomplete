import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AutocompleteTest {

    public Autocomplete setupFile(String filename) {

        Term[] terms = Autocomplete.setup(filename);
        return new Autocomplete(terms);
    }

    @Test
    void testSmallAutocomplete_h() {
        Autocomplete autocomplete = setupFile("small.txt");
        Term[] matches = autocomplete.allMatches("h");
        System.out.println(Arrays.toString(matches));
        Assertions.assertEquals(3, matches.length);
        Assertions.assertEquals("horseking", matches[0].getQuery());
        Assertions.assertEquals("horde", matches[1].getQuery());
        Assertions.assertEquals("horse", matches[2].getQuery());
    }

    @Test
    void testSmallAutocomplete_hors() {

        Autocomplete autocomplete = setupFile("small.txt");
        Term[] matches = autocomplete.allMatches("hors");
        System.out.println(Arrays.toString(matches));
        Assertions.assertEquals(2, matches.length);
        Assertions.assertEquals("horseking", matches[0].getQuery());
        Assertions.assertEquals("horse", matches[1].getQuery());
    }

    @Test
    void testArtistsAutocomplete() {

        Autocomplete autocomplete = setupFile("artists.txt");
        Term[] matches = autocomplete.allMatches("Abdel A");
        System.out.println(Arrays.toString(matches));
        Assertions.assertEquals(2, matches.length);
        Assertions.assertEquals("Abdel Ali Slimani", matches[0].getQuery());
        Assertions.assertEquals("Abdel Aziz El Mubarak", matches[1].getQuery());
    }

    @Test
    void testPuBuildingsAutocomplete() {

        Autocomplete autocomplete = setupFile("pu-buildings.txt");
        Term[] matches = autocomplete.allMatches("N");
        System.out.println(Arrays.toString(matches));
        Assertions.assertEquals(4, matches.length);
        Assertions.assertEquals("Nassau Hall", matches[0].getQuery());
        Assertions.assertEquals("New Graduate College", matches[1].getQuery());
        Assertions.assertEquals("New South Building", matches[2].getQuery());
        Assertions.assertEquals("North Garage", matches[3].getQuery());
    }

    @Test
    void testPuBuildingsNeAutocomplete() {

        Autocomplete autocomplete = setupFile("pu-buildings.txt");
        Term[] matches = autocomplete.allMatches("Ne");
        System.out.println(Arrays.toString(matches));
        Assertions.assertEquals(2, matches.length);
        Assertions.assertEquals("New Graduate College", matches[0].getQuery());
        Assertions.assertEquals("New South Building", matches[1].getQuery());
    }

    @Test
    void testPuBuildings1Autocomplete() {

        Autocomplete autocomplete = setupFile("pu-buildings.txt");
        Term[] matches = autocomplete.allMatches("Nassau H");
        System.out.println(Arrays.toString(matches));
        Assertions.assertEquals(1, matches.length);
        Assertions.assertEquals("Nassau Hall", matches[0].getQuery());
    }

    @Test
    void testMetalAlbumsAutocomplete() {

        Autocomplete autocomplete = setupFile("metal-albums.txt");
        Term[] matches = autocomplete.allMatches("Metallica");
        System.out.println(Arrays.toString(matches));
        Assertions.assertEquals(23, matches.length);
        Assertions.assertEquals("Metallica - Master Of Puppets (1986)", matches[0].getQuery());
        Assertions.assertEquals("Metallica - Ride The Lightning (1984)", matches[1].getQuery());
        Assertions.assertEquals("Metallica - ...And Justice For All (1988)", matches[2].getQuery());
        Assertions.assertEquals("Metallica - Metallica (1991)", matches[3].getQuery());
        Assertions.assertEquals("Metallica - Kill 'Em All (1983)", matches[4].getQuery());
        Assertions.assertEquals("Metallica - Death Magnetic (2008)", matches[5].getQuery());
        Assertions.assertEquals("Metallica - St. Anger (2003)", matches[6].getQuery());
        Assertions.assertEquals("Metallica - Load (1996)", matches[7].getQuery());
        Assertions.assertEquals("Metallica - Re-Load (1997)", matches[8].getQuery());
        Assertions.assertEquals("Metallica - S&M (1999)", matches[9].getQuery());
        Assertions.assertEquals("Metallica - Lulu [Collaboration] (2011)", matches[10].getQuery());
        Assertions.assertEquals("Metallica - Garage Inc. (1998)", matches[11].getQuery());
        Assertions.assertEquals("Metallica - Beyond Magnetic (2011)", matches[12].getQuery());
        Assertions.assertEquals("Metallica - Garage Days Re-Revisited (1987)",
                                matches[13].getQuery());
        Assertions.assertEquals("Metallica - S&M (1999)", matches[14].getQuery());
        Assertions.assertEquals("Metallica - Creeping Death (1984)", matches[15].getQuery());
        Assertions.assertEquals("Metallica - Live Shit: Binge & Purge (1993)",
                                matches[16].getQuery());
        Assertions.assertEquals("Metallica - Some Kind Of Monster (2005)", matches[17].getQuery());
        Assertions.assertEquals("Metallica - Cunning Stunts (1998)", matches[18].getQuery());
        Assertions.assertEquals("Metallica - The Videos 1989-2004 (2006)", matches[19].getQuery());
        Assertions.assertEquals("Metallica - Some Kind Of Monster (2004)", matches[20].getQuery());
        Assertions.assertEquals("Metallica - Cliff 'Em All! (1987)", matches[21].getQuery());
        Assertions.assertEquals("Metallica - Live Shit: Binge & Purge (1993)",
                                matches[22].getQuery());
    }

    @Test
    void testrecipesAutocomplete() {

        Autocomplete autocomplete = setupFile("automation_recipes.csv");
        Term[] matches = autocomplete.allMatches("Fettuccine Alfre");
        System.out.println(Arrays.toString(matches));
        Assertions.assertEquals(5, matches.length);
        Assertions.assertEquals("Fettuccine Alfredo", matches[0].getQuery());
        Assertions.assertEquals("Fettuccine Alfredo (Lighter Version)", matches[1].getQuery());
        Assertions.assertEquals("Fettuccine Alfredo with Zucchini Ribbons", matches[2].getQuery());
        Assertions.assertEquals("Fettuccine Alfredo Pie", matches[3].getQuery());
        Assertions.assertEquals("Fettuccine Alfredo with Veggies", matches[4].getQuery());
    }

}