package org.zerok.jdbcex.service;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerok.jdbcex.dao.MemberDAO;
import org.zerok.jdbcex.domain.MemberVO;
import org.zerok.jdbcex.dto.MemberDTO;
import org.zerok.jdbcex.util.MapperUtil;

import java.time.Instant;
@Log4j2
public enum MemberService {
        INSTANCE;
    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService(){
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login(String mid, String mpw)throws Exception {
        MemberVO vo = dao.getWithPassword(mid,mpw);
        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);

        return memberDTO;
    }

}
