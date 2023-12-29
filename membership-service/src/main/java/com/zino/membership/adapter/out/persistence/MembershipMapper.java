package com.zino.membership.adapter.out.persistence;

import com.zino.membership.domain.Membership;
import org.springframework.stereotype.Component;

@Component
public class MembershipMapper {

    public Membership mapToDomain(MembershipEntity membershipEntity){
        return Membership.generateMember(
                new Membership.MembershipId(membershipEntity.getMembershipId() + ""),
                new Membership.MembershipName(membershipEntity.getName()),
                new Membership.MembershipEmail(membershipEntity.getEmail()),
                new Membership.MembershipAddress(membershipEntity.getAddress()),
                new Membership.MembershipIsValid(membershipEntity.isValid()),
                new Membership.MembershipIsCorp(membershipEntity.isCorp())
        );
    }
}
