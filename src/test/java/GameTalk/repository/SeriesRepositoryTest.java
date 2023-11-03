package GameTalk.repository;

import GameTalk.entity.SeriesEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SeriesRepositoryTest {

    @Autowired
    private SeriesRepository repository;

    // Insert Test
    @Test
    void insertTest() {
        SeriesEntity build = SeriesEntity
                .builder()
                .name("Assassin's Creed")
                .build();

        repository.save(build);
    }

    // findAll TEST
    @Test
    void selectTest(){
        System.out.println(repository.findAll());
    }

    // UNIQUE TEST
    @Test
    @Transactional
    void uniqueTest() {
        try {
            SeriesEntity build = SeriesEntity
                    .builder()
                    .name("Assassin's Creed")
                    .build();

            repository.save(build);
        } catch (Exception e) {
            System.out.println("존재하는 시리즈입니다.");
        }
    }

    // findByName Test
    @Test
    void findByNameTest1() {
        System.out.println(repository.findByName("Assassin's Creed"));
    }

    // findByName Not DB Test
    @Test
    void findByNameTest2() {
        Long seriesId = repository.findByName("").getSericeId();

        if(seriesId == null){
            System.out.println("존재하지 않는 시리즈 입니다.");
        }
    }
}