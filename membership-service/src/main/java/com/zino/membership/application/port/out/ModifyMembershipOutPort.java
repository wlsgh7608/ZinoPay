package com.zino.membership.application.port.out;

import com.zino.membership.adapter.out.persistence.MembershipEntity;

public interface ModifyMembershipOutPort {
    MembershipEntity modifyMembership(
            String membershipId,
            String membershipName,
            String membershipEmail,
            String membershipAddress,
            boolean membershipIsValid,
            boolean membershipIsCorp
    );
}
