package com.zino.membership.adapter.in.web;

import com.zino.membership.application.port.in.RegisterMembershipCommand;
import com.zino.membership.application.port.in.RegisterMembershipUseCase;
import com.zino.membership.common.WebAdapter;
import com.zino.membership.domain.MembershipDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership/register")
    public MembershipDto register(@RequestBody RegisterMembershipRequest request) {
        // request


        // request -> command

        // usecase  (request가 아니라 command을 받아야 함)
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();


        return registerMembershipUseCase.registerMembership(command);

    }

}
