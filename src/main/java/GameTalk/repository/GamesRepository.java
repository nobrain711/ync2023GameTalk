package GameTalk.repository;

import GameTalk.entity.GamesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GamesRepository extends JpaRepository<GamesEntity, Long> {
    Optional<GamesEntity> findByTitleContaining(String title);


}
