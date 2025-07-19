package com.example.demo.action;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.support.RequestDataValueProcessor;

public class CustomCompositeRequestDataValueProcessor implements RequestDataValueProcessor {

    private final List<RequestDataValueProcessor> delegates;

    public CustomCompositeRequestDataValueProcessor(RequestDataValueProcessor... delegates) {
        this.delegates = Arrays.asList(delegates);
    }

    @Override
    public String processAction(HttpServletRequest request, String action, String httpMethod) {
        String result = action;
        for (RequestDataValueProcessor delegate : delegates) {
            result = delegate.processAction(request, result, httpMethod);
        }
        return result;
    }

    @Override
    public String processFormFieldValue(HttpServletRequest request, String name, String value, String type) {
        String result = value;
        for (RequestDataValueProcessor delegate : delegates) {
            result = delegate.processFormFieldValue(request, name, result, type);
        }
        return result;
    }

    @Override
    public Map<String, String> getExtraHiddenFields(HttpServletRequest request) {
        Map<String, String> result = new LinkedHashMap<>();
        for (RequestDataValueProcessor delegate : delegates) {
            Map<String, String> fields = delegate.getExtraHiddenFields(request);
            if (fields != null) {
                result.putAll(fields);
            }
        }
        return result;
    }

    @Override
    public String processUrl(HttpServletRequest request, String url) {
        String result = url;
        for (RequestDataValueProcessor delegate : delegates) {
            result = delegate.processUrl(request, result);
        }
        return result;
    }
}
