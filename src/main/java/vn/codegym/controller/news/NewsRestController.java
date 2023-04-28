package vn.codegym.controller.news;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.news.INewsDTO;
import vn.codegym.dto.news.NewsDTO;
import vn.codegym.entity.employee.Employee;
import vn.codegym.entity.news.News;
import vn.codegym.service.news.INewsService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api-news")
public class NewsRestController {

    @Autowired
    private INewsService iNewsService;
    /**
     * create by : TanNN ,
     * Date Create : 24/04/2023
     * Function : display news list with pagination and search
     *
     * @param tittleSearch
     * @param pageable
     * @return HttpStatus.BAD_REQUEST if result is error or HttpStatus.OK if result is not error
     */
    @GetMapping("listNews")
    public ResponseEntity<Page<INewsDTO>> getAllNews(@RequestParam(defaultValue = "", required = false) String tittleSearch,
                                                     @PageableDefault(value = 8) Pageable pageable){
        Page<INewsDTO> newsDTOS = iNewsService.pageNews(pageable,tittleSearch);
        if (newsDTOS.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newsDTOS, HttpStatus.OK);
    }
    /**
     * create by : TanNN ,
     * Date Create : 24/04/2023
     * Function : display 3 random news in the database
     * @return HttpStatus.NO_CONTENT if result is error or HttpStatus.OK if result is not error
     */
    @GetMapping("relatedNews")
    public ResponseEntity<List<INewsDTO>> getRelatedNews(){
        List<INewsDTO> listRlatedNews = iNewsService.listRelatedNews();
        if (listRlatedNews.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listRlatedNews,HttpStatus.OK);
    }
    /**
     * Create by: TanNN
     * Date created: 24/04/2023
     * Function: View details of 1 news in the database
     * @param idNews
     * @return HttpStatus.OK when returning 1 news by id, HttpStatus.BAD_REQUEST when error occurs
     */
    @GetMapping("detailNews")
    public ResponseEntity<INewsDTO> getNews(@RequestParam(defaultValue = "", required = false) String idNews){
        INewsDTO iNewsDTO = iNewsService.findByIdNews(idNews);
        if (iNewsDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iNewsDTO, HttpStatus.OK);
    }
    /**
     * create by : TanNN ,
     * Date Create : 24/04/2023
     * Function : add 1 new news to the database
     *
     * @param newsDTO
     * @return HttpStatus.BAD_REQUEST if the result is an error or HttpStatus.OK if the passed parameter is successfully saved to the database
     */
    @PostMapping("createNews")
    public ResponseEntity<?> createNews(@Validated @RequestBody NewsDTO newsDTO, BindingResult bindingResult) {
        newsDTO.validate(newsDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        iNewsService.addNews(newsDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
