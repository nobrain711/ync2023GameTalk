package GameTalk.repository.joinEntity;

import GameTalk.entity.GamesEntity;
import GameTalk.entity.PlatformEntity;
import GameTalk.entity.joinEntity.GamePlatformEntity;
import GameTalk.repository.GamesRepository;
import GameTalk.repository.PlatformRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GamePlatformRepositoryTest {
    @Autowired
    private GamePlatformRepository gamePlatformRepository;
    @Autowired
    private GamesRepository gamesRepository;
    @Autowired
    private PlatformRepository  platformRepository;

    //insert test
    @Test
    void insertTest(){
        GamesEntity gamesEntity = gamesRepository.findByTitle("Assassin's Creed\\u2122");
        List<String> list = Arrays.asList("PS3", "Xbox X360", "Xbox One" , "Xbox One X", "Windows");

        for(String platform: list){
            PlatformEntity entity = platformRepository.findByNameIgnoreCase(platform);

            GamePlatformEntity build = GamePlatformEntity
                    .builder()
                    .games(gamesEntity)
                    .platforms(entity)
                    .build();

            gamePlatformRepository.save(build);
        }
    }

    // findAll test
    @Test
    @Transactional
    void findAllTest(){
        List<GamePlatformEntity> entities = gamePlatformRepository.findAll();

        for(GamePlatformEntity entity : entities){
            System.out.println(entity);
        }
    }
}