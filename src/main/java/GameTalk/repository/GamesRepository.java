package GameTalk.repository;

import GameTalk.entity.GamesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesRepository extends JpaRepository<GamesEntity, Long> {
    GamesEntity findByTitle(String title);
    GamesEntity findByGameId(Long id);
}
