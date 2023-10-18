package GameTalk.repository;

import GameTalk.entity.GenersEntity;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GenersRepositoryTest {

    @Autowired
    private GenersRepository repository;

    @Test
    void insertTest(){
        String[] genersArray = {"Action", "Adventure", "RPG"};
        List<Object> geners = Arrays.asList(genersArray);


        for(Object gener:geners){
            GenersEntity build = GenersEntity
                    .builder()
                    .name((String) gener)
                    .build();

            repository.save(build);
        }
    }
}