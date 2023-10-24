package GameTalk.repository;

import GameTalk.entity.GenresEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class GenersRepositoryTest {

    @Autowired
    private GenersRepository repository;

    // Insert Test
    @Test
    void insertTest() {
        List<String> geners = Arrays.asList("Action", "Adventure");
        for (String gener : geners) {
            GenresEntity build = GenresEntity.builder().name(gener).build();
            repository.save(build);
        }
    }

    // UNIQUE Test
    @Test
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
        List<GenresEntity> genersEntities = repository.findAll();

        for (GenresEntity genresEntity : genersEntities) {
            System.out.printf("Id: %3d    Name: %10s\n", genresEntity.getGenerId(), genresEntity.getName());
        }
    }

    // findByNameContaining test
    @Test
    void findByNameContainingIgnoreCaseTest() {
        List<GenresEntity> genersEntities = repository.findByNameContainingIgnoreCase("a");

        for (GenresEntity genresEntity : genersEntities) {
            System.out.printf("Id: %3d    Name: %10s\n", genresEntity.getGenerId(), genresEntity.getName());
        }
    }

    // findByNameIgnoreCase Test
    @Test
    @Transactional
    void findByNameIgnoreCaseTest(){
        System.out.println(repository.findByNameIgnoreCase("Action"));
    }
    //getGenerIdByTitleIgnoreCase test
    @Test
    void getGenerIdByTitleIgnoreCaseTest() {
        System.out.println(repository.getGenerIdByTitleIgnoreCase("Action"));
    }

}