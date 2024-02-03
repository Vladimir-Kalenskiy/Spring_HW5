create table tasks (
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         description VARCHAR(255) NOT NULL,
                         taskStatus VARCHAR(45) NOT NULL,
                         dateOfCreation TIMESTAMP
);