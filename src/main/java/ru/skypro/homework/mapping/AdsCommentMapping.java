package ru.skypro.homework.mapping;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.AdsCommentDTO;
import ru.skypro.homework.model.Avatar;
import ru.skypro.homework.model.Comment;

public interface AdsCommentMapping {
    String USER_AVATAR = "/users/avatar/";
    AdsCommentMapping INSTANSE = Mappers.getMapper(AdsCommentMapping.class);

    @Mapping(target = "author", ignore = true)
    @Mapping(target = "id", source = "pk")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "ads", ignore = true)
    Comment toEntity(AdsCommentDTO dto);

    @Mapping(target = "author", source = "author.id")
    @Mapping(target = "authorFirstName", source = "author.firstName")
    @Mapping(target = "authorImage", source = "author.avatar", qualifiedByName = "avatarMapping")
    @Mapping(target = "pk", source = "id")
    @Mapping(target = "createdAt", source = "createdAt")
    AdsCommentDTO toDTO(Comment entity);

    @Named("avatarMapping")
    default String avatarMapping(Avatar avatar) {
        if (avatar == null) {
            return null;
        }
        return USER_AVATAR + avatar.getId();
    }
}
