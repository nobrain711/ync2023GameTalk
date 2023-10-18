package GameTalk.entity;

import GameTalk.entity.Intermediate.GameDeveloperEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
@Table(name = "developers")
@Entity
@SequenceGenerator(name = "developer_seq", sequenceName = "developer_seq", allocationSize = 1)
public class DeveloperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "developer_seq")
    private Long developerId;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "developers")
    private List<GameDeveloperEntity> gameDeveloper;
}
