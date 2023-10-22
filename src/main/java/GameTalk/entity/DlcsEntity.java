package GameTalk.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dlcs", schema = "YNC")
public class DlcsEntity {
    @Id
    @Column(name = "perent_game")
    private Long perentGameId;

    @Id
    @Column(name = "chiled_game")
    private Long chiledGameId;

    @ManyToOne
    @JoinColumn(name = "perent_game", referencedColumnName = "game_id",
            insertable = false, updatable = false)
    private GamesEntity perentGame;

    @ManyToOne
    @JoinColumn(name = "chiled_game", referencedColumnName = "game_id",
            insertable = false, updatable = false)
    private GamesEntity chiledGame;
}
