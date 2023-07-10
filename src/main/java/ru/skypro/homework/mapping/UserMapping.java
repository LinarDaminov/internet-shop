package ru.skypro.homework.mapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.UserDTO;
import ru.skypro.homework.model.Avatar;
import ru.skypro.homework.model.User;

@Mapper(componentModel = "spring")
public interface UserMapping {
    String USER_AVATAR = "/users/avatar/";
    UserMapping INSTANCE = Mappers.getMapper(UserMapping.class);

    @Mapping(target = "image", source = "avatar", qualifiedByName = "avatarMapping")
    UserDTO toDTO(User user);

    @Named("avatarMapping")
    default String avatarMapping(Avatar avatar) {
        if (avatar == null) {
            return null;
        }
        return USER_AVATAR + avatar.getId();
    }
}
