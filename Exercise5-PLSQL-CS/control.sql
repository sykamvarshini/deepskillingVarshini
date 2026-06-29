SET SERVEROUTPUT ON;

BEGIN
   FOR c IN (SELECT customer_id, age FROM customers) LOOP
      IF c.age > 60 THEN
         UPDATE loans
         SET interest_rate = interest_rate - 1
         WHERE customer_id = c.customer_id;

         DBMS_OUTPUT.PUT_LINE('Discount applied to Customer ID: ' || c.customer_id);
      END IF;
   END LOOP;

   COMMIT;
END;
/