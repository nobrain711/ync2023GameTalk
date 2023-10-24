package GameTalk.repository.joinEntity;

import GameTalk.entity.GamesEntity;
import GameTalk.entity.PublishersEntity;
import GameTalk.entity.joinEntity.GamePublisherEntity;
import GameTalk.repository.GamesRepository;
import GameTalk.repository.PublisherRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GamePublisherReposioryTest {
    @Autowired
    private GamePublisherReposiory gamePublisherReposiory;
    @Autowired
    private GamesRepository gamesRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    // insert test
    @Test
    void insertTest() {
        GamesEntity gamesEntity = gamesRepository.findByTitle("Assassin's Creed\\u2122");
        List<String> publishers = Arrays.asList("Ubisoft");
        for (String publisher : publishers) {
            PublishersEntity publishersEntity = publisherRepository.findByNameIgnoreCase(publisher);
            GamePublisherEntity build = GamePublisherEntity
                    .builder()
                    .games(gamesEntity)
                    .publishers(publishersEntity)
                    .build();

            gamePublisherReposiory.save(build);
        }
    }

    // findAll
    @Test
    @Transactional
    void findAllTest(){
        List<GamePublisherEntity> entities = gamePublisherReposiory.findAll();
        for(GamePublisherEntity entity : entities){
            System.out.println("game: "+entity.getGames()+" publisher: "+entity.getPublishers());
        }
    }
}