package lk.scubes_phone_and_accessories.asset.brand.service;

import lk.scubes_phone_and_accessories.asset.brand.dao.BrandDao;
import lk.scubes_phone_and_accessories.asset.brand.entity.Brand;
import lk.scubes_phone_and_accessories.asset.common_asset.model.enums.LiveDead;
import lk.scubes_phone_and_accessories.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@CacheConfig(cacheNames = "brand")
public class BrandService implements AbstractService<Brand, Integer> {
    private final BrandDao brandDao;

    @Autowired
    public BrandService(BrandDao brandDao) {this.brandDao = brandDao;    }

    @Override
    public List<Brand> findAll() {
        return brandDao.findAll().stream()
                .filter(x -> LiveDead.ACTIVE.equals(x.getLiveDead()))
                .collect(Collectors.toList());
    }

    @Override
    public Brand findById(Integer id) {
        return brandDao.getOne(id);
    }

    @Override
    public Brand persist(Brand brand) {
        if(brand.getId()==null){
            brand.setLiveDead(LiveDead.ACTIVE);
        }
        return brandDao.save(brand);
    }

    @Override
    public boolean delete(Integer id) {
        Brand brand =  brandDao.getOne(id);
        brand.setLiveDead(LiveDead.STOP);
        brandDao.save(brand);
        return false;
    }



    @Override
    public List<Brand> search(Brand brand) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Brand> brandExample = Example.of(brand, matcher);
        return brandDao.findAll(brandExample);
    }
}
