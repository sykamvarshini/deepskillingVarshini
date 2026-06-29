
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
 UPDATE accounts SET balance=balance*1.01 WHERE account_type='SAVINGS';
END;
/
CREATE OR REPLACE PROCEDURE TransferFunds(src NUMBER,dst NUMBER,amt NUMBER) AS
 bal NUMBER;
BEGIN
 SELECT balance INTO bal FROM accounts WHERE account_id=src;
 IF bal>=amt THEN
  UPDATE accounts SET balance=balance-amt WHERE account_id=src;
  UPDATE accounts SET balance=balance+amt WHERE account_id=dst;
 END IF;
END;
/
