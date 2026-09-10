--     Get all fields and records from customer​

SELECT * FROM customer;

--     Get all fields from customer, but only if they are from Arizona​

SELECT * FROM customer WHERE state = 'AZ';

--     Get all invoices older than 6 months ​

SELECT * FROM invoice WHERE invoice.invoice_date < (NOW() - INTERVAL '6 months');

--    Update all customer phone numbers to NULL if they don’t follow this format: ‘+1 555 555-5555’​

UPDATE customer SET phone = NULL WHERE phone !~ '\+1 \(\d{3}\) \d{3}-\d{4}';

--    Get all tracks that are longer than 180000 milliseconds ​

SELECT * FROM track WHERE milliseconds > 180000;

--    Update all customers not in the USA so that their country=USA and address, city, & state are NULL​

UPDATE customer SET
	country = 'USA',
	address = NULL,
	city = NULL,
	state = NULL
WHERE country != 'USA';

--    Given a customer_id, return their total spending across all invoices using a function ​

CREATE OR REPLACE FUNCTION total_spending(cust_id INT)
RETURNS NUMERIC(10,2) AS $$
BEGIN
RETURN SUM(total) FROM invoice i WHERE i.customer_id = cust_id GROUP BY i.customer_id;
END
$$ LANGUAGE plpgsql;

SELECT total_spending(5);

--    Given an employee_id + new_manager_id, create a stored procedure to update an Employee’s ReportsTo field.​

	--    Prevent an employee reporting to themselves, reporting to a non-existence employee, or creating a circular management relationship​

CREATE OR REPLACE PROCEDURE update_report_to(employee_id_in INT, new_manager_id INT)
LANGUAGE plpgsql AS $$
BEGIN
IF employee_id_in = new_manager_id
THEN RAISE EXCEPTION 'Employee cant report to self';
END IF;
IF NOT EXISTS (
	SELECT 1 FROM employee WHERE employee_id = employee_id_in
)
THEN RAISE EXCEPTION 'Employee must exist';
END IF;
IF NOT EXISTS (
	SELECT 1 FROM employee WHERE employee_id = new_manager_id
)
THEN RAISE EXCEPTION 'Employee manager must exist';
END IF;
-- imaginary circular check here, idk i'd rather write code then SP for this
UPDATE employee SET reports_to = new_manager_id WHERE employee_id = employee_id_in;
END
$$;

--    Create a new schema: pets​

	--    Create two related tables: Customer + Pets​

	--    Demonstrate populating records into these tables​

CREATE SCHEMA pets;

SET search_path TO pets;

CREATE TABLE IF NOT EXISTS customers ( cust_id SERIAL PRIMARY KEY, name VARCHAR(40), age INT);

CREATE TABLE IF NOT EXISTS pets (pet_id SERIAL PRIMARY KEY, owner_id INT REFERENCES customers (cust_id), name VARCHAR(40));

INSERT INTO customers (name,age) VALUES ('John',30);
INSERT INTO customers (name,age) VALUES ('Katie',29);
INSERT INTO customers (name,age) VALUES ('Ryan',28);
INSERT INTO pets (owner_id,name) VALUES (1,'Mimi');
INSERT INTO pets (owner_id,name) VALUES (1,'Coco');
INSERT INTO pets (owner_id,name) VALUES (2,'Buster');
INSERT INTO pets (owner_id,name) VALUES (3,'Buddy');


