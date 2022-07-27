package pers.ecommerce.gulimall.product.controller;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自动添加公共字段：提供了记录创建者、记录创建时间、记录修改时间的自动添加
 *
 * @author AzraelZJ
 * @date 2022/7/13 12:27
 */
@Component
@Slf4j
public class MetaController implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

        long creatorId = 0L;
        this.setFieldValByName("creator", creatorId, metaObject);
        this.setFieldValByName("createDate", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        this.setFieldValByName("updateDate", new Date(), metaObject);
    }
}