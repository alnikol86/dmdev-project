package src.homeWorkFive.collectionsPartTwo.task1;

public class Film {
    private Integer id;
    private Integer year;
    private Integer month;
    private String genre;
    private Double rating;

    public Film(int id, int year, int month, String genre, double rating) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.genre = genre;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Film{id=" + id + ", year=" + year + ", month=" + month + ", genre='" + genre + "', rating=" + rating + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (id != film.id) return false;
        if (year != film.year) return false;
        if (month != film.month) return false;
        if (Double.compare(film.rating, rating) != 0) return false;
        return genre.equals(film.genre);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + year;
        result = 31 * result + month;
        result = 31 * result + genre.hashCode();
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
