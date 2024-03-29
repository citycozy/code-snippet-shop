package com.sku.codesnippetshop.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontMapping {

    @GetMapping("product-detail")
    public String productDetail() {
        return "/products/detail";
    }

    @GetMapping("login")
    public String login() {
        return "/login/login";
    }

    @GetMapping("join")
    public String join() {
        return "/join/join";
    }

    @GetMapping("mypage")
    public String mypage() {
        return "/mypage/mypage";
    }


    @GetMapping("detail/{itemId}")
    public String detail() {
        return "products/detail";
    }

    @GetMapping("cart")
    public String cart() {
        return "products/cart";
    }

    @GetMapping("profile-edit")
    public String profileEdit() {
        return "/mypage/profile-edit";
    }

    @GetMapping("join-welcome")
    public String joinWelcome() {
        return "/join/join-welcome";
    }

    @GetMapping("add-products")
    public String addProducts() {
        return "/products/add-products";
    }

    @GetMapping("scenario-management")
    public String scenarioManagement() {
        return "/admin/scenario-management";
    }

    @GetMapping("scenario-creation")
    public String scenarioCreation() {
        return "/admin/scenario-creation";
    }

    @GetMapping("key-management")
    public String keyManagement() {
        return "/admin/key-management";
    }

    @GetMapping("test")
    public String test() {
        return "/test/test";
    }

    @GetMapping("test2")
    public String test2() {
        return "/test/test2";
    }

    @GetMapping("log-format-management")
    public String logFormatManagement() {
        return "/admin/log-format-management";
    }

    @GetMapping("insight-board")
    public String insightBoard() {
        return "/admin/insight-board";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
