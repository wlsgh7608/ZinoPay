package com.zino.membership.adapter.out.persistence;

import com.zino.membership.application.port.out.RegisterMembershipOutPort;
import com.zino.membership.common.PersistenceAdapter;
import com.zino.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipOutPort {
    private final MembershipRepository membershipRepository;

    @Override
    public MembershipEntity createMembership(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipIsCorp membershipIsCorp) {



        MembershipEntity membership = new MembershipEntity(
                membershipName.getNameValue(),
                membershipEmail.getEmailValue(),
                membershipAddress.getAddressValue(),
                membershipIsValid.isValidValue(),
                membershipIsCorp.isCorpValue()
        );

        return membershipRepository.save(membership);
    }
}
