package GameTalk.repository;

import GameTalk.entity.DlcEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DlcRepostiory extends JpaRepository<DlcEntity, Long> {
    @Query("SELECT d.dlcId AS DLC_ID, " +
            "g.title AS GAME_TITLE, " +
            "d.title AS DLE_TITLE, " +
            "d.instructions " +
            "FROM DlcEntity d " +
            "INNER JOIN GameEntity g ON d.game.gameId = g.gameId " +
            "WHERE d.dlcId = :dlcId")
    List<Object[]> findByDlcId(@Param("dlcId") Long dlcId);

}
