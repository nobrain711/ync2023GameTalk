package GameTalk.repository.joinEntity;

import GameTalk.entity.DevelopersEntity;
import GameTalk.entity.GamesEntity;
import GameTalk.entity.joinEntity.GameDeveloperEntity;
import GameTalk.repository.DeveloperRepository;
import GameTalk.repository.GamesRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameDeveloperRepositoryTest {
    @Autowired
    private GamesRepository gamesRepository;
    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private GameDeveloperRepository gameDeveloperRepository;

    // insert test
    @Test
    void insertTest() {
        GamesEntity games = gamesRepository.findByTitle("Assassin's Creed\\u2122");
        List<String> list = Arrays.asList("Ubisoft Montreal");

        for (String name : list) {
            DevelopersEntity developers = developerRepository.findByNameIgnoreCase(name);

            GameDeveloperEntity build = GameDeveloperEntity
                    .builder()
                    .games(games)
                    .developers(developers)
                    .build();

            gameDeveloperRepository.save(build);
        }
    }

    @Test
    @Transactional
    void findAllTest(){
        List<GameDeveloperEntity> entities = gameDeveloperRepository.findAll();

        for (GameDeveloperEntity entity : entities){
            System.out.println("game: "+entity.getGames().toString()+" developer: "+entity.getDevelopers().toString());
        }
    }
}