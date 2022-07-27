package pers.ecommerce.gulimall.member.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.ecommerce.gulimall.common.utils.R;

/**
 * 这是一个声明式远程调用
 * @author AzraelZJ
 * @date 2022/7/14 23:27
 * @description @FeignClient 注解告诉 Spring Cloud 这个接口是一个远程客户端，要调用远程服务
 */
@FeignClient("coupon")
public interface CouponFeignService {

    /**
     * 要调用的远程服务的方法，写明该方法的全部签名即可
     * 其中，RequestMapping 中的路径要写全
     * 调用流程：若调用 memberCoupons 会先去服务中心找到 coupon 这个服务，再调用请求 coupon/coupon/member/list 对应的方法
     * @return R
     */
    @RequestMapping("coupon/coupon/member/list")
    public R memberCoupons();
}
