package src.homeWorkFive.collectionsPartTwo.task1;

import java.util.*;
import java.util.stream.Collectors;

public class Cinema {
    private TreeMap<Integer, LinkedHashSet<Film>> filmsByYear = new TreeMap<>();

    // Добавление нового фильма
    public boolean addFilm(Film film) {
        // Проверяем, существует ли уже год
        LinkedHashSet<Film> filmsForYear = filmsByYear.get(film.getYear());

        if (filmsForYear == null) {
            // Если года нет, создаем новый LinkedHashSet и добавляем его
            filmsForYear = new LinkedHashSet<>();
            filmsByYear.put(film.getYear(), filmsForYear);
        } else {
            // Проверяем, есть ли уже фильм с таким id
            for (Film existingFilm : filmsForYear) {
                if (existingFilm.getId() == film.getId()) {
                    System.out.println("Film with id " + film.getId() + " already exists.");
                    return false; // Фильм уже существует
                }
            }
        }

        // Добавляем фильм
        filmsForYear.add(film);
        return true;
    }

    // Получить все фильмы по году
    public Set<Film> getFilmsByYear(int year) {
        return filmsByYear.getOrDefault(year, new LinkedHashSet<>());
    }

    // Получить все фильмы по году и месяцу
    public Set<Film> getFilmsByYearAndMonth(int year, int month) {
        // Получаем фильмы за указанный год, если их нет, возвращаем пустой набор
        Set<Film> filmsForYear = filmsByYear.getOrDefault(year, new LinkedHashSet<>());

        // Создаем набор для фильмов, соответствующих указанному месяцу
        Set<Film> result = new HashSet<>();

        // Проходим по всем фильмам за указанный год
        for (Film film : filmsForYear) {
            // Если месяц совпадает, добавляем фильм в результат
            if (film.getMonth() == month) {
                result.add(film);
            }
        }

        return result;
    }

    // Получить все фильмы по жанру
    public Set<Film> getFilmsByGenre(String genre) {
        // Создаем набор для результатов
        Set<Film> result = new HashSet<>();

        // Проходим по всем наборам фильмов за каждый год
        for (Set<Film> films : filmsByYear.values()) {
            // Итерируем по каждому фильму в наборе
            for (Film film : films) {
                // Если жанр совпадает, добавляем фильм в результат
                if (film.getGenre().equalsIgnoreCase(genre)) {
                    result.add(film);
                }
            }
        }

        return result;
    }

    // Получить ТОП-10 фильмов по рейтингу
    public List<Film> getTop10FilmsByRating() {
        // Создаем список для всех фильмов
        List<Film> allFilms = new ArrayList<>();

        // Проходим по всем наборам фильмов за каждый год
        for (Set<Film> films : filmsByYear.values()) {
            // Добавляем все фильмы в общий список
            allFilms.addAll(films);
        }

        // Сортируем список по рейтингу в порядке убывания
        allFilms.sort(new Comparator<Film>() {
            @Override
            public int compare(Film f1, Film f2) {
                return Double.compare(f2.getRating(), f1.getRating()); // Сортировка по убыванию
            }
        });

        // Возвращаем первые 10 фильмов из отсортированного списка (если их меньше 10, то возвращаем все)
        return allFilms.size() > 10 ? allFilms.subList(0, 10) : allFilms;
    }
}
