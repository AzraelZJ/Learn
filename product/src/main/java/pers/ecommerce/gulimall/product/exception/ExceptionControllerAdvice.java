package pers.ecommerce.gulimall.product.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.ecommerce.gulimall.common.exception.ErrorCodeEnum;
import pers.ecommerce.gulimall.common.utils.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>@ControllerAdvice：集中处理异常</p>
 * <p>@RestControllerAdvice = @ControllerAdvice + @ResponseBody</p>
 *
 * @author AzraelZJ
 * @date 2022/8/25 19:32
 */
@Slf4j
@RestControllerAdvice(basePackages = "pers.ecommerce.gulimall.product.controller")
public class ExceptionControllerAdvice {

    private final int errorMapInitialCapacity = 6;

    @ExceptionHandler(Exception.class)
    public Result<Map<String, String>> validExceptionHandle(MethodArgumentNotValidException e) {

        log.error("数据校验出现问题{}，异常类型：{}", e.getMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();

        Map<String, String> errorMap = new HashMap<>(errorMapInitialCapacity);
        bindingResult.getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        return new Result<Map<String, String>>().error(ErrorCodeEnum.VALID_EXCEPTION.getCode(),
                ErrorCodeEnum.VALID_EXCEPTION.getMessage(), errorMap);
    }

    /**
     * 通用异常处理器
     *
     * @param throwable 异常
     * @return 异常信息
     */
    @ExceptionHandler(Throwable.class)
    public Result exceptionHandle(Throwable throwable) {

        return new Result().error(ErrorCodeEnum.UNKNOWN_EXCEPTION.getCode(),
                ErrorCodeEnum.VALID_EXCEPTION.getMessage());
    }
}
