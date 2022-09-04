package jjfactory.shookcms.busniess.domain.seller;


import jjfactory.shookcms.busniess.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Seller extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String tell;

    @Embedded
    private SellerAddress address;

    @Enumerated(EnumType.STRING)
    private SellerRole role;
}
