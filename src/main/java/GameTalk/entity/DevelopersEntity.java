package GameTalk.entity;

import GameTalk.entity.joinEntity.GameDeveloperEntity;
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
@Table(name = "developers", schema = "YNC")
@SequenceGenerator(name = "developer_seq", sequenceName = "developer_seq",
        allocationSize = 1, schema = "YNC")
public class DevelopersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "developer_seq")
    @Column(name = "developer_id", nullable = false)
    private Long developerId;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "url")
    private String url;
}
