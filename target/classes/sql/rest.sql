CREATE TABLE app_user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  username varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE app_role (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  role_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE user_role (
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  CONSTRAINT FK_user_role_to_app_user FOREIGN KEY (user_id) REFERENCES app_user (id),
  CONSTRAINT FK_user_role_to_app_role_ FOREIGN KEY (role_id) REFERENCES app_role (id)
);


/*
Records
*/
INSERT INTO app_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Can request only math operations using JWT');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Can access to any endpoint');

INSERT INTO app_user (id,username,password) VALUES (1,'josue','$2y$12$Uq5Gy3lFodYndem9WDT4UeC6XvBc6czO/J73rffF.Bwr0alHqsKNG');
INSERT INTO app_user (id,username,password) VALUES (2,'admin','$2y$12$CjfiQd1A9ygku44duJnyZecFh2jYdwQMiP6hqtdxvF2OlTCO7YDum');

INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);



