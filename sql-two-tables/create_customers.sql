CREATE TABLE CUSTOMERS (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    phone_number VARCHAR(15) NOT NULL
);

INSERT INTO CUSTOMERS (name, surname, age, phone_number)
VALUES 
('Алексей', 'Иванов', 32, '+79001234567'),
('Мария', 'Смирнова', 28, '+79007654321'),
('Дмитрий', 'Кузнецов', 40, '+79161234567'),
('Елена', 'Попова', 35, '+79157654321'),
('Иван', 'Соколов', 45, '+79261234567');