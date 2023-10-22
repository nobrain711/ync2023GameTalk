package GameTalk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "publishers", schema = "YNC")
@SequenceGenerator(name = "publisher_seq",
        sequenceName = "publisher_seq", allocationSize = 1)
public class PublishersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_seq")
    @Column(name = "publisher_id")
    private Long publisherId;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "url")
    private String url;

    @ManyToMany(mappedBy = "publisher")
    private List<GamesEntity> games;
}
