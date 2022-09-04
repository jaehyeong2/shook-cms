package jjfactory.shookcms.busniess.repository.product;

import jjfactory.shookcms.busniess.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
