package GameTalk.repository;

import GameTalk.entity.GamesEntity;
import GameTalk.entity.GenresEntity;
import GameTalk.entity.joinentity.GameGenreEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class GameGenerReposotioryTest {
    @Autowired
    private GameGenerReposotiory gameGenerReposotiory;
    @Autowired
    private GamesRepository gamesRepository;
    @Autowired
    private GenersRepository genersRepository;

    // insert Test()
    @Test
    void insertTest(){
        GamesEntity gamesEntity = gamesRepository.findByTitle("Assassin's Creed\\u2122");
        List<String> geners = Arrays.asList("Action", "Adventure");

        for(String gener: geners){
            GenresEntity genresEntity = genersRepository.findByNameIgnoreCase(gener);
            GameGenreEntity build = GameGenreEntity
                    .builder()
                    .games(gamesEntity)
                    .geners(genresEntity)
                    .build();

            gameGenerReposotiory.save(build);
        }
    }

    // findAll Test
    @Test
    @Transactional
    void findAllTest(){
        List<GameGenreEntity> all = gameGenerReposotiory.findAll();

        for(GameGenreEntity entity : all){
            System.out.println("game: "+entity.getGames()+"   gener: "+entity.getGeners());
        }
    }
}