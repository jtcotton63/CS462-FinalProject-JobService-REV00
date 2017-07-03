DROP TABLE IF EXISTS jobs.job;

CREATE TABLE jobs.job (
	id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	address VARCHAR(255) NOT NULL,
	description VARCHAR(2000) NOT NULL,
	job_time TIMESTAMP NOT NULL,
	rendevous_time TIMESTAMP NOT NULL,
	accepted_by BIGINT(20),
	completed BOOLEAN NOT NULL,
	CONSTRAINT jobs_job_accepted_by_to_helpers_helper_id FOREIGN KEY (accepted_by) REFERENCES helpers.helper(id)
);