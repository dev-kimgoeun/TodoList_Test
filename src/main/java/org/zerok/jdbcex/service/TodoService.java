package org.zerok.jdbcex.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerok.jdbcex.dao.TodoDAO;
import org.zerok.jdbcex.domain.TodoVO;
import org.zerok.jdbcex.dto.TodoDTO;
import org.zerok.jdbcex.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService(){

        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }
    public void register (TodoDTO todoDTO) throws Exception{
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        //System.out.println("todoVO : " + todoVO);
        log.info(todoVO);
        dao.insert(todoVO);
    }

    public List<TodoDTO> listAll() throws Exception{
        List<TodoVO> voList = dao.selectAll();
        log.info("volist");
        log.info(voList);

        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }
}
