package vn.codegym.service.product;

import vn.codegym.entity.product.ProductSize;

import java.util.List;

public interface IProductSizeService {
    List<ProductSize> getAllProductSizes();

    void addProductSize(String name);
    void save(ProductSize productSize);
}
