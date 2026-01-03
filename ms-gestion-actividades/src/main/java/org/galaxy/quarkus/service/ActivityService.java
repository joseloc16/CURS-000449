package org.galaxy.quarkus.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.galaxy.quarkus.dao.impl.MemberDaoImpl;
import org.galaxy.quarkus.mapper.ActivityMapper;
import org.galaxy.quarkus.model.dto.*;
import org.galaxy.quarkus.model.entity.ActivityEntity;
import org.galaxy.quarkus.model.entity.ActivityMemberEntity;
import org.galaxy.quarkus.repository.ActivityMemberEntityRepository;
import org.galaxy.quarkus.repository.ActivityRepository;

import java.util.List;

@ApplicationScoped
public class ActivityService {

    @Inject
    ActivityMapper mapper;

    @Inject
    ActivityRepository activityRepository;

    @Inject
    ActivityMemberEntityRepository activityMemberRepository;

    @Inject
    MemberDaoImpl memberDao;

    @Transactional
    public CreateActivityResponseDTO recordActivity(CreateActivityRequestDTO dto) {

        ActivityEntity activity = mapper.toActivityEntity(dto);
        activityRepository.save(activity);

        Long activityId = activity.getId();

        if (dto.getMembersIds() != null && !dto.getMembersIds().isEmpty()) {
            dto.getMembersIds().forEach(memberId -> {
                ActivityMemberEntity am = new ActivityMemberEntity();
                am.setActivityId(activityId);
                am.setMemberId(memberId);
                activityMemberRepository.save(am);
            });
        }

        return mapper.toCreateActivityResponseDTO(activity);
    }

    public List<ActivityListResponseDTO> findAllActivities() {
        List<ActivityEntity> activities = activityRepository.listAll();
        return mapper.toActivityListResponseDTOs(activities);
    }

    @Transactional
    public UpdateActivityStatusResponseDTO updateActivityStatus(Long id, String status) {
        ActivityEntity activity = activityRepository.findByIdOptional(id)
            .orElseThrow(() -> new NotFoundException("Activity not found"));

        activity.setStatus(status);

        return new UpdateActivityStatusResponseDTO("Activity status updated to: " + status);
    }

    public ActivityDetailResponseDTO getActivityDetail(Long activityId) {

        ActivityEntity activity = activityRepository.findByIdOptional(activityId)
            .orElseThrow(() -> new NotFoundException("Activity not found"));

        List<ActivityMemberEntity> relations =
            activityMemberRepository.findByActivityId(activityId);

        List<Long> memberIds = relations.stream()
            .map(ActivityMemberEntity::getMemberId)
            .toList();

        List<MemberResponse> members =
            memberIds.isEmpty() ? List.of()
                : memberDao.getMembersByIds(memberIds);

        return mapper.toActivityDetailResponseDTO(activity, members);
    }
}