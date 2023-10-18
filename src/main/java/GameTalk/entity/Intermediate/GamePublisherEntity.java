package GameTalk.entity.Intermediate;

import GameTalk.entity.GameEntity;
import GameTalk.entity.PublisherEntity;
import GameTalk.entity.key.GamePublisherKey;
import jakarta.persistence.*;


@Entity
@Table(name = "game_publisher")
@IdClass(GamePublisherKey.class)
public class GamePublisherEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;

    @Id
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisher;
}
