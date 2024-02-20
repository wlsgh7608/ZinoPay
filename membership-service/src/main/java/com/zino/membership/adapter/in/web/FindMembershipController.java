package com.zino.membership.adapter.in.web;

import com.zino.membership.application.port.in.FindMembershipCommand;
import com.zino.membership.application.port.in.FindMembershipUseCase;
import com.zino.membership.common.WebAdapter;
import com.zino.membership.domain.MembershipDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUseCase;

    @GetMapping("/membership/{membershipId}")
    public ResponseEntity<MembershipDto> findMembership(@PathVariable String membershipId) {
        // request
        // request -> command
        // usecase  (request가 아니라 command을 받아야 함)

        FindMembershipCommand command = FindMembershipCommand.builder()
                .membershipId(membershipId)
                .build();

        return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
    }
}
