package GameTalk.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table(name = "games",
        indexes = {@Index(name = "idx_games_release_date", columnList = "relesaeDate")},
        schema = "YNC"
)
@SequenceGenerator(name = "game_seq", sequenceName = "game_seq", schema = "YNC")
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
    private Date relesaeDate;

    @ManyToMany
    @JoinTable(name = "game_gener", schema = "YNC",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "gener_id"))
    private List<GenersEntity> geners;

    @ManyToMany
    @JoinTable(name = "game_publisher", schema = "YNC",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "publisher_id"))
    private List<PublishersEntity> publishers;

    @ManyToMany
    @JoinTable(name = "game_developer", schema = "YNC",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id"))
    private List<DevelopersEntity> developers;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private SeriesEntity series;
}
