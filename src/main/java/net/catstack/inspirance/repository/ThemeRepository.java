package net.catstack.inspirance.repository;

import net.catstack.inspirance.domain.model.ThemeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ThemeRepository extends JpaRepository<ThemeModel, Long> {
    ThemeModel findByName(String name);

    @Modifying
    @Query(value = "INSERT INTO themes(name) SELECT :name WHERE NOT EXISTS (SELECT 1 FROM themes WHERE name=:name)", nativeQuery = true)
    @Transactional
    void addIfNotExists(@Param("name") String name);
}
