package GameTalk.entity.Intermediate;

import GameTalk.entity.GameEntity;
import GameTalk.entity.TrallerEntity;
import GameTalk.entity.key.GameTrallerKey;
import jakarta.persistence.*;

@Table(name = "game_traller")
@Entity
@IdClass(GameTrallerKey.class)
public class GameTrallerEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;

    @Id
    @ManyToOne
    @JoinColumn(name = "traller_id")
    private TrallerEntity traller;
}
