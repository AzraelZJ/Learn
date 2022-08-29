package pers.ecommerce.gulimall.product;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.ecommerce.gulimall.product.dto.BrandDTO;
import pers.ecommerce.gulimall.product.entity.BrandEntity;
import pers.ecommerce.gulimall.product.service.BrandService;
import pers.ecommerce.gulimall.product.service.CategoryService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Slf4j
@SpringBootTest
@MapperScan("pers.ecommerce.gulimall.product.dao")
public class ProductApplicationTests {

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

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

    /**
     * 测试根据 catId 获取完整的商品分类列表
     */
    @Test
    public void testGetCategoryList() {

        log.info("商品三级分类列表：{}", Arrays.toString(categoryService.getCatIdList(225L)));
    }
}
