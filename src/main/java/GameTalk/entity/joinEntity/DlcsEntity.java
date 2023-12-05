package GameTalk.entity.joinEntity;

import GameTalk.entity.GamesEntity;
import GameTalk.entity.idclass.DlcsEntityId;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DLCS", schema = "YNC",
        indexes = {@Index(name = "idx_dlcs_parent_game", columnList = "parent_game"),
                @Index(name = "idx_dlcs_child_game", columnList = "child_game")})
@IdClass(DlcsEntityId.class)
public class DlcsEntity {
    @Id
    @ManyToOne(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_game", referencedColumnName = "game_id")
    private GamesEntity parentGame;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "child_game", referencedColumnName = "game_id")
    private GamesEntity childGame;
}
