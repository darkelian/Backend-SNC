-- Crear usuario y base de datos para Django
CREATE USER snc_user WITH ENCRYPTED PASSWORD 'snc_test_pass';
CREATE DATABASE snc_test OWNER snc_user;

-- Crear usuario y base de datos para Keycloak
CREATE USER keycloak_user WITH ENCRYPTED PASSWORD 'keycloak_pass';
CREATE DATABASE keycloak_db OWNER keycloak_user;

-- Asignar permisos (opcional)
GRANT ALL PRIVILEGES ON DATABASE snc_test TO snc_user;
GRANT ALL PRIVILEGES ON DATABASE keycloak_db TO keycloak_user;

