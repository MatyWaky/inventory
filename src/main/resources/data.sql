-- employees
INSERT INTO
    employees(name, surname)
VALUES
    ('Admin', 'Adminowsky'),
    ('Test', 'Testowy');

-- roles
INSERT INTO
    roles(description, name)
VALUES
    ('Full access', 'admin'),
    ('Employee access', 'employee');

-- users
INSERT INTO
    users(email, password, employee_id, role_id)
VALUES
    ('admin@admin.admin', '{noop}admin', 1, 1),
    ('test@test.test', '{noop}test', 2, 2);

-- countries
INSERT INTO
    countries(iso_code, name)
VALUES
    ('PL', 'Poland');

-- cities
INSERT INTO
    cities(name, country_id)
VALUES
    ('Łódź', 1);

-- buildings
INSERT INTO
    buildings(name, street, city_id)
VALUES
    ('Headquarters', 'Main 34', 1);

-- localizations
INSERT INTO
    localizations(room, building_id)
VALUES
    ('1', 1);

-- categories
INSERT INTO
    categories(description, name)
VALUES
    ('IT items such as computers, laptops etc.', 'IT');

-- statuses
INSERT INTO
    statuses(description, name)
VALUES
    ('The item is currently in use, actively serving its intended purpose', 'Used'),
    ('The item has been handed over to another person/organization etc.', 'Transferred'),
    ('The item has been permanently discarded or destroyed', 'Disposed'),
    ('The item has been harmed or broken, affecting its functionality or appearance', 'Damaged');

-- products
-- Timestamp - YYYY-MM-DD HH:MM:SS
INSERT INTO
    products(added_date, comment, name, price, removed_date, category_id, employee_id, localization_id, status_id, serial_number, inventory_number, document)
VALUES
    ('2024-11-21 12:00:00',
     null,
     'DELL Computer',
     4500.00,
     null,
     1,
     1,
     1,
     1,
     'AXC123DASI',
     '00000001',
     'DOC/INV/A/1'
    );
