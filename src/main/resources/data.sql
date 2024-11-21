-- employees
INSERT INTO employees(name, surname) VALUES ('Admin', 'Adminowsky');
INSERT INTO employees(name, surname) VALUES ('Test', 'Testowy');

-- roles
INSERT INTO roles(description, name) VALUES ('Full access', 'admin');
INSERT INTO roles(description, name) VALUES ('Employee access', 'employee');

-- users
INSERT INTO
    users(email, password, employee_id, role_id)
VALUES
    ('admin@admin.admin', '{noop}admin', 1, 1);
INSERT INTO
    users(email, password, employee_id, role_id)
VALUES
    ('test@test.test', '{noop}test', 2, 2);