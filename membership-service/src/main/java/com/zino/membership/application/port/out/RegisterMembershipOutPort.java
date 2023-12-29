package com.zino.membership.application.port.out;

import com.zino.membership.adapter.out.persistence.MembershipEntity;
import com.zino.membership.domain.Membership;

public interface RegisterMembershipOutPort {

    MembershipEntity createMembership(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipIsCorp membershipIsCorp
    );
}
