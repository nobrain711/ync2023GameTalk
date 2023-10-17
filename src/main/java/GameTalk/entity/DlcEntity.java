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
@Table(name = "dlcs")
@SequenceGenerator(name = "dlc_seq", sequenceName = "dlc_seq", allocationSize = 1)
public class DlcEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dlc_seq")
    private Long dlcId;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;
    private String title;
    private String instructions;
    private LocalDate releaseDate;
}
