package com.unla.grupo24.helpers;

public class ViewRouteHelper {
	/**** Views ****/
	// HOME
	public final static String INDEX = "home/index";
	public final static String HELLO = "home/hello";

	// USER
	public final static String USER_LOGIN = "usuario/login";
	public final static String USER_LOGOUT = "usuario/logout";

	/**** Redirects ****/
	public final static String ROUTE = "/index";
	public final static String ESTRUCTURAINICIAL = "/home/index";

	// PRODUCTOS
	public static final String PRODUCTOS = "/productos/index";
	public static final String NUEVO_PRODUCTO = "/productos/agregar";
	public static final String EDITAR_PRODUCTO = "/productos/editar";
	public static final String DETALLE_PRODUCTO = "/productos/mostrar";

	// PEDIDOS
	public static final String PEDIDOS = "/pedidos/index";
	public static final String NUEVO_PEDIDO = "/pedidos/agregar";
	public static final String EDITAR_PEDIDO = "/pedidos/editar";
	public static final String DETALLE_PEDIDO = "/pedidos/mostrar";

	// ALMACENES

	public static final String ALMACENES = "almacenes/index"; // Vista para mostrar todos los almacenes
	public static final String ALMACENES_MOSTRAR = "almacenes/mostrar"; // Vista para mostrar un almacén específico
	public static final String ALMACENES_NUEVO = "almacenes/agregar"; // Vista para crear un nuevo almacén
	public static final String ALMACENES_EDITAR = "almacenes/editar"; // Vista para editar un almacén

	// LOTES
	public static final String LOTES = "lotes/index";
	public static final String DETALLE_LOTE = "lotes/mostrar";
	public static final String NUEVO_LOTE = "lotes/agregar";
	public static final String EDITAR_LOTE = "lotes/editar";
}
