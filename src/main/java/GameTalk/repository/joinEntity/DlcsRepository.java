package GameTalk.repository.joinEntity;

import GameTalk.entity.idclass.DlcsEntityId;
import GameTalk.entity.joinEntity.DlcsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DlcsRepository extends JpaRepository<DlcsEntity, DlcsEntityId> {
}
