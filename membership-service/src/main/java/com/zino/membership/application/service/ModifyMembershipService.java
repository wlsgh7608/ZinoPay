package com.zino.membership.application.service;

import com.zino.membership.adapter.out.persistence.MembershipEntity;
import com.zino.membership.adapter.out.persistence.MembershipMapper;
import com.zino.membership.application.port.in.ModifyMembershipCommand;
import com.zino.membership.application.port.in.ModifyMembershipUseCase;
import com.zino.membership.application.port.out.ModifyMembershipOutPort;
import com.zino.membership.common.UseCase;
import com.zino.membership.domain.MembershipDto;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipOutPort modifyMembershipOutPort;

    private final MembershipMapper membershipMapper;


    // 커맨드를 활용하여 DB와 통신
    // biz logic -> DB
    // DB는 외부 시스템
    // port adapter을 이용해야 함
    @Override
    public MembershipDto modifyMembership(ModifyMembershipCommand command) {

        MembershipEntity membership = modifyMembershipOutPort.modifyMembership(
                command.getMembershipId(),
                command.getName(),
                command.getEmail(),
                command.getAddress(),
                command.isValid(),
                command.isCorp()
        );
        return membershipMapper.mapToDomain(membership);
    }
}
