package GameTalk.repository.joinEntity;

import GameTalk.entity.idclass.GamePublisherEntityId;
import GameTalk.entity.joinEntity.GamePublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamePublisherReposiory extends JpaRepository<GamePublisherEntity, GamePublisherEntityId> {
}
