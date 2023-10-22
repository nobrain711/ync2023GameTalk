package GameTalk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "geners", schema = "YNC")
@SequenceGenerator(name = "gener_seq", sequenceName = "gener_seq", allocationSize = 1)
public class GenersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gener_seq")
    @Column(name = "gener_id")
    private Long generId;

    @Column(name = "name", unique = true)
    private String name;

    @ManyToMany(mappedBy = "geners")
    private List<GamesEntity> games;
}
