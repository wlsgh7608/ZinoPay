package com.zino.membership.adapter.out.persistence;

import com.zino.membership.domain.Membership;
import org.springframework.stereotype.Component;

@Component
public class MembershipMapper {

    public Membership mapToDomain(MembershipEntity membershipEntity) {
        return new Membership(
                membershipEntity.getMembershipId() + "",
                membershipEntity.getName(),
                membershipEntity.getEmail(),
                membershipEntity.getAddress(),
                membershipEntity.isValid(),
                membershipEntity.isCorp()
        );

    }
}
