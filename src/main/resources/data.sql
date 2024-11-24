-- employees
INSERT INTO
    employees(name, surname)
VALUES
    ('Admin', 'Adminowsky'),
    ('Test', 'Testowy'),
    ('John', 'Doe'),
    ('Jane', 'Smith'),
    ('Michael', 'Johnson'),
    ('Emily', 'Davis'),
    ('Daniel', 'Miller');

-- roles
INSERT INTO
    roles(description, name)
VALUES
    ('Full access', 'admin'),
    ('Employee access', 'employee'),
    ('User access', 'user');

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
    ('PL', 'Poland'),
    ('US', 'United States'),
    ('DE', 'Germany'),
    ('FR', 'France');

-- cities
INSERT INTO
    cities(name, country_id)
VALUES
    ('Łódź', 1),
    ('Piotrków Trybunalski', 1),
    ('Warsaw', 1),
    ('Kraków', 1),
    ('Gdańsk', 1),
    ('Wrocław', 1),
    ('New York', 2),
    ('Los Angeles', 2),
    ('Berlin', 3),
    ('Munich', 3),
    ('Paris', 4);

-- buildings
INSERT INTO
    buildings(name, street, city_id)
VALUES
    ('Headquarters', 'Main 34', 1),
    ('Tech Hub', 'Tech Street 22', 2),
    ('Research Center', 'Innovation Blvd 5', 3),
    ('Sales Office', 'Sales Ave 18', 4),
    ('Operations Building', 'Business Rd 12', 5);

-- localizations
INSERT INTO
    localizations(room, building_id)
VALUES
    ('1', 1),
    ('2', 1),
    ('3', 1),
    ('4', 1),
    ('5', 2),
    ('6', 2),
    ('7', 3),
    ('8', 3),
    ('9', 4),
    ('10', 5);

-- categories
INSERT INTO
    categories(description, name)
VALUES
    ('IT items such as computers, laptops etc.', 'IT'),
    ('Furniture and office equipment', 'Office Furniture'),
    ('Software and digital tools', 'Software'),
    ('Tools for manufacturing', 'Tools'),
    ('Stationery and small office supplies', 'Stationery'),
    ('Vehicles for business purposes', 'Vehicles'),
    ('Security equipment', 'Security'),
    ('Appliances for the office', 'Appliances'),
    ('Company merchandise', 'Merchandise'),
    ('Hardware for servers and data centers', 'Data Center Hardware');

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
    ('2024-11-21 12:00:00', null,'DELL Computer',4500.00,null,1,1,1,1,'AXC123DASI','00000001','DOC/INV/A/1'),
    ('2024-11-22 14:00:00', 'Ergonomic chair', 'Herman Miller Chair', 2200.00, null, 2, 2, 2, 1, 'CHAIR1234', '00000002', 'DOC/INV/A/2'),
    ('2024-11-23 09:00:00', 'Office software license', 'Microsoft Office 365', 500.00, null, 3, 3, 3, 2, 'SOFT1234', '00000003', 'DOC/INV/A/3'),
    ('2024-11-20 11:30:00', 'Company vehicle', 'Toyota Corolla', 85000.00, null, 5, 4, 4, 4, 'CAR12345', '00000004', 'DOC/INV/A/4'),
    ('2024-11-19 16:00:00', 'Security camera', 'Ring Doorbell', 300.00, null, 6, 5, 5, 3, 'SEC1234', '00000005', 'DOC/INV/A/5'),
    ('2024-11-18 08:00:00', 'Laser printer', 'HP LaserJet', 1200.00, null, 7, 6, 6, 1, 'PRINTER123', '00000006', 'DOC/INV/A/6'),
    ('2024-11-17 13:00:00', 'Desk lamp', 'Philips Desk Light', 150.00, null, 2, 7, 7, 2, 'LAMP1234', '00000007', 'DOC/INV/A/7'),
    ('2024-11-16 10:00:00', 'External hard drive', 'Seagate 1TB', 250.00, null, 1, 8, 8, 1, 'HD12345', '00000008', 'DOC/INV/A/8'),
    ('2024-11-15 14:30:00', 'Microwave oven', 'Samsung Microwave', 450.00, null, 8, 9, 9, 4, 'MICRO1234', '00000009', 'DOC/INV/A/9'),
    ('2024-11-14 17:00:00', 'Tablet', 'iPad Pro', 1200.00, null, 1, 10, 10, 2, 'IPAD12345', '00000010', 'DOC/INV/A/10'),
    ('2024-11-13 15:00:00', 'Smartphone', 'iPhone 14', 3000.00, null, 1, 1, 2, 3, 'IPHONE123', '00000011', 'DOC/INV/A/11'),
    ('2024-11-12 12:00:00', 'Desk', 'Ikea Office Desk', 700.00, null, 2, 2, 3, 1, 'DESK1234', '00000012', 'DOC/INV/A/12'),
    ('2024-11-11 10:30:00', 'Office chair', 'Steelcase Chair', 1000.00, null, 2, 3, 4, 2, 'CHAIR5678', '00000013', 'DOC/INV/A/13'),
    ('2024-11-10 09:30:00', 'Laptop stand', 'Laptop Stand Pro', 180.00, null, 2, 4, 5, 1, 'LSTAND1234', '00000014', 'DOC/INV/A/14'),
    ('2024-11-09 16:45:00', 'Keyboard', 'Logitech K840', 150.00, null, 3, 5, 6, 3, 'KEYBOARD1234', '00000015', 'DOC/INV/A/15'),
    ('2024-11-08 11:15:00', 'Mouse', 'Logitech MX Master', 250.00, null, 3, 6, 7, 2, 'MOUSE1234', '00000016', 'DOC/INV/A/16'),
    ('2024-11-07 13:30:00', 'Router', 'Netgear Nighthawk', 300.00, null, 1, 7, 8, 4, 'ROUTER1234', '00000017', 'DOC/INV/A/17'),
    ('2024-11-06 12:30:00', 'Office printer', 'Canon Pixma', 500.00, null, 6, 8, 9, 3, 'CANON123', '00000018', 'DOC/INV/A/18'),
    ('2024-11-05 14:00:00', 'Shredder', 'Fellowes Shredder', 300.00, null, 7, 9, 10, 1, 'SHREDDER123', '00000019', 'DOC/INV/A/19'),
    ('2024-11-04 10:00:00', 'Whiteboard', 'Magnetic Whiteboard', 400.00, null, 2, 10, 1, 2, 'WB1234', '00000020', 'DOC/INV/A/20');;
