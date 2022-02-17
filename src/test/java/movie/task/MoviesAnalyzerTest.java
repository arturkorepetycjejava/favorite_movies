package movie.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;


import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


class MoviesAnalyzerTest {
    private List<Movie> movies;
    private List<User> users;

    @BeforeEach
    public void setUp() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        final Movie[] moviesArray = objectMapper.readValue(new File("src/main/resources/movies.json"), Movie[].class);
        movies = Arrays.stream(moviesArray).collect(Collectors.toList());

        final User[] usersArray = objectMapper.readValue(new File("src/main/resources/users.json"), User[].class);
        users = Arrays.stream(usersArray).collect(Collectors.toList());
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void shouldReturnTop3ForFirstUser() {
        //given
        MoviesAnalyzer moviesAnalyzer = new MoviesAnalyzer(movies, users);

        //when
        List<String> titles = moviesAnalyzer.topFavouriteMoviesAmongFriends(15291);

        //then
        assertEquals(List.of("Pulp Fiction", "The Godfather", "The Dark Knight"), titles);
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void shouldReturnTop3ForSecondUser() {
        //given
        MoviesAnalyzer moviesAnalyzer = new MoviesAnalyzer(movies, users);

        //when
        List<String> titles = moviesAnalyzer.topFavouriteMoviesAmongFriends(7001);

        //then
        assertEquals(List.of("Pulp Fiction", "The Godfather", "The Dark Knight"), titles);
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void shouldReturnTop3ForThirdUser() {
        //given
        MoviesAnalyzer moviesAnalyzer = new MoviesAnalyzer(movies, users);

        //when
        List<String> titles = moviesAnalyzer.topFavouriteMoviesAmongFriends(51417);

        //then
        assertEquals(List.of("The Dark Knight", "The Godfather", "The Shawshank Redemption"), titles);
    }
}