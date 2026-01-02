CREATE TABLE tbl_activity (
                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                              name VARCHAR(20) NOT NULL,
                              date DATE NOT NULL,
                              status VARCHAR(20) NOT NULL,
                              type VARCHAR(20) NOT NULL,
                              ministerio_id BIGINT NOT NULL
);

CREATE TABLE tbl_activity_members (
                                  id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                  activity_id BIGINT NOT NULL,
                                  member_id BIGINT NOT NULL
);
