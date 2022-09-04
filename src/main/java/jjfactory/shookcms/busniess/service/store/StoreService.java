package jjfactory.shookcms.busniess.service.store;

import jjfactory.shookcms.busniess.domain.store.Store;
import jjfactory.shookcms.busniess.repository.store.StoreQueryRepository;
import jjfactory.shookcms.busniess.repository.store.StoreRepository;
import jjfactory.shookcms.busniess.request.store.StoreCreate;
import jjfactory.shookcms.busniess.request.store.StoreUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Transactional
@RequiredArgsConstructor
@Service
public class StoreService {
    private final StoreRepository storeRepository;
    private final StoreQueryRepository storeQueryRepository;

//    @Transactional(readOnly = true)
//    public Page<StoreRes> findStores(Pageable pageable){
//        return storeQueryRepository.findStores(pageable);
//    }
//
//    @Transactional(readOnly = true)
//    public StoreDetailRes findStoreById(Long storeId){
//        Store store = getStore(storeId);
//        return new StoreDetailRes(store);
//    }

    public String create(StoreCreate dto){
        Store store = Store.create(dto);
        storeRepository.save(store);
        return "y";
    }

    public String delete(Long storeId){
        Store store = getStore(storeId);
        store.delete();
        return "y";
    }

    public String update(Long storeId, StoreUpdate dto){
        Store store = getStore(storeId);
        store.changeName(dto.getName());
        return "y";
    }

    private Store getStore(Long storeId) {
        return storeRepository.findById(storeId).orElseThrow(NoSuchElementException::new);
    }
}
