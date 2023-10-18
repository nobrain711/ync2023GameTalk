package GameTalk.entity;

import GameTalk.entity.Intermediate.GamePublisherEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@ToString
@Entity
@Table(name = "publisher")
@SequenceGenerator(name = "publisher_seq",
        sequenceName = "publisher_seq",
        allocationSize = 1)
public class PublisherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_seq")
    @Column(name = "publisher_id")
    private Long publisherId;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "publisher")
    private List<GamePublisherEntity> gamePublisher;
}
