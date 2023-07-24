package peaksoft;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import peaksoft.model.Movie;
import peaksoft.model.ShowTime;
import peaksoft.service.MovieService;
import peaksoft.service.ShowTimeService;
import peaksoft.service.impl.MovieServiceImpl;
import peaksoft.service.impl.ShowTimeServiceImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        MovieService movieService = new MovieServiceImpl();
        ShowTimeService showTimeService = new ShowTimeServiceImpl();

//        System.out.println(
//                movieService.createMovie(
//                        "show_times",
//                        List.of(
//                                "id serial primary key",
//                                "movie_id int references movies (id)",
//                                "theatre_id int references theatres (id)",
//                                "start_time timestamp",
//                                "end_time timestamp"
//                        )
//                )
//        );

        Scanner scannerForStr = new Scanner(System.in);
        Scanner scannerForNumber = new Scanner(System.in);

        while (true) {
            switch (new Scanner(System.in).nextLine()) {
                case "save" -> {
                    System.out.println("write title: ");
                    String title = scannerForStr.nextLine();
                    System.out.println("write genre: ");
                    String genre = scannerForStr.nextLine();
                    System.out.println("write duration: ");
                    int duration = scannerForNumber.nextInt();
                    System.out.println(movieService.saveMovie(new Movie(title, genre, duration)));
                }
                case "find" -> {
                    System.out.println("write movie id: ");
                    System.out.println(movieService.findMovieById(scannerForNumber.nextLong()));
                }
                case "3" -> {
                    String save = showTimeService.save(
                            new ShowTime(
                                    3L, 1L,
                                    LocalDateTime.of(2023, 7, 21, 13, 30, 0),
                                    LocalDateTime.of(2023, 7, 21, 16, 12, 0)));
                    System.out.println(save);
                }
            }
        }


    }
}
