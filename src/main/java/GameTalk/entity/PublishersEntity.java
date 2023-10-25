package GameTalk.entity;

import GameTalk.entity.joinEntity.GamePublisherEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "publishers", schema = "YNC")
@SequenceGenerator(name = "publisher_seq", sequenceName = "publisher_seq",
        allocationSize = 1, schema = "YNC")
public class PublishersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_seq")
    @Column(name = "publisher_id")
    private Long publisher_id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "publishers")
    private List<GamePublisherEntity> gamePublisher;
}
