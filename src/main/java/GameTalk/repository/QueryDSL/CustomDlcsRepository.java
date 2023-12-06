package GameTalk.repository.QueryDSL;

import GameTalk.entity.GamesEntity;

import java.util.List;

public interface CustomDlcsRepository {
    List<GamesEntity> findByChildGames(GamesEntity parentGame);

    GamesEntity findByParentGame(GamesEntity childGame);
}
