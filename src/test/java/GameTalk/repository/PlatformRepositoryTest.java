package GameTalk.repository;

import GameTalk.entity.PlatformEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlatformRepositoryTest {
    @Autowired
    private PlatformRepository repository;

    // insert test
    @Test
    void insertTest() {
        List<String> list = Arrays.asList("PS3", "Xbox X360", "Xbox One", "Xbox One X", "Windows");

        for (String item : list) {
            try {
                PlatformEntity build = PlatformEntity
                        .builder()
                        .name(item)
                        .build();

                repository.save(build);
            } catch (Exception e) {
                System.out.println("pass");
            }
        }
    }

    // findAll test
    @Test
    @Transactional
    void findAllTest() {
        List<PlatformEntity> entities = repository.findAll();

        for (PlatformEntity entity : entities) {
            System.out.println(entity);
        }
    }
}