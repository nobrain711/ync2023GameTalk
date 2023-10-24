package GameTalk.repository.joinEntity;

import GameTalk.entity.GamesEntity;
import GameTalk.entity.GenresEntity;
import GameTalk.entity.joinEntity.GameGenreEntity;
import GameTalk.repository.GamesRepository;
import GameTalk.repository.GenresRepository;
import GameTalk.repository.joinEntity.GameGenreRepostiory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class GameGenreRepsotioryTest {
    @Autowired
    private GameGenreRepostiory gameGenreRepostiory;
    @Autowired
    private GamesRepository gamesRepository;
    @Autowired
    private GenresRepository genresRepository;

    // insert Test()
    @Test
    void insertTest(){
        GamesEntity gamesEntity = gamesRepository.findByTitle("Assassin's Creed\\u2122");
        List<String> genres = Arrays.asList("Action", "Adventure");

        for(String genre: genres){
            GenresEntity genresEntity = genresRepository.findByNameIgnoreCase(genre);
            GameGenreEntity build = GameGenreEntity
                    .builder()
                    .games(gamesEntity)
                    .genres(genresEntity)
                    .build();

            gameGenreRepostiory.save(build);
        }
    }

    // findAll Test
    @Test
    @Transactional
    void findAllTest(){
        List<GameGenreEntity> all = gameGenreRepostiory.findAll();

        for(GameGenreEntity entity : all){
            System.out.println("game: "+entity.getGames()+"   gener: "+entity.getGenres());
        }
    }
}