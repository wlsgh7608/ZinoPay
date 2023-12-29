package com.zino.membership.application.service;

import com.zino.membership.adapter.out.persistence.MembershipEntity;
import com.zino.membership.adapter.out.persistence.MembershipMapper;
import com.zino.membership.application.port.in.RegisterMembershipCommand;
import com.zino.membership.application.port.in.RegisterMembershipUseCase;
import com.zino.membership.application.port.out.RegisterMembershipOutPort;
import com.zino.membership.common.UseCase;
import com.zino.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;



@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {
    private final RegisterMembershipOutPort registerMembershipOutPort;
    private final MembershipMapper membershipMapper;

    /**
     * 서비스는 커맨드를 활용하여 구현
     */
    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {
        // 커맨드를 활용하여 DB와 통신


        //biz logic -> DB
        // DB는 외부 시스템
        // port adapter을 이용해야 함

        MembershipEntity membershipEntity = registerMembershipOutPort.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );

        return membershipMapper.mapToDomain(membershipEntity);
    }
}
