package GameTalk.entity.key;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
public class GameGenreKey implements Serializable {
    @Id
    private Long gameId;
    @Id
    private Long generId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameGenreKey that = (GameGenreKey) o;
        return Objects.equals(gameId, that.gameId) &&
                Objects.equals(generId, that.generId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, generId);
    }
}
