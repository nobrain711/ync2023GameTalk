package GameTalk.entity.idclass;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
public class DlcsEntityId implements Serializable {
    private Long parentGame;
    private Long childGame;

    @Override
    public int hashCode() {
        return Objects.hash(parentGame, childGame);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        DlcsEntityId that = (DlcsEntityId) obj;
        return Objects.equals(parentGame, that.parentGame) &&
                Objects.equals(childGame, that.childGame);
    }
}
