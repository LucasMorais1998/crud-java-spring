ALTER TABLE products
    ADD active BOOLEAN;
UPDATE products
SET active = true;