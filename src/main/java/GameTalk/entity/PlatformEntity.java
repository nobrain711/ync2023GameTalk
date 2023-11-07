package GameTalk.entity;

import GameTalk.entity.joinEntity.GameGenreEntity;
import GameTalk.entity.joinEntity.GamePlatformEntity;
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
@Table(name = "platforms", schema = "YNC")
@SequenceGenerator(name = "platform_seq", sequenceName = "platform_seq",
        allocationSize = 1, schema = "YNC")
public class PlatformEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "platform_seq")
    @Column(name = "platform_id")
    private Long platformId;

    @Column(name = "name", unique = true)
    private String  name;

    @OneToMany(mappedBy = "platforms")
    private List<GamePlatformEntity> gamePlatform;
}
