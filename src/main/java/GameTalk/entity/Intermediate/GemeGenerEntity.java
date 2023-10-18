package GameTalk.entity.Intermediate;

import GameTalk.entity.GameEntity;
import GameTalk.entity.GenersEntity;
import GameTalk.entity.key.GameGenreKey;
import jakarta.persistence.*;

@Entity
@Table(name = "game_gener")
@IdClass(GameGenreKey.class)
public class GemeGenerEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;

    @Id
    @ManyToOne
    @JoinColumn(name = "gener_id")
    private GenersEntity geners;
}
