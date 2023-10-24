package GameTalk.repository;

import GameTalk.entity.joinentity.GameGenreEntity;
import GameTalk.entity.joinentity.idclass.GameGenreEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameGenerReposotiory extends JpaRepository<GameGenreEntity, GameGenreEntityId> {
}
