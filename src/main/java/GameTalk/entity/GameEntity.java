package GameTalk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@Entity
@ToString
@Table(name = "games")
@SequenceGenerator(name = "game_seq", sequenceName = "game_seq", allocationSize = 1)
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "title", unique = true, nullable = false, length = 138)
    private String title;

    @Lob
    @Column(name = "instructions", nullable = false)
    private String instructions;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @ManyToMany(mappedBy = "game")
    private List<GenersEntity> genre;

    @ManyToMany(mappedBy = "game")
    private List<DeveloperEntity> developer;

    @ManyToMany(mappedBy = "game")
    private List<PublisherEntity> publisher;

    @ManyToMany(mappedBy = "game")
    private List<ImageEntity> image;

    @ManyToMany(mappedBy = "game")
    private List<TrallerEntity> traller;
}
