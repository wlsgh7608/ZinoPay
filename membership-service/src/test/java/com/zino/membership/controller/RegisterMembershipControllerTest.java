package com.zino.membership.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zino.membership.adapter.in.web.RegisterMembershipRequest;
import com.zino.membership.domain.MembershipDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RegisterMembershipControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;


    @Test
    @DisplayName("회원가입 테스트")
    void register() throws Exception {

        RegisterMembershipRequest request = new RegisterMembershipRequest("name", "email", "address", true);



        MembershipDto membershipDto = new MembershipDto("1", "name", "email", "address", true, true);//


        mockMvc.perform(post("/membership/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request))
                ).andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(membershipDto)));
    }



}
