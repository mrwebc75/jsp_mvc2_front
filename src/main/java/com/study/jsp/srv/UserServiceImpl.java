package com.study.jsp.srv;

import java.util.Map;

import org.modelmapper.ModelMapper;

import com.study.jsp.dao.UserMapper;
import com.study.jsp.model.UserDTO;
import com.study.jsp.model.UserVO;
import com.study.jsp.util.MapperUtil;

public class UserServiceImpl implements UserService {

  // userDao 객체를 이용해서 작업
  private UserMapper userDao;
  private ModelMapper modelMapper;

  public UserServiceImpl(UserMapper userDao) {
    this.userDao = userDao;
    this.modelMapper = MapperUtil.INSTANCE.getModelMapper();
  }

  @Override
  public UserDTO getOne(Map<String, String> loginInfo) {

    System.out.println(loginInfo.get("userid"));
    System.out.println(loginInfo.get("password"));

    UserVO vo = userDao.getOne(loginInfo);

    UserDTO dto = null;

    // vo를 dto로 변환해서 리턴
    if (vo != null) {

      // 방법2
      dto = modelMapper.map(vo, UserDTO.class);// 앞의것을 뒤의 형식으로 변환

      // 방법1
//      dto = new UserDTO();
//      dto.setName(vo.getName());
//      dto.setPassword(vo.getPassword());
//      dto.setUserid(vo.getUserid());
//      dto.setRole(vo.getRole());

    }

    return dto;
  }

}
