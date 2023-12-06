package GameTalk.repository.joinEntity;

import GameTalk.entity.GamesEntity;
import GameTalk.entity.joinEntity.DlcsEntity;
import GameTalk.repository.GamesRepository;
import GameTalk.repository.QueryDSL.CustomGameRepositoryImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DlcsRepositoryTest {
    @Autowired
    private GamesRepository gamesRepository;
    @Autowired
    private DlcsRepository dlcsRepository;
    @Autowired
    private CustomGameRepositoryImpl customGameRepository;

    @Test
    void dlcInsert() {
        GamesEntity parentGame = gamesRepository.findByGameId(6L);
        GamesEntity childGame = gamesRepository.findByGameId(7L);
        System.out.println("entity: " + childGame.getGameId());
        System.out.println("entity: " + parentGame.getGameId());
        DlcsEntity build = DlcsEntity.builder()
                .parentGame(parentGame)
                .childGame(childGame)
                .build();
        System.out.println("Build: " + build.getParentGame().getGameId());
        System.out.println("Build: " + build.getChildGame().getGameId());
        DlcsEntity save = dlcsRepository.save(build);

        System.out.println("save: " + save.getChildGame().getGameId());
        System.out.println("save: " + save.getParentGame().getGameId());
    }

    @Test
    @Transactional
    void showChiled() {
        GamesEntity parentGame = gamesRepository.findByGameId(6L);

        List<GamesEntity> childGames = customGameRepository.findByChildGames(parentGame);

        for (GamesEntity childGame : childGames) {
            System.out.println(childGame.getGameId());
        }
    }

    @Test
    @Transactional
    void showParent(){
        GamesEntity childGame = gamesRepository.findByGameId(7L);

        GamesEntity parentGame = customGameRepository.findByParentGame(childGame);

        System.out.println(parentGame.getGameId());
    }
}