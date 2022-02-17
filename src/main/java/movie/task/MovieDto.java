package movie.task;


public class MovieDto implements Comparable<MovieDto> {
    private final String title;
    private final Integer votes;

    public MovieDto(String title, Integer votes) {
        this.title = title;
        this.votes = votes;
    }

    public String getTitle() {
        return title;
    }

    public Integer getVotes() {
        return votes;
    }

    @Override
    public int compareTo(MovieDto o) {
        int result = 0;
        result = -this.votes.compareTo(o.votes);
        if (result == 0) {
            result = this.title.compareTo(o.title);
        }
        return result;
    }
}
