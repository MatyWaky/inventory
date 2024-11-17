INSERT INTO employees(name, surname) VALUES ('Admin', 'Adminowsky');
INSERT INTO roles(description, name) VALUES ('Full access', 'admin');

INSERT INTO
    users(email, password, employee_id, role_id)
VALUES
    ('admin@admin.admin', '$2a$10$wXsq1mRlX1ySkpqyEDUpNDozv/5r5tS/DezJOfYZizg5g9vJz9sZ2', 1, 1);
