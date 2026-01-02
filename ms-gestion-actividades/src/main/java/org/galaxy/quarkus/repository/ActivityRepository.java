package org.galaxy.quarkus.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.galaxy.quarkus.model.entity.ActivityEntity;

@ApplicationScoped
public class ActivityRepository implements PanacheRepository<ActivityEntity> {

    public void save(ActivityEntity activity) {
        persist(activity);
    }
}