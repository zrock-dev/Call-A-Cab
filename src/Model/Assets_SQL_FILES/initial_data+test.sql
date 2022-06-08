
INSERT INTO Driver (ci, first_name, last_name, phone, gender) value
    (
    202121,
    'Shizuko',
    'Stiefel',
    55482903,
    'Female'
    );

INSERT INTO Taxi_specs(model, color, type)
VALUES (
        'Mitsubishi',
        'Green',
        'Electric'
       );

INSERT INTO Taxi (Plate, Driver_Id,  taxi_specs_id, Availability)
VALUES (
        '2G00D',
        202121,
        1,
        1
       );

# To test everything is ok
SELECT specs.model, specs.color, specs.type
FROM Taxi taxi
INNER JOIN Taxi_specs specs ON taxi.taxi_specs_id = specs.id;
