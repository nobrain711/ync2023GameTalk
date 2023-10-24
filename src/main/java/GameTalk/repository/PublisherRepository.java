package GameTalk.repository;

import GameTalk.entity.PublishersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<PublishersEntity, Long> {
    List<PublishersEntity> findByNameContainingIgnoreCase(String name);

    PublishersEntity findByNameIgnoreCase(String name);
}
