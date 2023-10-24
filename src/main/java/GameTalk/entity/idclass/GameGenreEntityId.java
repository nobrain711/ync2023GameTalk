package GameTalk.entity.idclass;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class GameGenreEntityId implements Serializable {
    private Long games;
    private Long genres;

    @Override
    public int hashCode() {
        return Objects.hash(games, genres);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj == null || getClass() != obj.getClass())
            return false;

        GameGenreEntityId that = (GameGenreEntityId) obj;
        return Objects.equals(games, that.games) &&
                Objects.equals(genres, that.genres);
    }
}