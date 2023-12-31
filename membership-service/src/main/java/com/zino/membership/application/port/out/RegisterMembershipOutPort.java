package com.zino.membership.application.port.out;

import com.zino.membership.adapter.out.persistence.MembershipEntity;

public interface RegisterMembershipOutPort {

    MembershipEntity createMembership(
            String membershipName,
            String membershipEmail,
            String membershipAddress,
            boolean membershipIsValid,
            boolean membershipIsCorp
    );
}
