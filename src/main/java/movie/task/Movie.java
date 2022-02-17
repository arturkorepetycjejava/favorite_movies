package movie.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Movie {
    private String title;
    private String duration;
    private List<String> actors;
    private List<Rating> ratings;
    private List<Integer> favorites;
    @JsonProperty(value = "watchlist")
    private List<Integer> watchList;

}
