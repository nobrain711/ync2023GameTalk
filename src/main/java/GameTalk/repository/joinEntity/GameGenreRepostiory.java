package GameTalk.repository.joinEntity;

import GameTalk.entity.joinEntity.GameGenreEntity;
import GameTalk.entity.idclass.GameGenreEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameGenreRepostiory extends JpaRepository<GameGenreEntity, GameGenreEntityId> {
}
