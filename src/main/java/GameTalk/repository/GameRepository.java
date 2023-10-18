package GameTalk.repository;

import GameTalk.entity.GameEntity;
import GameTalk.entity.GenersEntity;
import org.hibernate.mapping.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Long> {
    @Query("SELECT game.gameId " +
            "FROM GameEntity game " +
            "WHERE game.title = :title")
    Long findByGameIdForTitle(@Param("title") String title);

    GameEntity findByTitle(String title);

    GameEntity findByGameId(Long gameId);


}
