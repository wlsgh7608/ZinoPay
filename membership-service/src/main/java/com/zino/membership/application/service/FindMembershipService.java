package com.zino.membership.application.service;

import com.zino.membership.adapter.out.persistence.MembershipEntity;
import com.zino.membership.adapter.out.persistence.MembershipMapper;
import com.zino.membership.application.port.in.FindMembershipCommand;
import com.zino.membership.application.port.in.FindMembershipUseCase;
import com.zino.membership.application.port.out.FindMembershipOutPort;
import com.zino.membership.common.UseCase;
import com.zino.membership.domain.MembershipDto;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindMembershipService implements FindMembershipUseCase {
    private final FindMembershipOutPort findMembershipOutPort;
    private final MembershipMapper membershipMapper;

    @Override
    public MembershipDto findMembership(FindMembershipCommand command) {
        MembershipEntity membership = findMembershipOutPort.findMembership(command.getMembershipId());
        return membershipMapper.mapToDomain(membership);
    }
}
