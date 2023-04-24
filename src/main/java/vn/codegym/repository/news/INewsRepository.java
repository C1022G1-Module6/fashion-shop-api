package vn.codegym.repository.news;

import vn.codegym.entity.news.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INewsRepository extends JpaRepository<News, Integer> {
}
