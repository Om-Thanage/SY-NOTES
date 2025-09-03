CREATE TABLE cars (
    id SERIAL PRIMARY KEY,
    brand VARCHAR(50),
    model VARCHAR(50),
    year INT,
    price DECIMAL(10,2),
    fuel_type VARCHAR(20)
);

INSERT INTO cars (brand, model, year, price, fuel_type) VALUES
('Toyota', 'Corolla', 2022, 22000.00, 'Petrol'),
('Honda', 'Civic', 2021, 25000.00, 'Petrol'),
('Ford', 'Mustang', 2020, 35000.00, 'Petrol'),
('Tesla', 'Model 3', 2023, 40000.00, 'Electric'),
('BMW', 'X5', 2019, 50000.00, 'Diesel'),
('Mercedes', 'C-Class', 2021, 48000.00, 'Petrol'),
('Audi', 'A4', 2020, 45000.00, 'Petrol'),
('Hyundai', 'Elantra', 2022, 21000.00, 'Petrol'),
('Kia', 'Sportage', 2021, 27000.00, 'Petrol'),
('Nissan', 'Altima', 2018, 19000.00, 'Petrol');

SELECT * FROM cars;


/*RollBack*/
begin;
DELETE FROM cars where id=2;
savepoint s2;
rollback;
DELETE FROM cars where id=2;
commit;




INSERT INTO cars (brand, model, year, price, fuel_type) VALUES
('Chevrolet', 'Camaro', 2021, 37000.00, 'Petrol'),
('Volkswagen', 'Golf', 2020, 23000.00, 'Petrol'),
('Subaru', 'Outback', 2022, 28000.00, 'Petrol');

/*SavePoint*/
savepoint s1;

INSERT INTO cars (brand, model, year, price, fuel_type) VALUES
('Jeep', 'Wrangler', 2019, 32000.00, 'Petrol'),
('Lexus', 'RX 350', 2023, 45000.00, 'Hybrid');

rollback to s1;
rollback to s2;








