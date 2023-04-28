package vn.codegym.service.news.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.dto.news.INewsDTO;
import vn.codegym.dto.news.NewsDTO;
import vn.codegym.entity.news.News;
import vn.codegym.repository.news.INewsRepository;
import vn.codegym.service.news.INewsService;

import java.util.List;

@Service
public class NewsService implements INewsService {
    @Autowired
    private INewsRepository iNewsRepository;
    /**
     * create by : TanNN ,
     * Date Create : 24/04/2023
     * Function : Add new 1 news to db
     *
     * @param newsDTO
     * @return no return value
     */
    @Override
    public void addNews(NewsDTO newsDTO) {
        iNewsRepository.addNews(newsDTO.getContent(),newsDTO.getImg(),newsDTO.getNameImg(),newsDTO.getTitle(),newsDTO.getEmployee().getId());
    }

    /**
     * create by : TanNN ,
     * Date Create : 24/04/2023
     * Function : display news list with pagination and search
     *
     * @param tittleSearch
     * @param pageable
     * @return Returns a list of information according to the 2 parameters passed
     */
    @Override
    public Page<INewsDTO> pageNews(Pageable pageable, String tittleSearch) {
        return iNewsRepository.pageNews(pageable,tittleSearch);
    }
    /**
     * Create by: TanNN
     * Date created: 24/04/2023
     * Function: View details of 1 news in the database
     * @param idNews
     * @return return 1 news by idNews
     */
    @Override
    public INewsDTO findByIdNews(String idNews) {
        return iNewsRepository.findByIdNews(idNews);
    }


    /**
     * create by : TanNN ,
     * Date Create : 24/04/2023
     * Function : display 3 random news in the database
     * @return randomly returns 3 news records in the database
     */
    @Override
    public List<INewsDTO> listRelatedNews() {
        return iNewsRepository.listRelatedNews();
    }
}
