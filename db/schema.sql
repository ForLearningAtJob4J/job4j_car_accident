CREATE TABLE IF NOT EXISTS type
(
    id   serial primary key,
    name varchar(2000)
);

CREATE TABLE IF NOT EXISTS rule
(
    id   serial primary key,
    name varchar(2000)
);

CREATE TABLE IF NOT EXISTS accident
(
    id      serial primary key,
    name    varchar(2000),
    text    text,
    address varchar(2000),
    type_id integer references type(id)
);

CREATE TABLE IF NOT EXISTS accident_rule
(
    accident_id integer references accident(id),
    rule_id integer references rule(id)
);