package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


public class MemberController {

    private final MemberService memberService;

     // 생성자에 Autowired : 연관된 객체를 스프링에서 알아서 찾아 넣어줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
