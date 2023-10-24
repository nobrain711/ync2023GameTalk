package GameTalk.entity.idclass;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
public class GamePublisherEntityId implements Serializable {
    private Long games;
    private Long publishers;

    @Override
    public int hashCode() {
        return Objects.hash(games, publishers);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        GamePublisherEntityId that = (GamePublisherEntityId) obj;
        return Objects.equals(games, that.games) &&
                Objects.equals(publishers, that.publishers);
    }
}
