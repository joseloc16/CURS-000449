package org.galaxy.quarkus.dao;

import org.galaxy.quarkus.model.dto.MemberResponse;

import java.util.List;

public interface MemberDao {
    List<MemberResponse> getMembersByIds(List<Long> memberIds);
}