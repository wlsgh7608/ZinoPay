package com.zino.membership.adapter.in.web;


import com.zino.membership.application.port.in.ModifyMembershipCommand;
import com.zino.membership.application.port.in.ModifyMembershipUseCase;
import com.zino.membership.common.WebAdapter;
import com.zino.membership.domain.MembershipDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMembershipController {
    private final ModifyMembershipUseCase modifyMembershipUseCase;

    @PutMapping("/membership/{membershipId}")
    public ResponseEntity<MembershipDto> modifyMembership(@RequestBody ModifyMembershipRequest request, @PathVariable String membershipId) {
        // request
        // request -> command
        // usecase  (request가 아니라 command을 받아야 함)

        ModifyMembershipCommand command = ModifyMembershipCommand.builder()
                .membershipId(membershipId)
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        return ResponseEntity.ok(modifyMembershipUseCase.modifyMembership(command));
    }


}
