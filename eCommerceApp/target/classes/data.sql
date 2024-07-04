CREATE TABLE IF NOT EXISTS products (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    title VARCHAR (100) NOT NULL,
    description VARCHAR (100) NULL,
    price decimal NULL,
    storage_available INT NULL,

    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    userName VARCHAR (100) NOT NULL,
    email VARCHAR (100) NOT NULL,
    password VARCHAR (100) NOT NULL,

    CONSTRAINT pk_users PRIMARY KEY (id)
);