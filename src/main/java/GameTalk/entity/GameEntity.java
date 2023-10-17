package GameTalk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


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
    private Long gameId;
    private String title;
    private String instructions;
    private LocalDate releaseDate;
}
