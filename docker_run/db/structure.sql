

CREATE TABLE users (
                       username varchar(15),
                       password varchar(100),
                       enabled tinyint(1),
                       PRIMARY KEY (username)
) ;

CREATE TABLE authorities (
                             username varchar(15),
                             authority varchar(25),
                             FOREIGN KEY (username) references users(username)
) ;

INSERT INTO users (username, password, enabled)
VALUES
    ('dima', '{noop}dima', 1),
    ('kate', '{noop}kate', 1),
    ('ivan', '{noop}ivan', 1);

INSERT INTO authorities (username, authority)
VALUES
    ('dima', 'ROLE_BUYER'),
    ('kate', 'ROLE_DIRECTOR'),
    ('ivan', 'ROLE_BUYER'),
    ('ivan', 'ROLE_SALESMAN');


CREATE TABLE orders(
                       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(30),
                       price INT NOT NULL,
                       description TEXT
);

INSERT INTO orders(id, name, price, description) VALUES
                                                     (10, 'tv',1000, 'description of tv'),
                                                     (11,'dvd',500, 'description of dvd'),
                                                     (12,'headphones',200, 'description of headphones'),
                                                     (13,'fridge', 1200, 'description of fridge'),
                                                     (14,'microwave', 300, 'description of microwave');

CREATE TABLE users_orders(
                             id INT AUTO_INCREMENT NOT NULL,
                             order_id INT,
                             user_username VARCHAR(15),
                             belonging ENUM('InCart', 'Bought', 'OnSale'),
                             count INT,
                             PRIMARY KEY (id),
                             foreign key (order_id) REFERENCES orders(id),
                             foreign key (user_username) REFERENCES users(username)
);

INSERT INTO users_orders(users_orders.order_id, users_orders.user_username, users_orders.belonging, users_orders.count) VALUES
        (10, 'ivan', 'OnSale',122),
        (11, 'ivan', 'OnSale', 23),
        (12, 'ivan', 'OnSale', 34),
        (13, 'ivan', 'OnSale', 45),
        (14, 'ivan', 'OnSale', 66);

CREATE TABLE id_gen (
                        gen_name VARCHAR(50) NOT NULL,
                        gen_val BIGINT(20) DEFAULT 20,
                        PRIMARY KEY (gen_name)
);