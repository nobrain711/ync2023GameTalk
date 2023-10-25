package GameTalk.entity.joinEntity;

import GameTalk.entity.DevelopersEntity;
import GameTalk.entity.GamesEntity;
import GameTalk.entity.idclass.GameDeveloperEntityId;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(GameDeveloperEntityId.class)
@Table(name = "game_developer", schema = "YNC",
        indexes = {@Index(name = "idx_gd_game_id", columnList = "game_id"),
                @Index(name = "idx_gd_developer_id", columnList = "developer_id")})
public class GameDeveloperEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private GamesEntity games;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_id")
    private DevelopersEntity developers;
}
