package org.galaxy.quarkus.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.galaxy.quarkus.model.entity.ActivityMemberEntity;

import java.util.List;

@ApplicationScoped
public class ActivityMemberEntityRepository implements PanacheRepository<ActivityMemberEntity> {

    public void save(ActivityMemberEntity activity) {
        persist(activity);
    }

    public List<ActivityMemberEntity> findByActivityId(Long activityId) {
        return list("activityId", activityId);
    }
}
