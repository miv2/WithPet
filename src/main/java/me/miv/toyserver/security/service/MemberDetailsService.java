package me.miv.toyserver.security.service;

import me.miv.toyserver.member.domain.Member;
import me.miv.toyserver.member.service.MemberService;
import me.miv.toyserver.security.domain.MemberDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class MemberDetailsService implements UserDetailsService {
    private final MemberService memberService;

    public MemberDetailsService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Member member = memberService.getMemberByLoginId(username);
        return MemberDetails.of(member);
    }
}
