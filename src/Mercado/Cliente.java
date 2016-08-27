package Mercado;

public class Cliente {

	private int ID;
	private long time;
	private int carritoAsignado;
	
	public Cliente(int id)
	{
		ID=id;
	}
	
	/**
	 * @return the carritoAsignado
	 */
	public int getCarritoAsignado() {
		return carritoAsignado;
	}

	/**
	 * @param carritoAsignado the carritoAsignado to set
	 */
	public void setCarritoAsignado(int carritoAsignado) {
		this.carritoAsignado = carritoAsignado;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	
}
