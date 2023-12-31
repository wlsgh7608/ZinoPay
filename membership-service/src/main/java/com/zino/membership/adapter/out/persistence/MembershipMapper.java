package com.zino.membership.adapter.out.persistence;

import com.zino.membership.domain.MembershipDto;
import org.springframework.stereotype.Component;

@Component
public class MembershipMapper {

    public MembershipDto mapToDomain(MembershipEntity membershipEntity) {
        return new MembershipDto(
                membershipEntity.getMembershipId() + "",
                membershipEntity.getName(),
                membershipEntity.getEmail(),
                membershipEntity.getAddress(),
                membershipEntity.isValid(),
                membershipEntity.isCorp()
        );

    }
}
