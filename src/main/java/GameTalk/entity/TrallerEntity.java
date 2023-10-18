package GameTalk.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Builder
@Table(name = "trallers")
@SequenceGenerator(name = "traller_id", sequenceName = "traller_seq", allocationSize = 1)
public class TrallerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "traller_seq")
    @Column(name = "traller_id")
    private Long trallerId;

    @Column(name = "url", length = 255, nullable = false)
    private String url;
}
