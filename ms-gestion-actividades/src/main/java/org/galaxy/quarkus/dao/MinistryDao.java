package org.galaxy.quarkus.dao;

import org.galaxy.quarkus.model.dto.MinistrySummaryDTO;

public interface MinistryDao {
    MinistrySummaryDTO getMinistry(Long id);
}