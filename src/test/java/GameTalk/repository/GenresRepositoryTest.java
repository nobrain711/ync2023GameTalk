package GameTalk.repository;

import GameTalk.entity.GenresEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class GenresRepositoryTest {

    @Autowired
    private GenresRepository repository;

    // Insert Test
    @Test
    void insertTest() {
        List<String> genres = Arrays.asList("Action", "Adventure");
        for (String genre : genres) {
            try {
                GenresEntity build = GenresEntity.builder().name(genre).build();
                repository.save(build);
            } catch (Exception e) {
                System.out.println("pass");
            }
        }

    }

    // UNIQUE Test
    @Test
    @Transactional
    void uniqueTest() {
        try {
            GenresEntity build = GenresEntity.builder().name("Action").build();
            repository.save(build);
        } catch (Exception e) {
            System.out.println("이미 존재하는 장르입니다.");
        }
    }

    // select All
    @Test
    void findAllTest() {
        List<GenresEntity> genresEntities = repository.findAll();

        for (GenresEntity genresEntity : genresEntities) {
            System.out.printf("Id: %3d    Name: %10s\n", genresEntity.getGenreId(), genresEntity.getName());
        }
    }

    // findByNameContaining test
    @Test
    void findByNameContainingIgnoreCaseTest() {
        List<GenresEntity> genersEntities = repository.findByNameContainingIgnoreCase("a");

        for (GenresEntity genresEntity : genersEntities) {
            System.out.printf("Id: %3d    Name: %10s\n", genresEntity.getGenreId(), genresEntity.getName());
        }
    }

    // findByNameIgnoreCase Test
    @Test
    @Transactional
    void findByNameIgnoreCaseTest() {
        System.out.println(repository.findByNameIgnoreCase("Action"));
    }

    //getGenreIdByTitleIgnoreCase test
    @Test
    void getGenreIdByTitleIgnoreCaseTest() {
        System.out.println(repository.getGenreIdByTitleIgnoreCase("Action"));
    }

}