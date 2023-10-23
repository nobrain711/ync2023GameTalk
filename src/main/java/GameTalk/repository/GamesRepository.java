package GameTalk.repository;

import GameTalk.entity.GamesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends JpaRepository<GamesEntity, Long> {
}
