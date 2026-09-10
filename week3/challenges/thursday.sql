-- 1. Get all invoice ids with the customers first name, last name, and the invoice total​

SELECT i.invoice_id, c.first_name, c.last_name, i.total FROM customer c
INNER JOIN invoice i ON c.customer_id = i.customer_id;

-- 2. Print the invoice id, customer's first name, and invoice total. But only if the invoice is over $30.​

SELECT i.invoice_id,c.first_name,i.total FROM customer c
INNER JOIN invoice i ON c.customer_id = i.customer_id
WHERE i.total > 30;

-- 3. Get all the invoices for USA customers in the last 6 months. Use a CTE. ​

WITH customers_in_usa AS (
	SELECT customer_id FROM customer WHERE country = 'USA'
) 
SELECT * FROM invoice 
WHERE customer_id IN (SELECT customer_id FROM customers_in_usa) AND invoice_date > (NOW() - INTERVAL '6 months');