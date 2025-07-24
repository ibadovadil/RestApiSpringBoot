INSERT INTO user_details (id, brith_date, name) VALUES (10001, CURRENT_DATE(), 'Adil');
INSERT INTO user_details (id, brith_date, name) VALUES (10002, '1990-05-15', 'Elvin');
INSERT INTO user_details (id, brith_date, name) VALUES (10003, '1985-11-23', 'Leyla');
INSERT INTO user_details (id, brith_date, name) VALUES (10004, '2001-03-01', 'Fidan');
INSERT INTO user_details (id, brith_date, name) VALUES (10005, '1978-08-09', 'Nijat');

INSERT INTO post(id, title, user_id) VALUES (10001, 'First Post', 10001);
INSERT INTO post(id, title, user_id) VALUES (10002, 'My Second Article', 10001);
INSERT INTO post(id, title, user_id) VALUES (10003, 'A Day in the Life', 10002);
INSERT INTO post(id, title, user_id) VALUES (10004, 'New Beginnings', 10002);
INSERT INTO post(id, title, user_id) VALUES (10005, 'Travel Adventures', 10003);
INSERT INTO post(id, title, user_id) VALUES (10006, 'Cooking Recipes', 10003);
INSERT INTO post(id, title, user_id) VALUES (10007, 'Tech Talk', 10004);
INSERT INTO post(id, title, user_id) VALUES (10008, 'Fitness Journey', 10004);
INSERT INTO post(id, title, user_id) VALUES (10009, 'Book Review: The Great Novel', 10005);
INSERT INTO post(id, title, user_id) VALUES (10010, 'Exploring Local History', 10005);

-- for h2 database