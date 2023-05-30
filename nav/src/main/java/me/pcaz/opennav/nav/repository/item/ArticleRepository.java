package me.pcaz.opennav.nav.repository.item;

import me.pcaz.opennav.nav.entity.item.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity,Long> {
}
