package jjfactory.shookcms.busniess.domain.product;

import jjfactory.shookcms.busniess.domain.BaseTimeEntity;
import jjfactory.shookcms.busniess.domain.store.Store;
import jjfactory.shookcms.busniess.request.product.ProductCreate;
import jjfactory.shookcms.busniess.request.product.ProductUpdate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Product extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "store_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;
    private String name;
    private String description;
    private int price;
    private int stockQuantity;

    @Builder
    public Product(Store store, String name, int price, int stockQuantity,String description) {
        this.store = store;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.description = description;
    }

    public static Product addProduct(ProductCreate dto, Store store){
        return Product.builder()
                .name(dto.getName())
                .stockQuantity(dto.getStockQuantity())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .store(store)
                .build();
    }

    public void modify(ProductUpdate dto) {
        this.name = dto.getName();
        this.price = dto.getPrice();
        this.stockQuantity = dto.getStockQuantity();
    }

}
