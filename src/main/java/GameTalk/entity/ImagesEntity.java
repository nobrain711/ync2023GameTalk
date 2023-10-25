package GameTalk.entity;

import GameTalk.entity.joinEntity.GamePlatformEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "images", schema = "YNC",
        indexes = {@Index(name = "idx_images_game_id", columnList = "game_id"),
                @Index(name = "idx_images_primary_status", columnList = "primary_status")})
@SequenceGenerator(name = "image_seq", sequenceName = "image_seq",allocationSize = 1, schema = "YNC")
public class ImagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_seq")
    @Column(name = "image_id")
    private Long imageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private GamesEntity games;

    // store File root
    @Column(name = "url")
    private String url;

    @Column(name = "primary_status")
    private Boolean primaryStatus;
}
