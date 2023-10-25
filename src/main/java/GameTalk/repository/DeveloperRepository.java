package GameTalk.repository;

import GameTalk.entity.DevelopersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<DevelopersEntity, Long> {
    DevelopersEntity findByNameIgnoreCase(String name);

    List<DevelopersEntity> findByNameContainingIgnoreCase(String name);
}
