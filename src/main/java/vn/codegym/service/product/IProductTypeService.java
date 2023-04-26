package vn.codegym.service.product;

import vn.codegym.entity.product.ProductType;

import java.util.List;

public interface IProductTypeService {
    /**
     * Create by: TanTH
     * Date create: 24/04/2023
     * Function:  connect service to get data corresponding
     *
     * @return
     */
    List<ProductType> ListProductType();
}
