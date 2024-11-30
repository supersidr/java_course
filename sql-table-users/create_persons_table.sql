CREATE TABLE PERSONS (
    name VARCHAR(50),
    surname VARCHAR(50),
    age INT,
    phone_number VARCHAR(15),
    city_of_living VARCHAR(50),
    PRIMARY KEY (name, surname, age)
);

INSERT INTO PERSONS (name, surname, age, phone_number, city_of_living) VALUES
('Иван', 'Иванов', 34, '89012345678', 'Москва'),
('Ольга', 'Петрова', 29, '89023456789', 'Санкт-Петербург'),
('Алексей', 'Смирнов', 45, '89034567890', 'Казань'),
('Мария', 'Кузнецова', 22, '89045678901', 'Новосибирск'),
('Дмитрий', 'Попов', 37, '89056789012', 'Екатеринбург');