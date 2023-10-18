package GameTalk.repository;

import GameTalk.entity.GenersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenersRepository extends JpaRepository<GenersEntity, Long> {
}
