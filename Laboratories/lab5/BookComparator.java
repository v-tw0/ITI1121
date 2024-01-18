import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    public int compare(Book a, Book b) {
        int compareAuthors = a.getAuthor().compareTo(b.getAuthor());

        if ( compareAuthors == 0 ) {
            int compareTitles = a.getTitle().compareTo(b.getTitle());

            if ( compareTitles == 0 ) {
                if (a.getYear() < b.getYear()) {
                    return -1;
                }
                else if (a.getYear() > b.getYear()) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
            return compareTitles;
        }
        return compareAuthors;
    }

}
