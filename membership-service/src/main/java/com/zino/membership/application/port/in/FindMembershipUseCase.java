package com.zino.membership.application.port.in;

import com.zino.membership.domain.MembershipDto;


public interface FindMembershipUseCase {

    MembershipDto findMembership(FindMembershipCommand command);

}