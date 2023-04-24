package vn.codegym.repository.product;

import vn.codegym.entity.product.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductSizeRepository extends JpaRepository<ProductSize, Integer> {
}
