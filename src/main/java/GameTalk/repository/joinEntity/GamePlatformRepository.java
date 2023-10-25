package GameTalk.repository.joinEntity;

import GameTalk.entity.idclass.GamePlatformEntityId;
import GameTalk.entity.joinEntity.GamePlatformEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamePlatformRepository extends JpaRepository<GamePlatformEntity, GamePlatformEntityId> {
}
