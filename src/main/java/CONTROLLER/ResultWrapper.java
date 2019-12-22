package CONTROLLER;

import POJO.ApiResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;

/**
 * 拦截并包装返回结果
 * @author: Toon
 * @create: 2019-12-22 10:43
 **/
@RestControllerAdvice
public class ResultWrapper implements ResponseBodyAdvice<Object> {
    private static final Class[] annos = {
            RequestMapping.class,
            GetMapping.class,
            PostMapping.class,
            DeleteMapping.class,
            PutMapping.class,
    };
    @Override
    public boolean supports(MethodParameter returnTye, Class<? extends HttpMessageConverter<?>> converterType){
        final AnnotatedElement element = returnTye.getAnnotatedElement();
        return Arrays.stream(annos).anyMatch(anno -> anno.isAnnotation()&&element.isAnnotationPresent(anno));
    }
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response){
        return new ApiResult(body);
    }
}
