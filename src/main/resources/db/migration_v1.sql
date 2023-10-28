CREATE TABLE users (
  id bigserial PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  linkedin VARCHAR(255),
  youtube VARCHAR(255),
  facebook VARCHAR(255),
  instagram VARCHAR(255),
  profile_pic_url VARCHAR(255),
  profession VARCHAR(100),
  about_me VARCHAR(500),
  created_date TIMESTAMP NOT NULL,
  updated_date TIMESTAMP
);

CREATE TABLE courses (
  id bigserial PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  sub_title VARCHAR(255) not NULL,
  main_picture_url VARCHAR(255) NOT NULL,
  presentation_video_url VARCHAR(255) not NULL,
  punctuation DOUBLE PRECISION,
  grade_count INTEGER,
  students_count INTEGER,
  creator_id BIGINT,
  language VARCHAR(50) not NULL,
  skills_to_learn text not NULL,
  sections_count INTEGER,
  classes_count INTEGER,
  minutes_count INTERVAL,
  created_date TIMESTAMP not NULL,
  updated_date TIMESTAMP,
  certification BOOLEAN not NULL,
  requirements VARCHAR,
  description VARCHAR,
  course_is_for VARCHAR not NULL,
    CONSTRAINT creator_id_fk FOREIGN KEY (creator_id) REFERENCES users(id)
);

CREATE TABLE sections (
    id bigserial PRIMARY KEY,
    course_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    classes_count INTEGER,
    minutes_count INTERVAL,
    CONSTRAINT course_id_fk FOREIGN KEY (course_id) REFERENCES courses(id)
);

CREATE TABLE section_classes (
    id bigserial PRIMARY KEY,
    section_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    minutes_count interval not NULL,
    video_url VARCHAR(255) not NULL,
    CONSTRAINT section_id_fk FOREIGN KEY (section_id) REFERENCES sections(id)
);
