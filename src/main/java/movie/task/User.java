package movie.task;

import lombok.Data;

import java.util.List;

@Data
class User {

    private int userId;
    private String email;
    private List<Integer> friends;
}
