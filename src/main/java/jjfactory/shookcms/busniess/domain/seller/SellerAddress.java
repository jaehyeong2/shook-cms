package jjfactory.shookcms.busniess.domain.seller;


import javax.persistence.Embeddable;

@Embeddable
public class SellerAddress {
    private String city;
    private String street;
    private String zipCode;
}
