package com.sku.codesnippetshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontMapping {

    @GetMapping("product-detail")
    public String productDetail(){
        return "/products/detail";
    }
    @GetMapping("login")
    public String login(){
        return "/login/login";
    }

    @GetMapping("join")
    public String join(){
        return "/join/join";
    }
    @GetMapping("mypage")
    public String mypage(){
        return "/mypage/mypage";
    }

    @GetMapping("empty-cart")
    public String cart(){
        return "products/cart_empty";
    }

    @GetMapping("detail")
    public String detail() {
        return "products/detail";
    }

    @GetMapping("cart-2")
    public String cart2(){
        return "/products/cart_not_empty";
    }

    @GetMapping("profile-edit")
    public String profileEdit(){
        return "/mypage/profile-edit";
    }

    @GetMapping("join-welcome")
    public String joinWelcome(){
        return "/join/join-welcome";
    }



}
