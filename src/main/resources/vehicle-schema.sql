drop table if exists animals CASCADE;
CREATE TABLE animals (
    id BIGINT AUTO_INCREMENT,
    numberOfWheels INTEGER NOT NULL,
    type VARCHAR(255),
    color VARCHAR(255),
    PRIMARY KEY (id)
);