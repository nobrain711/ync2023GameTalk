package GameTalk.entity.joinEntity;

import GameTalk.entity.GamesEntity;
import GameTalk.entity.GenresEntity;
import GameTalk.entity.idclass.GameGenreEntityId;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "game_genre", schema = "YNC",
        indexes = {@Index(name = "idx_gg_game_id", columnList = "game_id"),
                @Index(name = "idx_gg_genre_id", columnList = "genre_id")})
@IdClass(GameGenreEntityId.class)
public class GameGenreEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "game_id")
    private GamesEntity games;

    @Id
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenresEntity genres;
}
