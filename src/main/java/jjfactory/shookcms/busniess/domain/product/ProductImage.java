package jjfactory.shookcms.busniess.domain.product;

import jjfactory.shookcms.busniess.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class ProductImage extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name="product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    private String imagePath;
}
