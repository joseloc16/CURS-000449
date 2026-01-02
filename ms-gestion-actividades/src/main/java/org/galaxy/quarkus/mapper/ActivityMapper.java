package org.galaxy.quarkus.mapper;

import org.galaxy.quarkus.model.dto.CreateActivityRequestDTO;
import org.galaxy.quarkus.model.entity.ActivityEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
    componentModel = "cdi",
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    builder = @Builder(disableBuilder = true)
)
public interface ActivityMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "date", source = "activityDate")
    @Mapping(target = "type", source = "activityType")
    @Mapping(target = "ministryId", source = "ministryId")
    @Mapping(target = "status", constant = "PROGRAMADA")
    ActivityEntity toActivityEntity(CreateActivityRequestDTO dto);
}