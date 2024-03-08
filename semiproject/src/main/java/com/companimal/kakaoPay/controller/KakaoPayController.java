package com.companimal.kakaoPay.controller;

import com.companimal.kakaoPay.service.KakaoPay;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log
@Controller
public class KakaoPayController {

    private final KakaoPay kakaopay;

    @Autowired
    public KakaoPayController(KakaoPay kakaoPay) {
        this.kakaopay = kakaoPay;
    }

    @GetMapping //localhost:8080
    public String helloworld() {
        return "main";
    }

    @GetMapping("/kakaoPay")
    public String kakaoPayGet() {
        return "kakaoPay"; // kakaopay Page으로 이동
    }

    @GetMapping("kakaoPayFail")
    public String kakaoPayFail() {
        return "kakaoPayFail";
    }

    @PostMapping("/kakaoPay")
    public String kakaoPay() {
        log.info("kakaoPay 결제화면으로 이동함");

        return "redirect:" + kakaopay.kakaoPayReady(); // kakaopay 결제 화면으로 이동
        // http://localhost:8080/kakaoPaySuccess?pg_token=ee334b6d479d0c10260a
    }

    @GetMapping("/kakaoPaySuccess")
    public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
        log.info("kakaoPaySuccess get");
        log.info("kakaoPaySuccess pg_token : " + pg_token);
        model.addAttribute("info",kakaopay.kakaoPayInfo(pg_token));

        return "kakaoPaySuccess";
    }
}