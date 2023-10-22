package GameTalk.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "series", schema = "YNC")
@SequenceGenerator(name = "series_seq", sequenceName = "series_seq",
        allocationSize = 1, initialValue = 1)
public class SeriesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "series_seq")
    @Column(name = "series_id")
    private Long sericeId;

    @Column(name = "name", unique = true)
    private String name;
}
