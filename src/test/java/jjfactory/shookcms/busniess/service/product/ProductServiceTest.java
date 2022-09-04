package jjfactory.shookcms.busniess.service.product;

import jjfactory.shookcms.busniess.domain.DeleteStatus;
import jjfactory.shookcms.busniess.domain.product.Product;
import jjfactory.shookcms.busniess.domain.store.Store;
import jjfactory.shookcms.busniess.request.product.ProductCreate;
import jjfactory.shookcms.busniess.request.product.ProductUpdate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class ProductServiceTest {
    @Autowired
    EntityManager em;
    @Autowired
    ProductService productService;
    Store store;
    Product product;

    @BeforeEach
    void setUp(){
        createStore();
        createProduct();
    }

    @Test
    @DisplayName("상품 등록")
    void create() {
        // given
        ProductCreate dto = ProductCreate.builder()
                .name("product")
                .price(12000)
                .stockQuantity(50)
                .build();

        // when
        Long productId = productService.create(dto, store.getId());

        // then
        assertThat(productId).isNotNull();
    }

    @Test
    @DisplayName("상품 삭제")
    void delete() {
        // when
        product.delete();
        // then
        assertThat(product.getDeleteStatus()).isEqualTo(DeleteStatus.Y);
    }

    @Test
    @DisplayName("상품 수정 성공")
    void update() {
        // given
        ProductUpdate update = ProductUpdate.builder()
                .name("sss")
                .price(12000)
                .stockQuantity(50)
                .build();

        // when
        productService.update(product.getId(),update);

        // then
        assertThat(product.getName()).isEqualTo("sss");
        assertThat(product.getPrice()).isEqualTo(12000);
        assertThat(product.getStockQuantity()).isEqualTo(50);
    }

    private void createStore() {
        store = Store.builder().name("store").grade("5").build();
        em.persist(store);
    }

    private void createProduct() {
        product = Product.builder().name("product").price(1000).store(store).build();
        em.persist(product);
    }
}