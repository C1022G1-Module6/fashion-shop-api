package vn.codegym.repository.news;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.dto.news.INewsDTO;
import vn.codegym.entity.news.News;

import java.util.List;

@Repository
public interface INewsRepository extends JpaRepository<News, Integer> {
    /**
     * create by : TanNN ,
     * Date Create : 24/04/2023
     * Function : Add new 1 news to db
     *
     * @param content
     * @param img
     * @param nameImg
     * @param title
     * @param employeeId
     * @return no return value
     */
    @Transactional
    @Modifying
    @Query(value = "insert into news (content, img, name_img, title, employee_id,mb) values (:content,:img, :nameImg,:title,:employee_id,:mb)",
            nativeQuery = true)
    void addNews(@Param("content") String content, @Param("img") String img,@Param("nameImg") String nameImg, @Param("title") String title, @Param("employee_id") Integer employeeId,@Param("mb") Double mb);

    /**
     * create by : TanNN ,
     * Date Create : 24/04/2023
     * Function : Get news list with pagination and search
     *
     * @param tittleSearch
     * @param pageable
     * @return Returns a list of information according to the 2 parameters passed
     */
    @Query(value = "select n.id,n.content, n.img, n.title,n.employee_id as employeeId, DATE_FORMAT(NOW(), '%d-%m-%Y') as dateTime  FROM news n where n.title like concat('%',:tittleSearch,'%') and n.flag_delete = 0 order by n.id desc",
            countQuery = "select n.id,n.content, n.img, n.title,n.employee_id as employeeId, DATE_FORMAT(NOW(), '%d-%m-%Y') as dateTime  FROM news n where n.title like concat('%',:tittleSearch,'%') and n.flag_delete = 0 order by n.id desc",
            nativeQuery = true)
    Page<INewsDTO> pageNews(Pageable pageable, String tittleSearch);

    /**
     * Create by: TanNN
     * Date created: 24/04/2023
     * Function: Get details of 1 news in the database
     *
     * @param idNews
     * @return return 1 news by idNews
     */
    @Query(value = "select n.content, n.img, n.title,n.employee_id as employeeId FROM news n where n.id = :idNews",
            countQuery = "select n.content, n.img, n.title,n.employee_id as employeeId FROM news n where n.id = :idNews",
            nativeQuery = true)
    INewsDTO findByIdNews(@Param("idNews") String idNews);

    /**
     * create by : TanNN ,
     * Date Create : 24/04/2023
     * Function : display 3 random news in the database
     *
     * @return get list randomly returns 3 news records in the database
     */
    @Query(value = "select n.id,n.content, n.img, n.title,n.employee_id as employeeId FROM news n order by  RAND() limit 3",
            countQuery = "select n.id,n.content, n.img, n.title,n.employee_id as employeeId FROM news n order by desc RAND() limit 3",
            nativeQuery = true)
    List<INewsDTO> listRelatedNews();
}
