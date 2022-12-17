package com.airfrance.test.mapper;

import com.airfrance.test.dto.UserDto;
import com.airfrance.test.model.User;
import org.mapstruct.Mapper;

/**
 * User Mapper for transforming from User to UserDto and vice versa
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
/**
 * UserDto to User mapper method
 * @param userDto
 * @return User
 */
    User userDtoToUser(UserDto userDto);

/**
 * User to to USerDto mapper method
 * @param user
 * @return UserDto
 */
    UserDto userToUserDto(User user);
}