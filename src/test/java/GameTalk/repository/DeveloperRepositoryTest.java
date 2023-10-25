package GameTalk.repository;

import GameTalk.entity.DevelopersEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeveloperRepositoryTest {
    @Autowired
    private DeveloperRepository repository;

    // Insert Tset
    @Test
    void insertTest() {
        DevelopersEntity build = DevelopersEntity
                .builder()
                .name("Ubisoft Montreal")
                .url("https://montreal.ubisoft.com/")
                .build();

        repository.save(build);
    }

    // findAll test
    @Test
    @Transactional
    void findAllTest() {
        System.out.println(repository.findAll());
    }

    // findByNameContainingIgnoreCase test
    @Test
    @Transactional
    void findByNameContainingIgnoreCaseTest() {
        List<DevelopersEntity> entities = repository.findByNameContainingIgnoreCase("Mon");

        for (DevelopersEntity entity : entities) {
            System.out.println(entity);
        }
    }

    // findByNameIgnoreCase Test
    @Test
    @Transactional
    void findByNameIgnoreCaseTest(){
        System.out.println(repository.findByNameIgnoreCase("Ubisoft Montreal"));
    }
}