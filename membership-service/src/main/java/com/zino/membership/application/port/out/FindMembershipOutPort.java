package com.zino.membership.application.port.out;

import com.zino.membership.adapter.out.persistence.MembershipEntity;

public interface FindMembershipOutPort {
    MembershipEntity findMembership(String membershipId);
}
