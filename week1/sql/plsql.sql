CREATE OR REPLACE PROCEDURE CalculateAnnualSalary (
    emp_id IN NUMBER
)
IS
    monthly_salary NUMBER;
    annual_salary NUMBER;
BEGIN
    SELECT salary
    INTO monthly_salary
    FROM employees
    WHERE employee_id = emp_id;

    annual_salary := monthly_salary * 12;

    DBMS_OUTPUT.PUT_LINE('Employee ID: ' || emp_id);
    DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || annual_salary);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee not found');
END;
/