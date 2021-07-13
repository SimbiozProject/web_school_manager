CREATE TABLE `crm_registration` (
                                    `user_id` bigint NOT NULL,
                                    `city_name` varchar(255) DEFAULT NULL,
                                    `country_name` varchar(255) DEFAULT NULL,
                                    `date_of_birth` varchar(255) DEFAULT NULL,
                                    `e_mail` varchar(255) DEFAULT NULL,
                                    `first_name` varchar(255) DEFAULT NULL,
                                    `last_name` varchar(255) DEFAULT NULL,
                                    `phone_number` varchar(255) DEFAULT NULL,
                                    `user_name` bigint NOT NULL,
                                    PRIMARY KEY (`user_id`),
                                    KEY (`user_name`),
                                    CONSTRAINT FOREIGN KEY (`user_name`) REFERENCES `tg_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO bot.crm_registration (user_id, city_name, country_name, date_of_birth, e_mail, first_name, last_name, phone_number, user_name) VALUES ((1, 'Minsk', 'Belarus', '1978-07-27', 'qwerty@mail.ru', 'Vova', 'Wef', '1234567', 1),
                                                                                                                                                    (2, 'Moscow', 'Russia', '2002-03-11', 'dfghj@gmail.com', 'Katya', 'Wash', '4534545', 2),
                                                                                                                                                    (3, 'Minsk', 'Belarus', '1992-07-23', 'zxcvbn@gmail.com', 'Luda', 'Tyk', '5675674', 3),
                                                                                                                                                    (4, 'Kiev', 'Ukraine', '1991-07-01', 'plkmokmok@gmail.com', 'Olga', 'Lop', '2345675', 4),
                                                                                                                                                    (5, 'Kiev', 'Ukraine', '2000-07-28', 'debbvvg@mail.ru', 'Denis', 'Bam', '5457890', 5));

CREATE TABLE `tg_user` (
                           `id_user` bigint NOT NULL,
                           `active` bit(1) DEFAULT NULL,
                           `block_user` bit(1) DEFAULT NULL,
                           `date_of_birthday` date DEFAULT NULL,
                           `email` varchar(255) NOT NULL,
                           `first_name` varchar(255) DEFAULT NULL,
                           `last_name` varchar(255) DEFAULT NULL,
                           `payment` bit(1) DEFAULT NULL,
                           `role` varchar(255) DEFAULT NULL,
                           `user_name` varchar(255) DEFAULT NULL,
                           `course_name` bigint DEFAULT NULL,
                           `group_number` bigint DEFAULT NULL,
                           PRIMARY KEY (`id_user`),
                           UNIQUE KEY (`email`),
                           UNIQUE KEY (`user_name`),
                           KEY (`course_name`),
                           KEY (`group_number`),
                           CONSTRAINT FOREIGN KEY (`group_number`) REFERENCES `student_group` (`group_id`),
                           CONSTRAINT FOREIGN KEY (`course_name`) REFERENCES `courses` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO bot.tg_user (id_user, active, block_user, date_of_birthday, email, first_name, last_name, payment, role, user_name, course_name, group_number) VALUES ((1, true, false, '1978-07-27', 'qwerty@mail.ru', 'Vova', 'Wef', true, 'user', 'qaz', 1, 1),
                                                                                                                                                                    (2, true, false, '2002-03-11', 'dfghj@gmail.com', 'Katya', 'Wash', true, 'admin', 'wsx', 2, 2),
                                                                                                                                                                    (3, true, false, '1992-07-23', 'zxcvbn@gmail.com', 'Luda', 'Tyk', true, 'teacher', 'edc', 3, 3),
                                                                                                                                                                    (4, true, false, '1991-07-01', 'plkmokmok@gmail.com', 'Olga', 'Lop', true, 'student', 'rfv', 4, 4),
                                                                                                                                                                    (5, false, true, '2000-07-28', 'debbvvg@mail.ru', 'Denis', 'Bam', false, 'student', 'tgb', 3, 3));

CREATE TABLE `student_group` (
                                 `group_id` bigint NOT NULL,
                                 `group_number` bigint DEFAULT NULL,
                                 `course_name` bigint DEFAULT NULL,
                                 PRIMARY KEY (`group_id`),
                                 KEY (`course_name`),
                                 CONSTRAINT FOREIGN KEY (`course_name`) REFERENCES `courses` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO bot.student_group (group_id, group_number, course_name) VALUES ((1, 11, 1),
                                                                            (2, 10, 2),
                                                                            (3, 9, 3),
                                                                            (4, 8, 4),
                                                                            (5, 7, 5));

CREATE TABLE `courses` (
                           `course_id` bigint NOT NULL,
                           `course_name` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO bot.courses (course_id, course_name) VALUES ((1, 'Level 0'),
                                                        (2, 'Level Advanced'),
                                                        (3, 'Level 1'),
                                                        (4, 'Level 2'),
                                                        (5, 'Level 3'));

CREATE TABLE `user_answer` (
                               `user_id` bigint NOT NULL,
                               `answer` varchar(255) DEFAULT NULL,
                               `question_id` bigint NOT NULL,
                               `user_name` bigint DEFAULT NULL,
                               PRIMARY KEY (`user_id`),
                               KEY (`question_id`),
                               KEY (`user_name`),
                               CONSTRAINT FOREIGN KEY (`question_id`) REFERENCES `question_answer` (`id`),
                               CONSTRAINT FOREIGN KEY (`user_name`) REFERENCES `tg_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO bot.user_answer (user_id, answer, question_id, user_name) VALUES ((1, '1', 1, 1),
                                                                                (2, '2', 2, 2),
                                                                                (3, '3', 3, 3),
                                                                                (4, '1', 4, 4),
                                                                                (5, '4', 5, 5));

CREATE TABLE `hw_for_students` (
                                   `hw_id` int NOT NULL,
                                   `hw_doc` varchar(255) DEFAULT NULL,
                                   `lesson_number` int DEFAULT NULL,
                                   `group_number` bigint DEFAULT NULL,
                                   PRIMARY KEY (`hw_id`),
                                   KEY (`group_number`),
                                   CONSTRAINT FOREIGN KEY (`group_number`) REFERENCES `student_group` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO bot.hw_for_students (hw_id, hw_doc, lesson_number, group_number) VALUES ((1, 'photo', 2, 1),
                                                                                    (2, 'doc', 3, 2),
                                                                                    (3, 'photo', 6, 3),
                                                                                    (4, 'photo', 7, 1),
                                                                                    (5, 'doc', 5, 4));

CREATE TABLE `hw_from_students` (
                                    `student_id` int NOT NULL,
                                    `students_hw` varchar(255) DEFAULT NULL,
                                    `lesson_number` int DEFAULT NULL,
                                    `student_name` bigint DEFAULT NULL,
                                    PRIMARY KEY (`student_id`),
                                    KEY (`student_name`),
                                    CONSTRAINT FOREIGN KEY (`student_name`) REFERENCES `tg_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO bot.hw_from_students (student_id, students_hw, lesson_number, student_name) VALUES ((1, 'doc', 4, 1),
                                                                                                (2, 'doc', 6, 2),
                                                                                                (3, 'doc', 8, 3),
                                                                                                (4, 'doc', 3, 4),
                                                                                                (5, 'photo', 5, 5));

CREATE TABLE `question_answer` (
                                   `id` bigint NOT NULL,
                                   `first_answer` varchar(255) DEFAULT NULL,
                                   `fourth_answer` varchar(255) DEFAULT NULL,
                                   `question` varchar(255) DEFAULT NULL,
                                   `right_answer` varchar(255) DEFAULT NULL,
                                   `second_answer` varchar(255) DEFAULT NULL,
                                   `third_answer` varchar(255) DEFAULT NULL,
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES ((1, 'be', 'an', '1. My favorite color _____ green.', 'is', 'are', 'is'),
                                                                                                                                (2, 'at', 'on', '2. We get up _____ 7 o’clock.', 'at', 'in', 'of'),
                                                                                                                                (3, 'a', '-', '3. There is _____ milk in the fridge.', 'some', 'some', 'the'),
                                                                                                                                (4, 'of', 'from', '4. Are you _____ Italy?', 'from', 'out', 'at'),
                                                                                                                                (5, 'symbol', '-', '5. London is the _____ of England.', 'capital', 'capital', 'country'),
                                                                                                                                (6, 'play', 'playing', '6. Last Sunday I _____ football with my friends.', 'played', 'played', 'plays'),
                                                                                                                                (7, 'the best', 'well', '7. This is _____ film I have ever seen.', 'the best', 'good', 'better'),
                                                                                                                                (8, 'do', 'will', '8. _____ I have a ticket to London?', 'can', 'should', 'should'),
                                                                                                                                (9, 'often', 'long', '9. How _____ friends do you have?', 'many', 'much', 'many'),
                                                                                                                                (10, 'that is', 'those are', '10. Excuse me, _____ my hat.', 'that is', 'those is', 'that are'),
                                                                                                                                (11, '-', 'An', '11. _____ elephants are very beautiful animals.', '-', 'There', 'A'),
                                                                                                                                (12, 'See you there', 'Nice to meet you', '12. How about going to the cinema? _____ ', 'Sounds good. What’s on?', 'Sounds good. What''s on?', 'Not a problem'),
                                                                                                                                (13, 'which', 'who', '13. She is a woman _____ helped me with a job.', 'who', 'whose', 'where'),
                                                                                                                                (14, 'said', 'talked', '14. They _____ me they would come the next day.', 'told', 'spoke', 'told'),
                                                                                                                                (15, 'getting', 'gotten', '15. I hate _____ up early in the morning.', 'getting', 'get', 'got'),
                                                                                                                                (16, 'will', 'can', '16. If I were you I _____ buy this car.', 'would', 'would', 'should'),
                                                                                                                                (17, 'so he was ill', 'but is here', '17. He didn’t go to school _____', 'although he wasn’t ill', 'because he was there', 'although he wasn’t ill'),
                                                                                                                                (18, 'on', 'in', '18. It’s not a good idea to leave electrical appliance _____ standby.', 'on', 'for', 'at'),
                                                                                                                                (19, 'up', 'of', '19. When I want to relax I put my feet _____ ', 'up', 'on', 'down'),
                                                                                                                                (20, 'obey', 'disobeying', '20. They are usually punished for _____ a teacher.', 'disobeying', 'disobey', 'obeying'),
                                                                                                                                (21, 'know', 'have been knowing', '21. I _____ her since we were teenagers.', 'have known', 'knew', 'have known'),
                                                                                                                                (22, 'When', 'As soon as', '22. _____ we came train had already departed.', 'By the time', 'By the time', 'Until'),
                                                                                                                                (23, 'to see', 'seeing', '23. I remember _____ him at work and he was tired.', 'seeing', 'see', 'saw'),
                                                                                                                                (24, 'couldn''t see', 'can''t have seen', '24. You _____ Jack in the gym because he had gone to France.', 'can’t have seen', 'can''t see', 'haven''t seen'),
                                                                                                                                (25, 'regarding', 'in order to', '25. I was frustrated at not having news _____ the interview I had had before.', 'regarding', 'relates', 'comparing with'));

CREATE TABLE `hibernate_sequence` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `statistic_user` (
                                  `chat_id` bigint NOT NULL,
                                  `active` bit(1) DEFAULT NULL,
                                  PRIMARY KEY (`chat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;