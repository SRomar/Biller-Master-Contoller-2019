package BMC_Modelo;

public class Producto {

	private long id;
	private String nombre;
	private String marca;
	private String descripcionDelProducto;
	private String categoria="Sin Categoria";
	private float precioDeCompra;
	private float precioDeVenta;
	private int cantidad;


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDescripcionDelProducto() {
		return descripcionDelProducto;
	}


	public void setDescripcionDelProducto(String descripcionDelProducto) {
		this.descripcionDelProducto = descripcionDelProducto;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public float getPrecioDeCompra() {
		return precioDeCompra;
	}


	public void setPrecioDeCompra(float precioDeCompra) {
		this.precioDeCompra = precioDeCompra;
	}


	public float getPrecioDeVenta() {
		return precioDeVenta;
	}


	public void setPrecioDeVenta(float precioDeVenta) {
		this.precioDeVenta = precioDeVenta;
	}



	
}
