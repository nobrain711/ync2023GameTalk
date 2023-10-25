package GameTalk.entity;


import GameTalk.entity.joinEntity.GameDeveloperEntity;
import GameTalk.entity.joinEntity.GameGenreEntity;
import GameTalk.entity.joinEntity.GamePlatformEntity;
import GameTalk.entity.joinEntity.GamePublisherEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table(name = "games",
        indexes = {@Index(name = "idx_games_release_date", columnList = "release_date")},
        schema = "YNC")
@SequenceGenerator(name = "game_seq", sequenceName = "game_seq", schema = "YNC", allocationSize = 1)
public class GamesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "title", nullable = false, unique = true, length = 138)
    private String title;

    @Lob
    @Column(name = "instructions")
    private String info;

    @Column(name = "release_date")
    private LocalDate relesaeDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id")
    private SeriesEntity series;

    @OneToMany(mappedBy = "games", fetch = FetchType.LAZY )
    private List<GameGenreEntity> gameGenre;

    @OneToMany(mappedBy = "games", fetch = FetchType.LAZY )
    private List<GamePublisherEntity> gamePublisher;

    @OneToMany(mappedBy = "games", fetch = FetchType.LAZY)
    private List<GameDeveloperEntity> gameDeveloper;

    @OneToMany(mappedBy = "games", fetch = FetchType.LAZY )
    private List<GamePlatformEntity> gamePlatform;
}
