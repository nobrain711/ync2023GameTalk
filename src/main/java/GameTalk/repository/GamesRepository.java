package GameTalk.repository;

import GameTalk.entity.GamesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends JpaRepository<GamesEntity, Long> {
    GamesEntity findByTitle(String title);

    @Query("SELECT game.gameId " +
            "FROM GamesEntity game " +
            "WHERE game.title = :title ")
    Long getGameIdByTitle(@Param("title") String title);
}
