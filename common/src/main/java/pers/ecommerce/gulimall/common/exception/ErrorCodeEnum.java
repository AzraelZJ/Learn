package pers.ecommerce.gulimall.common.exception;

/**
 * 异常编码：由5位数字组成，前2位为模块编码，后3位为业务编码
 *
 * @author AzraelZJ
 * @date 2022/8/25 22:56
 */
public enum ErrorCodeEnum {

    /**
     * admin 模块：系统未知异常
     */
    UNKNOWN_EXCEPTION(10000, "系统未知异常"),

    /**
     * admin 模块：参数格式校验失败异常
     */
    VALID_EXCEPTION(10001, "参数格式校验失败");

    /**
     * 异常状态码
     */
    private final int code;

    /**
     * 异常信息
     */
    private final String message;

    ErrorCodeEnum(int code, String message) {

        this.code = code;
        this.message = message;
    }

    public int getCode() {

        return this.code;
    }

    public String getMessage() {

        return this.message;
    }
}
