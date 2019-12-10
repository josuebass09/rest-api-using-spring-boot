package com.example.restcalculatorbyjosuehr.auth;

import org.springframework.security.web.savedrequest.Enumerator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class MyServletRequestWrapper extends HttpServletRequestWrapper {
    private final HashMap<String, String[]> params;

    /**
     * @param request
     * @param params
     */
    public MyServletRequestWrapper(HttpServletRequest request, HashMap<String, String[]> params) {
        super(request);
        this.params = params;
    }

    /**
     *
     * @param name
     * @return String
     */
    @Override
    public String getParameter(String name) {
        if (this.params.containsKey(name)) {
            return this.params.get(name)[0];
        }
        return "";
    }

    /**
     *
     * @return Map
     */
    @Override
    public Map<String, String[]> getParameterMap() {
        return this.params;
    }

    /**
     *
     * @return String Enumeration
     */
    @Override
    public Enumeration<String> getParameterNames() {
        return new Enumerator<>(params.keySet());
    }

    /**
     *
     * @param name
     * @return String Array
     */
    @Override
    public String[] getParameterValues(String name) {
        return params.get(name);
    }

}
