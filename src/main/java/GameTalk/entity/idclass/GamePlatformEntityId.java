package GameTalk.entity.idclass;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
public class GamePlatformEntityId implements Serializable {
    private Long games;
    private Long platforms;

    @Override
    public int hashCode() {
        return Objects.hash(games, platforms);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        GamePlatformEntityId that = (GamePlatformEntityId) obj;
        return Objects.equals(games, that.games) &&
                Objects.equals(platforms, that.platforms);
    }
}
