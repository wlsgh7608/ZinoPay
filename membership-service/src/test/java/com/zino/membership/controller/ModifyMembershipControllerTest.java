package com.zino.membership.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zino.membership.adapter.in.web.ModifyMembershipRequest;
import com.zino.membership.application.port.in.RegisterMembershipCommand;
import com.zino.membership.application.service.FindMembershipService;
import com.zino.membership.application.service.RegisterMembershipService;
import com.zino.membership.domain.MembershipDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ModifyMembershipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;
    @Autowired
    RegisterMembershipService registerMembershipService;
    @Autowired
    FindMembershipService findMembershipService;

    @Test
    @DisplayName("회원 수정 테스트")
    void modify() throws Exception {
        // given
        ModifyMembershipRequest request = new ModifyMembershipRequest(
                "modifyName",
                "modifyEmail",
                "modifyAddress",
                false);

        MembershipDto membershipDto = new MembershipDto(
                "1",
                "modifyName",
                "modifyEmail",
                "modifyAddress",
                true,
                false);//


        // when
        mockMvc.perform(put("/membership/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request))
                ).andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(membershipDto)));



    }


    @BeforeEach
    void setUp() {
        registerMembershipService.registerMembership(RegisterMembershipCommand.builder()
                .name("name")
                .address("address")
                .email("email")
                .isValid(true)
                .isCorp(true)
                .build()
        );
    }


}
