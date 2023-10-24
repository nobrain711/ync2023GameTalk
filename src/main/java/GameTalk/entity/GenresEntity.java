package GameTalk.entity;

import GameTalk.entity.joinEntity.GameGenreEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "genres", schema = "YNC")
@SequenceGenerator(name = "genre_seq", sequenceName = "genre_seq", allocationSize = 1, schema = "YNC")
public class GenresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_seq")
    @Column(name = "genre_id")
    private Long genreId;

    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "genres")
    private List<GameGenreEntity> gameGenre;
}
