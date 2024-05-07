CREATE TABLE categories
(
  id   INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  name TEXT NOT NULL
);

CREATE TABLE products
(
  id                 BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  name               TEXT    NOT NULL,
  description        TEXT    NOT NULL,
  price              DECIMAL NOT NULL,
  available          BOOLEAN NOT NULL DEFAULT TRUE,
  stock_availability TEXT    NOT NULL,
  condition          TEXT    NOT NULL,
  category_id        INT     NOT NULL REFERENCES categories (id)
);

CREATE TABLE builds
(
  id                  BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  name                TEXT      NOT NULL,
  description         TEXT      NOT NULL,
  price               DECIMAL   NOT NULL,
  sold_price          DECIMAL,
  created_tm          TIMESTAMP NOT NULL DEFAULT NOW(),
  sold_tm             TIMESTAMP,
  available           BOOLEAN   NOT NULL DEFAULT TRUE,
  stock_availability  TEXT      NOT NULL,
  condition           TEXT      NOT NULL,
  motherboard_name    TEXT      NOT NULL,
  motherboard_chipset TEXT      NOT NULL,
  motherboard_socket  TEXT      NOT NULL,

  cpu_vendor          TEXT      NOT NULL,
  cpu_model           TEXT      NOT NULL,
  cpu_cores           INT       NOT NULL,
  cpu_threads         INT       NOT NULL,
  cpu_freq            INT       NOT NULL,

  cooler_type         TEXT      NOT NULL,
  cooler_name         TEXT      NOT NULL,

  ram_model           TEXT      NOT NULL,
  ram_type            TEXT      NOT NULL,
  ram_freq            INT       NOT NULL,
  ram_size            INT       NOT NULL,
  ram_stick_number    INT       NOT NULL,

  rom_ssd_name        TEXT,
  rom_ssd_capacity    INT,
  rom_hdd_name        TEXT,
  rom_hdd_capacity    INT,

  gpu_vendor          TEXT      NOT NULL,
  gpu_model           TEXT      NOT NULL,
  gpu_capacity        INT       NOT NULL,
  gpu_memory_type     TEXT      NOT NULL,

  psu_name            TEXT      NOT NULL,
  psu_model           TEXT      NOT NULL,
  psu_power           INT       NOT NULL,
  psu_certificate     TEXT      NOT NULL,

  case_name           TEXT      NOT NULL,
  case_model          TEXT      NOT NULL,
  case_form_factor    TEXT      NOT NULL
);

CREATE TABLE costs
(
  id          BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  amount      NUMERIC NOT NULL,
  description TEXT    NOT NULL
);

CREATE TABLE builds_to_costs
(
  build_id BIGINT NOT NULL REFERENCES builds (id),
  cost_id  BIGINT NOT NULL REFERENCES costs (id)
);

CREATE TABLE products_to_costs
(
  product_id BIGINT NOT NULL REFERENCES products (id),
  cost_id    BIGINT NOT NULL REFERENCES costs (id)
);

CREATE TABLE images
(
  id      BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  content text NOT NULL
);

CREATE TABLE products_to_images
(
  product_id BIGINT NOT NULL REFERENCES products (id),
  image_id   BIGINT NOT NULL REFERENCES images (id)
);

CREATE TABLE builds_to_images
(
  build_id BIGINT NOT NULL REFERENCES builds (id),
  image_id BIGINT NOT NULL REFERENCES images (id)
);

CREATE TABLE cpus
(
  id       BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  vendor   TEXT   NOT NULL,
  socket   TEXT   NOT NULL,
  model    TEXT   NOT NULL,
  cores    INT    NOT NULL,
  threads  INT    NOT NULL,
  freq     INT    NOT NULL,
  price    FLOAT  NOT NULL,
  image_id BIGINT NOT NULL REFERENCES images (id)
);

create table coolers
(
  id       BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  vendor   TEXT   NOT NULL,
  model    TEXT   NOT NULL,
  price    FLOAT  NOT NULL,
  image_id BIGINT NOT NULL REFERENCES images (id),
  type     TEXT   NOT NULL
);

create table motherboards
(
  id         BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  vendor     TEXT   NOT NULL,
  model      TEXT   NOT NULL,
  price      FLOAT  NOT NULL,
  image_id   BIGINT NOT NULL REFERENCES images (id),
  socket     TEXT   NOT NULL,
  chipset    TEXT   NOT NULL,
  ram_type   TEXT   NOT NULL,
  ram_sticks INT    NOT NULL
);

create table memories
(
  id        BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  vendor    TEXT   NOT NULL,
  model     TEXT   NOT NULL,
  price     FLOAT  NOT NULL,
  image_id  BIGINT NOT NULL REFERENCES images (id),
  type      TEXT   NOT NULL,
  capacity  INT    NOT NULL,
  frequency INT    NOT NULL
);

create table storages
(
  id       BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  vendor   TEXT   NOT NULL,
  model    TEXT   NOT NULL,
  price    FLOAT  NOT NULL,
  image_id BIGINT NOT NULL REFERENCES images (id),
  type     TEXT   NOT NULL,
  capacity INT    NOT NULL
);

create table gpus
(
  id          BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  vendor      TEXT   NOT NULL,
  model       TEXT   NOT NULL,
  price       FLOAT  NOT NULL,
  image_id    BIGINT NOT NULL REFERENCES images (id),
  memory_type TEXT   NOT NULL,
  memory      INT    NOT NULL
);

create table psus
(
  id          BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  vendor      TEXT   NOT NULL,
  model       TEXT   NOT NULL,
  price       FLOAT  NOT NULL,
  image_id    BIGINT NOT NULL REFERENCES images (id),
  certificate TEXT   NOT NULL,
  power       INT    NOT NULL
);

create table cases
(
  id          BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  vendor      TEXT   NOT NULL,
  model       TEXT   NOT NULL,
  price       FLOAT  NOT NULL,
  image_id    BIGINT NOT NULL REFERENCES images (id),
  form_factor TEXT   NOT NULL
);

create table product_orders
(
  id             BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  product_id     BIGINT    NOT NULL REFERENCES products (id),
  contact_name   TEXT      NOT NULL,
  contact_number TEXT      NOT NULL,
  contact_email  TEXT      NOT NULL,
  created_tm     TIMESTAMP NOT NULL DEFAULT NOW()
);

create table build_orders
(
  id             BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  build_id       BIGINT    NOT NULL REFERENCES builds (id),
  contact_name   TEXT      NOT NULL,
  contact_number TEXT      NOT NULL,
  contact_email  TEXT      NOT NULL,
  created_tm     TIMESTAMP NOT NULL DEFAULT NOW()
);

create table virtual_build_orders
(
  id             BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  cpu_id         BIGINT    NOT NULL REFERENCES cpus (id),
  cooler_id      BIGINT    NOT NULL REFERENCES coolers (id),
  motherboard_id BIGINT    NOT NULL REFERENCES motherboards (id),
  memory_id      BIGINT    NOT NULL REFERENCES memories (id),
  storage_id     BIGINT    NOT NULL REFERENCES storages (id),
  gpu_id         BIGINT    NOT NULL REFERENCES gpus (id),
  psu_id         BIGINT    NOT NULL REFERENCES psus (id),
  case_id        BIGINT    NOT NULL REFERENCES cases (id),
  contact_name   TEXT      NOT NULL,
  contact_number TEXT      NOT NULL,
  contact_email  TEXT      NOT NULL,
  created_tm     TIMESTAMP NOT NULL DEFAULT NOW()
);

ALTER TABLE builds
  ADD COLUMN show_price DECIMAL NOT NULL;
