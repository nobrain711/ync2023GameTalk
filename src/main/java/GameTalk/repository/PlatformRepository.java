package GameTalk.repository;

import GameTalk.entity.PlatformEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformRepository extends JpaRepository<PlatformEntity, Long> {

    List<PlatformEntity> findByNameContainingIgnoreCase(String name);

    PlatformEntity findByNameIgnoreCase(String name);
}
