
DROP TABLE IF EXISTS url_identifier;
CREATE TABLE url_identifier(ID VARCHAR(12) PRIMARY KEY,
                 URL VARCHAR(200) NOT NULL,
                 STATUS VARCHAR(2) NOT NULL,
                 EXPIRES_AT TIMESTAMP NOT NULL
);

