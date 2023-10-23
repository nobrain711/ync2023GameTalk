package GameTalk.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "trallers", schema = "YNC",
indexes = @Index(name = "idx_trallers_game_id", columnList = "game_id"))
@SequenceGenerator(name = "traller_seq", sequenceName = "traller_seq",
        allocationSize = 1, schema = "YNC")
public class TrallersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "traller_seq")
    @Column(name = "traller_id")
    private Long trallerId;

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "game_id",
            insertable = false, updatable = false)
    private GamesEntity games;

    @Column(name = "url")
    private String url;
}
