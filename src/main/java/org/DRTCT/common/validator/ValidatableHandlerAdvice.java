package org.DRTCT.common.validator;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class ValidatableHandlerAdvice implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new ValidatableArgumentResolver());
    }

    static class ValidatableArgumentResolver implements HandlerMethodArgumentResolver {

        @Override
        public boolean supportsParameter(MethodParameter parameter) {
            return Validatable.class.isAssignableFrom(parameter.getParameterType());
        }

        @Override
        public Object resolveArgument(MethodParameter parameter,
                                      ModelAndViewContainer mavContainer,
                                      org.springframework.web.context.request.NativeWebRequest webRequest,
                                      WebDataBinderFactory binderFactory) throws Exception {

            assert binderFactory != null;
            Object argument = binderFactory.createBinder(
                            webRequest,
                            null,
                            Objects.requireNonNull(parameter.getParameterName()))
                    .convertIfNecessary(webRequest.getParameterMap(), parameter.getParameterType());

            if (argument instanceof Validatable validatable) {
                validatable.validate();
            }

            return argument;
        }
    }
}
