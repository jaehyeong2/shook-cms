package jjfactory.shookcms.busniess.controller.store;

import jjfactory.shookcms.busniess.request.product.ProductCreate;
import jjfactory.shookcms.busniess.request.product.ProductUpdate;
import jjfactory.shookcms.busniess.service.product.ProductService;
import jjfactory.shookcms.global.response.ApiRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/store")
@RequiredArgsConstructor
@RestController
public class StoreApi {
    private final ProductService productService;


    //TODO 지점으로 들어가면 본인 상품만, 운영사로 들어가면 전체 다 보이게
//    @GetMapping("/{storeId}/products/{productId}")
//    public ApiRes<ProductDetailRes> findProduct(@PathVariable Long storeId,
//                                                @PathVariable Long productId){
//        return new ApiRes<>(productService.findProduct(productId));
//    }
//
//    @GetMapping("/{storeId}/products")
//    public PagingRes<ProductRes> findProducts(@PathVariable Long storeId,
//                                              @RequestParam(required = false,defaultValue = "10") int size,
//                                              @RequestParam(required = false,defaultValue = "1") int page){
//        return productService.findProductsByStoreId(new MyPageReq(page,size).of(),storeId);
//    }

    @PostMapping("")
    public ApiRes<Long> addProduct(@PathVariable Long storeId,
                                   @RequestBody ProductCreate dto){
        return new ApiRes<>(productService.create(dto,storeId));
    }

    @DeleteMapping("/{storeId}/products/{productId}")
    public ApiRes<String> deleteProduct(@PathVariable Long productId){
        return new ApiRes<>(productService.delete(productId));
    }

    @PatchMapping("/{storeId}/products/{productId}")
    public ApiRes<String> modifyProduct(@PathVariable Long productId,
                                        @RequestBody ProductUpdate dto){
        return new ApiRes<>(productService.update(productId,dto));
    }
}
