package com.zino.membership.adapter.in.web;

import com.zino.membership.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {
    @GetMapping("/test")
    void test() {
        System.out.println("Test Controller");
    }

}
