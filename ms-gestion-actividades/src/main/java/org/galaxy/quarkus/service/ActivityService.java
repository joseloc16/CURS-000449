package org.galaxy.quarkus.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.galaxy.quarkus.mapper.ActivityMapper;
import org.galaxy.quarkus.model.dto.CreateActivityRequestDTO;
import org.galaxy.quarkus.model.dto.CreateActivityResponseDTO;
import org.galaxy.quarkus.model.entity.ActivityEntity;
import org.galaxy.quarkus.model.entity.ActivityMemberEntity;
import org.galaxy.quarkus.repository.ActivityMemberEntityRepository;
import org.galaxy.quarkus.repository.ActivityRepository;

@ApplicationScoped
public class ActivityService {

    @Inject
    ActivityMapper activityMapper;

    @Inject
    ActivityRepository activityRepository;

    @Inject
    ActivityMemberEntityRepository activityMemberEntityRepository;

    @Transactional
    public CreateActivityResponseDTO recordActivity(CreateActivityRequestDTO dto) {

        ActivityEntity activity = activityMapper.toActivityEntity(dto);
        activityRepository.save(activity);

        Long activityId = activity.getId();

        if (dto.getMembersIds() != null && !dto.getMembersIds().isEmpty()) {
            dto.getMembersIds().forEach(memberId -> {
                ActivityMemberEntity am = new ActivityMemberEntity();
                am.setActivityId(activityId);
                am.setMemberId(memberId);
                activityMemberEntityRepository.save(am);
            });
        }

        return null;
    }
}