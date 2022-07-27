package pers.ecommerce.gulimall.product;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.ecommerce.gulimall.product.dto.BrandDTO;
import pers.ecommerce.gulimall.product.entity.BrandEntity;
import pers.ecommerce.gulimall.product.service.BrandService;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
@MapperScan("pers.ecommerce.gulimall.product.dao")
public class ProductApplicationTests {

    @Autowired
    private BrandService brandService;

    @Test
    public void testSaveBrand() {

        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setName("华为");

        brandService.save(brandDTO);
    }

    @Test
    public void testInsertBrand() {

        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("Xiaomi");

        brandService.insert(brandEntity);
    }

    @Test
    public void testQuery() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("brand_id", 1L);
        List<BrandDTO> list = brandService.list(map);
        list.forEach(System.out::println);
    }
}
