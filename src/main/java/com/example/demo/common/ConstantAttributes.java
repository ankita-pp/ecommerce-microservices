package com.example.demo.common;

public class ConstantAttributes {
    //User endpoints
    public static final String GET_ALL_USERS = "/user/all";
    public static final String GET_USER_BY_ID = "/user/{id}";

    public static final String ADD_USER = "/user/add";
    public static final String UPDATE_USER = "/user/update";

    public static final String DELETE_ALL_USERS = "/user/all";
    public static final String DELETE_BY_ID = "/user/{id}";

    //Product endpoints
    public static final String GET_ALL_PRODUCTS = "/product/all";
    public static final String GET_PRODUCT_BY_ID = "/product/{id}";

    public static final String ADD_PRODUCT = "/product/add";
    public static final String UPDATE_PRODUCT = "/product/update";

    public static final String DELETE_ALL_PRODUCTS = "/product/all";
    public static final String DELETE_PRODUCT_BY_ID = "/product/{id}";

    //Order endpoints
    public static final String GET_ORDER_FOR_USER = "/user/{userId}/orders";
    public static final String GET_ORDER_DETAILS_BY_USER_ID = "/user/{userId}/order/details";
    public static final String GET_ORDER_DETAILS_BY_ORDER_ID = "/user/{userId}/order/{orderId}/details";
    public static final String ADD_ORDER = "/order/add";
    public static final String CANCEL_ORDER = "/order/{orderId}/cancel";
}
