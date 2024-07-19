public class Book {
    public static int BIG_BOOK_SIZE = 500;
    public static int PAGE_COST = 3;
    public static int MIN_BOOK_COST = 250;
    public String title;
    public int releaseYear;
    public Author author;
    public int pages;

    public Book(String title, int releaseYear, Author author, int pages) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
        this.pages = pages;
    }

    public boolean isBig() {
        return this.pages > BIG_BOOK_SIZE;
    }

    public boolean matches(String word) {
        String authorFullName = this.author.name + " " + this.author.surname;
        return this.title.contains(word) || authorFullName.contains(word);
    }

    public int estimatePrice(int rating) {
        int ratingBonus = (int) Math.floor(Math.sqrt(rating));
        int bookCost = this.pages * PAGE_COST * ratingBonus;
        return bookCost < MIN_BOOK_COST ? MIN_BOOK_COST : bookCost;
    }

}
