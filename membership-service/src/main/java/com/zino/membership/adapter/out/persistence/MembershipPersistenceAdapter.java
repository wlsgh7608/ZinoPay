package com.zino.membership.adapter.out.persistence;

import com.zino.membership.application.port.out.RegisterMembershipOutPort;
import com.zino.membership.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipOutPort {
    private final MembershipRepository membershipRepository;

    @Override
    public MembershipEntity createMembership(
            String membershipName,
            String membershipEmail,
            String membershipAddress,
            boolean membershipIsValid,
            boolean membershipIsCorp)
    {
        MembershipEntity membership = new MembershipEntity(
                membershipName,
                membershipEmail,
                membershipAddress,
                membershipIsValid,
                membershipIsCorp
        );

        return membershipRepository.save(membership);
    }
}
