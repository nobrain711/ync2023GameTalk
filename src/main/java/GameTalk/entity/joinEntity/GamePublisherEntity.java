package GameTalk.entity.joinEntity;

import GameTalk.entity.GamesEntity;
import GameTalk.entity.PublishersEntity;
import GameTalk.entity.idclass.GamePublisherEntityId;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "game_publisher", schema = "YNC",
        indexes = {@Index(name = "idx_gpb_game_id", columnList = "game_id"),
                @Index(name = "idx_gpb_publisher_id", columnList = "publisher_id")})
@IdClass(GamePublisherEntityId.class)
public class GamePublisherEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "game_id")
    private GamesEntity games;

    @Id
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublishersEntity publishers;
}
