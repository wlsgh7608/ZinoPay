package com.zino.membership.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zino.membership.application.port.in.RegisterMembershipCommand;
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

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class FindMembershipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    RegisterMembershipService registerMembershipService;


    @Test
    @DisplayName("회원 조회 테스트")
    void findMembership() throws Exception {


        MembershipDto membershipDto = new MembershipDto("1", "name", "email", "address", true, true);//
        String userId = "1";
        mockMvc.perform(get("/membership/{membershipId}", userId)
                        .contentType(MediaType.APPLICATION_JSON)

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
                .build());
    }


}