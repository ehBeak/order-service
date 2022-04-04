package com.project.orderservice.controller.web;

import com.project.orderservice.domain.Address;
import com.project.orderservice.domain.Member;
import com.project.orderservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //TODO: 파라미터 고민, 응답 Location
    @PostMapping("/members")
    public ResponseEntity<Long> saveMember(@RequestBody String name, @RequestBody Address address) {
        Long aLong = memberService.saveMember(address, name);
        return new ResponseEntity<>(aLong, HttpStatus.CREATED);

    }
}
