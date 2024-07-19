public class Main {
    public static void main(String[] args) {
        Author levTolstoy = new Author("Lev", "Tolstoy", 7);
        Author alexeyPekhov = new Author("Alexey", "Pekhov", 6);

        Book warAndPeace = new Book("War and peace", 1867, levTolstoy, 1300);
        Book blueFire = new Book("Blue fire", 2015, alexeyPekhov, le);
        System.out.println("War and peace is big " + warAndPeace.isBig());
        System.out.println("Blue fire is big " + blueFire.isBig());

        System.out.println("War and peace is matches word Lev " + warAndPeace.matches("Lev"));
        System.out.println("Blue fire is matches word Lev " + blueFire.matches("Lev"));

        System.out.println("War and peace cost is " + warAndPeace.estimatePrice(levTolstoy.rating));
        System.out.println("Blue fire cost is " + blueFire.estimatePrice(alexeyPekhov.rating));
    }
}
