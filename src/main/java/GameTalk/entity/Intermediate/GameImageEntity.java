package GameTalk.entity.Intermediate;

import GameTalk.entity.GameEntity;
import GameTalk.entity.ImageEntity;
import GameTalk.entity.key.GameImageKey;
import jakarta.persistence.*;

@Entity
@Table(name = "game_image")
@IdClass(GameImageKey.class)
public class GameImageEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;

    @Id
    @ManyToOne
    @JoinColumn(name = "image_id")
    private ImageEntity image;
}
