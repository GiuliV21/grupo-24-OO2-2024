-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS db_stock;
USE db_stock;

-- Crear la tabla Producto
CREATE TABLE IF NOT EXISTS Producto (
    idProducto INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(10) NOT NULL,
    descripcion VARCHAR(45) NOT NULL,
    costo DOUBLE NOT NULL,
    precioVenta DOUBLE NOT NULL
);

-- Crear la tabla Stock
CREATE TABLE IF NOT EXISTS  Stock (
    idStock INT PRIMARY KEY AUTO_INCREMENT,
    idProducto INT,
    FOREIGN KEY (idProducto) REFERENCES Producto(idProducto)
);

-- Crear la tabla Almacen
CREATE TABLE IF NOT EXISTS  Almacen (
    idAlmacen INT PRIMARY KEY AUTO_INCREMENT,
    cantidadActual INT NOT NULL,
    cantidadCritica INT NOT NULL,
    ubicacion VARCHAR(45) NOT NULL
);

-- Crear la tabla Proveedor
CREATE TABLE IF NOT EXISTS  Proveedor (
    idProveedor INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    numContacto VARCHAR(10) NOT NULL
);

-- Crear la tabla Lote
CREATE TABLE IF NOT EXISTS  Lote (
    idLote INT PRIMARY KEY AUTO_INCREMENT,
    cantidadRecibida INT NOT NULL,
    fechaRecepcion DATE NOT NULL,
    precioCompra DOUBLE NOT NULL,
    idAlmacen INT,
    idProveedor INT,
    FOREIGN KEY (idAlmacen) REFERENCES Almacen(idAlmacen),
    FOREIGN KEY (idProveedor) REFERENCES Proveedor(idProveedor)
);

-- Crear la tabla Pedido
CREATE TABLE IF NOT EXISTS  Pedido (
    idPedido INT PRIMARY KEY AUTO_INCREMENT,
    cantidadSolicitada INT NOT NULL,
    fechaPedido DATE NOT NULL
);

-- Crear la tabla RolUsuario
CREATE TABLE IF NOT EXISTS  RolUsuario (
    idRol INT PRIMARY KEY AUTO_INCREMENT,
    rol VARCHAR(20) NOT NULL
);

-- Crear la tabla Usuario
CREATE TABLE IF NOT EXISTS  Usuario (
    idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    nombreUsuario VARCHAR(20) NOT NULL,
    contrasenia VARCHAR(20) NOT NULL,
    idRol INT,
    FOREIGN KEY (idRol) REFERENCES RolUsuario(idRol)
);

-- Crear la tabla Venta
CREATE TABLE IF NOT EXISTS  Venta (
    idVenta INT PRIMARY KEY AUTO_INCREMENT,
    idCliente INT,
    fecha DATE NOT NULL,
    total DOUBLE NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES Usuario(idUsuario)
);

-- Crear la tabla ItemVenta
CREATE TABLE IF NOT EXISTS  ItemVenta (
    idItemVenta INT PRIMARY KEY AUTO_INCREMENT,
    idVenta INT,
    idProducto INT,
    cantidad INT NOT NULL,
    precioUnitario DOUBLE NOT NULL,
    FOREIGN KEY (idVenta) REFERENCES Venta(idVenta),
    FOREIGN KEY (idProducto) REFERENCES Producto(idProducto)
);