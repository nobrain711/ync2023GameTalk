package GameTalk.entity;

import GameTalk.entity.joinentity.GameGenreEntity;
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
@Table(name = "geners", schema = "YNC")
@SequenceGenerator(name = "gener_seq", sequenceName = "gener_seq", allocationSize = 1, schema = "YNC")
public class GenresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gener_seq")
    @Column(name = "gener_id")
    private Long generId;

    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "geners")
    private List<GameGenreEntity> gameGener;
}
