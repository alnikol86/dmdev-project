package src.homeWorkFive.collectionsPartTwo.task1;

/**
 * Даны 2 класса:
 *
 * - Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания, Жанр и Рейтинг;
 *
 * - Кинотеатр, где есть всего лишь одно единственное поле: отсортированный ассоциативный массив,
 * где ключом является год издания, а значением - все фильмы, выпустившиеся в этом году.
 *
 * Добавить функционал в кинотеатр таким образом, чтобы можно было:
 *
 * - добавлять в него новый фильм
 *
 * - получить все фильмы по переданному году
 *
 * - получить все фильмы по переданному году и месяцу
 *
 * - получить все фильмы по переданному жанру
 *
 * - получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания
 *
 * Учесть следующее:
 *
 * - в кинотеатре фильмы должны храниться в порядке их добавления в него (т.е. предусмотреть порядок значения ассоциативного массива)
 *
 * - не должен добавляться фильм, если такой уже есть в кинотеатре
 *
 * Продемонстрировать работу кинотеатра в отдельном классе.
 */
public class CinemaManager {
    public static void main(String[] args) {
        // Создаем кинотеатр
        Cinema cinema = new Cinema();

        // Пример добавления фильмов
        cinema.addFilm(new Film(1, 2022, 7, "Drama", 8.5));
        cinema.addFilm(new Film(2, 2022, 5, "Action", 9.0));
        cinema.addFilm(new Film(3, 2023, 1, "Comedy", 7.5));
        cinema.addFilm(new Film(4, 2023, 7, "Action", 8.8));
        cinema.addFilm(new Film(5, 2023, 7, "Drama", 9.1));
        cinema.addFilm(new Film(6, 2022, 11, "Thriller", 8.3));

        // Попытка добавить дубликат фильма
        cinema.addFilm(new Film(2, 2022, 5, "Action", 9.0)); // Фильм уже существует

        // Получить фильмы по году
        System.out.println("Movies 2022: " + cinema.getFilmsByYear(2022));

        // Получить фильмы по году и месяцу
        System.out.println("Movies July 2023: " + cinema.getFilmsByYearAndMonth(2023, 7));

        // Получить фильмы по жанру
        System.out.println("Action Movies: " + cinema.getFilmsByGenre("Action"));

        // Получить ТОП-10 фильмов по рейтингу
        System.out.println("TOP 10 Movies by Rating: " + cinema.getTop10FilmsByRating());
    }
}
