package GameTalk.repository;

import GameTalk.entity.SeriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<SeriesEntity, Long> {
    @Query("SELECT s.sericeId " +
            "FROM SeriesEntity s " +
            "WHERE s.name = :name")
    Long findByName(@Param("name") String name);
}
