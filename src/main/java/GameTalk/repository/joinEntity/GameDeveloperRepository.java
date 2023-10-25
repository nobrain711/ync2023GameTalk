package GameTalk.repository.joinEntity;

import GameTalk.entity.idclass.GameDeveloperEntityId;
import GameTalk.entity.joinEntity.GameDeveloperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDeveloperRepository extends JpaRepository<GameDeveloperEntity, GameDeveloperEntityId> {
}
