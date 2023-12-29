package com.zino.membership.application.service;

import com.zino.membership.application.port.in.RegisterMembershipCommand;
import com.zino.membership.application.port.in.RegisterMembershipUseCase;
import com.zino.membership.domain.Membership;


public class RegisterMembershipService implements RegisterMembershipUseCase {

    /**
     * 서비스는 커맨드를 활용하여 구현
     */
    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {
        // 커맨드를 활용하여 DB와 통신


        //biz logic -> DB
        // DB는 외부 시스템
        // port adapter을 이용해야 함

        return null;
    }
}
