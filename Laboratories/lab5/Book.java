public class Book {

    private String author;
    private String title;
    private int year;

    public Book (String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean equals(Object other) {
        if( other == null || getClass() != other.getClass()){
            return false; 
        }

        Book o = (Book) other; 
        if(year != o.year) { 
            return false; 
        }

        if(title == null) { 
            if(o.title != null) { 
                return false;
            }
        }else if(!title.equals(o.title)) { 
            return false;
        }

        if(author == null) { 
            if(o.author != null) { 
                return false;
            }
        } else if(!author.equals(o.author)) { 
            return false;
        }

        return true; 
    }

    public String toString() {
        return (author + ": " + title + " (" + year + ")");
    }
}
