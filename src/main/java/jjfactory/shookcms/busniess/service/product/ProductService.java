package jjfactory.shookcms.busniess.service.product;

import jjfactory.shookcms.busniess.domain.product.Product;
import jjfactory.shookcms.busniess.domain.store.Store;
import jjfactory.shookcms.busniess.repository.product.ProductRepository;
import jjfactory.shookcms.busniess.repository.store.StoreRepository;
import jjfactory.shookcms.busniess.request.product.ProductCreate;
import jjfactory.shookcms.busniess.request.product.ProductUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional
@Service
public class ProductService {
    private final ProductRepository productRepository;
//    private final ProductQueryRepository productQueryRepository;
    private final StoreRepository storeRepository;

    public Long create(ProductCreate dto, Long storeId){
        Store store = getStore(storeId);
        Product product = Product.addProduct(dto, store);
        productRepository.save(product);
        store.incProductCount();
        return product.getId();
    }

    public String delete(Long productId){
        Product product = getProduct(productId);
        product.delete();

        Store store = product.getStore();
        store.decProductCount();
        return "y";
    }

    public String update(Long productId, ProductUpdate dto){
        Product product = getProduct(productId);
        product.modify(dto);
        return "y";
    }

    private Store getStore(Long storeId) {
        return storeRepository.findById(storeId).orElseThrow(NoSuchElementException::new);
    }

    private Product getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(NoSuchElementException::new);
    }

}
