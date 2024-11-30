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
('2024-11-01', 1, 'Холодильник', 45000.00),
('2024-11-02', 2, 'Телевизор', 55000.00),
('2024-11-03', 3, 'Стиральная машина', 32000.00),
('2024-11-04', 4, 'Микроволновая печь', 8000.00),
('2024-11-05', 5, 'Компьютер', 75000.00);