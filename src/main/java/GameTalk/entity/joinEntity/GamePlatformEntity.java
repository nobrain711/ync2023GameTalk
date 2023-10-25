package GameTalk.entity.joinEntity;


import GameTalk.entity.GamesEntity;
import GameTalk.entity.PlatformEntity;
import GameTalk.entity.idclass.GamePlatformEntityId;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "game_platform", schema = "YNC",
        indexes = {@Index(name = "idx_gpf_game_id", columnList = "game_id"),
                @Index(name = "idx_gpf_platform_id", columnList = "platform_id")})
@IdClass(GamePlatformEntityId.class)
public class GamePlatformEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private GamesEntity games;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platform_id")
    private PlatformEntity platforms;
}