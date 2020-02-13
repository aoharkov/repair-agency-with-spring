INSERT INTO repair_stages (name)
VALUES ('Waiting for its turn');

INSERT INTO repair_stages (name)
VALUES ('Teardown');

INSERT INTO repair_stages (name)
VALUES ('Parts Ordering');

INSERT INTO repair_stages (name)
VALUES ('Structural Repair');

INSERT INTO repair_stages (name)
VALUES ('Body Repair');

INSERT INTO repair_stages (name)
VALUES ('Refinishing and Painting');

INSERT INTO repair_stages (name)
VALUES ('Reassembly');

INSERT INTO repair_stages (name)
VALUES ('Finished');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Alex', 'Kr.', 'alex@gmail.com', '$2a$10$zsXYMYK3GxuGghmwrAQWVO5wpK2oQpfpc8KKJvypzIhPsBZLK63TK', 'MASTER');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Anatolii', 'K.', 'anatolii@gmail.com', '$2a$10$Bcej5u/3CoKDDbsYhAC.B.IAy39xQKU0KY8GrGnlu1mJUUUw9tgve',
        'CLIENT');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Artem', 'Oh.', 'artem@gmail.com', '$2a$10$Z..BQCkXXeuI3PqtvUexWuTO3NU8P13wFqmgLNz737qqGWFZN7B0C', 'ADMIN');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Bohdan', 'K.', 'bohdan@gmail.com', '$2a$10$97DFSDWuGbR66gYw5J.jxugMIMsCuECIyZPnp5w6ULCsFw5ung/Cq', 'MASTER');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Dmytro', 'Pr.', 'dmytro.pr@gmail.com', '$2a$10$KTJuvjXIaXdHhrGHlM41Y.zIqZ2gTi4Tz2szKtjYPeBHvwglOOO0.',
        'CLIENT');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Dmytro', 'St.', 'dmytro@gmail.com', '$2a$10$yYE9GRCJrfSzBtpsQdBGkeUWqAgcmjSbzWTtsDHC.xZMdvLaXOUru', 'CLIENT');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Elizabeth', 'V.', 'elizabeth@gmail.com', 'elizabeth@gmail.com', 'MANAGER');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Evhenii', 'Shm.', 'evhenii@gmail.com', 'evhenii@gmail.com', 'CLIENT');

INSERT INTO users (name, surname, email, password, role)
VALUES ('George', 'Ch.', 'george@gmail.com', 'george@gmail.com', 'CLIENT');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Ihor', 'P.', 'ihor@gmail.com', 'ihor@gmail.com', 'MASTER');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Ivan', 'M.', 'ivan@gmail.com', 'ivan@gmail.com', 'CLIENT');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Kateryna', 'B.', 'kateryna@gmail.com', 'kateryna@gmail.com', 'MANAGER');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Nikita', 'K.', 'nikita@gmail.com', 'nikita@gmail.com', 'MASTER');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Olena', 'P.', 'olena@gmail.com', 'olena@gmail.com', 'MANAGER');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Olha', 'B.', 'olha@gmail.com', 'olha@gmail.com', 'CLIENT');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Stanislav', 'S.', 'stanislav@gmail.com', 'stanislav@gmail.com', 'CLIENT');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Viktor', 'Ovs.', 'viktor@gmail.com', 'viktor@gmail.com', 'MASTER');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Viktoriia', 'Ol.', 'viktoriia@gmail.com', 'viktoriia@gmail.com', 'CLIENT');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Vitalii', 'Iv.', 'vitalii@gmail.com', 'vitalii@gmail.com', 'CLIENT');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Vitalii', 'V.', 'vitalii.v@gmail.com', 'vitalii.v@gmail.com', 'CLIENT');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Yurii', 'M.', 'yurii@gmail.com', 'yurii@gmail.com', 'CLIENT');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Yuriy', 'D.', 'yuriy@gmail.com', 'yuriy@gmail.com', 'MASTER');

INSERT INTO requests (client_id, description, viewed, accepted)
VALUES (1, 'Change color of the car to red', 1, 0);

INSERT INTO refusals (request_id, explanation, manager_id)
VALUES (1, 'You can have a car painted any color that you want so long as it is black', 2);

INSERT INTO feedback (request_id, text, score)
VALUES (1, 'Did not accepted my request(', 1);

INSERT INTO requests (client_id, description, viewed, accepted)
VALUES (1, 'Change color of the car to black', 1, 1);

INSERT INTO orders (request_id, manager_id, price, master_id, repair_stage_id)
VALUES (2, 2, 4500, 3, 8);


