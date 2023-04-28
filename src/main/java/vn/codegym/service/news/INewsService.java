package vn.codegym.service.news;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.codegym.dto.news.INewsDTO;
import vn.codegym.dto.news.NewsDTO;
import vn.codegym.entity.news.News;

import java.util.List;

public interface INewsService {
    void addNews(NewsDTO newsDTO);

    Page<INewsDTO> pageNews(Pageable pageable, String tittleSearch);

    INewsDTO findByIdNews(String idNews);
    List<INewsDTO> listRelatedNews();

}
