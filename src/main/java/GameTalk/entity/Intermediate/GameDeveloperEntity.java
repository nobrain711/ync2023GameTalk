package GameTalk.entity.Intermediate;

import GameTalk.entity.DeveloperEntity;
import GameTalk.entity.GameEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "game_developer")
public class GameDeveloperEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;

    @Id
    @ManyToOne
    @JoinColumn(name = "developer_id")
    private DeveloperEntity developer;
}
