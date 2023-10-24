package GameTalk.repository;

import GameTalk.entity.PublishersEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PublisherRepositoryTest {
    @Autowired
    private PublisherRepository repository;

    // insert Test
    @Test
    void insertTest(){
        PublishersEntity build = PublishersEntity
                .builder()
                .name("Ubisoft")
                .url("https://www.ubisoft.com/ko-kr/")
                .build();

        repository.save(build);
    }

    // findAll test
    @Test
    @Transactional
    void findAllTest(){
        List<PublishersEntity> publishersEntities = repository.findAll();
        for(PublishersEntity publishersEntity: publishersEntities){
            System.out.println(
                    "Id: "+publishersEntity.getPublisher_id()+
                    " name: " +publishersEntity.getName()+
                    " url: "+publishersEntity.getUrl());
        }

    }

    // findByNameContainingIgnoreCase test
    @Test
    @Transactional
    void findByNameContainingIgnoreCaseTest(){
        List<PublishersEntity> publishersEntities = repository.findByNameContainingIgnoreCase("b");
        for(PublishersEntity publishersEntity: publishersEntities){
            System.out.println(
                    "Id: "+publishersEntity.getPublisher_id()+
                            " name: " +publishersEntity.getName()+
                            " url: "+publishersEntity.getUrl());
        }
    }

    // findByNameIgnoreCase test
    @Test
    @Transactional
    void findByNameIgnoreCaseTest(){
        PublishersEntity publishers = repository.findByNameIgnoreCase("Ubisoft");
        System.out.println(publishers);
    }
}