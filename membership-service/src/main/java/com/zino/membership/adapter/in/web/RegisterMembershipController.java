package com.zino.membership.adapter.in.web;

import com.zino.membership.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/membership")
public class RegisterMembershipController {
    @PostMapping("/register")
    public void register(@RequestBody RegisterMembershipRequest request) {

        System.out.println("Test Controller");
    }

}
