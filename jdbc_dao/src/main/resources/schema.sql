CREATE TABLE CUSTOMERS (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(50) NOT NULL,
                           surname VARCHAR(50) NOT NULL,
                           age INT NOT NULL,
                           phone_number VARCHAR(15) NOT NULL
);

INSERT INTO CUSTOMERS (name, surname, age, phone_number)
VALUES
    ('Alexey', 'Ivanov', 32, '+79001234567'),
    ('Maria', 'Smirnova', 28, '+79007654321'),
    ('Dmitry', 'Kuznetsova', 40, '+79161234567'),
    ('Elena', 'Popova', 35, '+79157654321'),
    ('Ivan', 'Sokolov', 45, '+79261234567');

CREATE TABLE ORDERS (
                        id SERIAL PRIMARY KEY,
                        date DATE NOT NULL,
                        customer_id INT NOT NULL,
                        product_name VARCHAR(100) NOT NULL,
                        amount DECIMAL(10, 2) NOT NULL,
                        FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(id)
);

INSERT INTO ORDERS (date, customer_id, product_name, amount)
VALUES
    ('2024-11-01', 1, 'Fridge', 45000.00),
    ('2024-11-02', 2, 'TV', 55000.00),
    ('2024-11-03', 3, 'WashMachine', 32000.00),
    ('2024-11-04', 4, 'Microvawe Owen', 8000.00),
    ('2024-11-05', 5, 'PC', 75000.00);