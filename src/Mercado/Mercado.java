package Mercado;

import org.omg.CORBA.Current;

import Cola.Colasimple;

public class Mercado extends Thread{
	
	private int carritos;
	private Colasimple<Integer> carritosDisponibles;
	private Colasimple<Cliente> caja1;
	private Colasimple<Cliente> caja2;
	private Colasimple<Cliente> caja3;
	private Colasimple<Cliente> clientes;
	private int id;
	private int toAdd;
	private VentanaMercado vm;
	public Mercado(VentanaMercado vm)
	{
		this.vm=vm;
		toAdd=0;
		carritos=25;
		carritosDisponibles = new Colasimple<Integer>();
		for(int i=1;i<=25;i++)
			carritosDisponibles.encolar(i);
		caja1=new Colasimple<Cliente>();
		caja2=new Colasimple<Cliente>();
		caja3=new Colasimple<Cliente>();
		clientes=new Colasimple<Cliente>();
		id=1;
	}
	
	
	public void addClientes(int a)
	{
		for(int i=1;i<=a;i++)
		{
			Cliente aux=new Cliente(id);
			clientes.encolar(aux);
			id++;
		}
	}

	public void addCajas(Cliente a)
	{
		if(caja1.size()<=caja2.size()&&caja1.size()<=caja3.size())
		{
			if(caja1.size()==0){
				a.setTime(System.currentTimeMillis());
			}
			caja1.encolar(a);
			
		}else if(caja2.size()<=caja1.size()&&caja2.size()<=caja3.size())
		{
			if(caja2.size()==0)
			{
				a.setTime(System.currentTimeMillis());
			}
			caja2.encolar(a);
		}else
		{
			if(caja3.size()==0)
			{
				a.setTime(System.currentTimeMillis());
			}
			caja3.encolar(a);
		}
	}


	@Override
	public void run() {
		
		while(true)
		{
			
			//modificamos la ventana
			vm.getLbl_cantCarritos().setText("Cantidad de carritos: "+carritos);
			vm.getLbl_cantEspera().setText("En espera: "+clientes.size());
			vm.getLbl_ncaja1().setText(caja1.size()+"");
			vm.getLbl_ncaja2().setText(caja2.size()+"");
			vm.getLbl_ncaja3().setText(caja3.size()+"");
			
			if(caja1.verPrimero()!=null)
				vm.getLbl_infcaja1().setText("CAJA 1 Atendiendo a: "+caja1.verPrimero().getID()+" con carrito No. "+caja1.verPrimero().getCarritoAsignado());
			if(caja2.verPrimero()!=null)
				vm.getLbl_infcaja2().setText("CAJA 2 Atendiendo a: "+caja2.verPrimero().getID()+" con carrito No. "+caja2.verPrimero().getCarritoAsignado());
			if(caja3.verPrimero()!=null)
				vm.getLbl_infcaja3().setText("CAJA 3 Atendiendo a: "+caja3.verPrimero().getID()+" con carrito No. "+caja3.verPrimero().getCarritoAsignado());
			//revisa si se ingresaron clientes nuevos
			if(toAdd!=0)
			{
				this.addClientes(toAdd);
				toAdd=0;
			}
			
			//revisa si es posible agregar clientes a las cajas.
			if(clientes.size()!=0)
			{
				if(carritos!=0)
				{
						clientes.verPrimero().setCarritoAsignado(carritosDisponibles.desencolar());
						this.addCajas(clientes.desencolar());
						carritos--;
					
				}
			}
			
			if(caja1.verPrimero()!=null&&System.currentTimeMillis()-caja1.verPrimero().getTime()>5000)
			{
				carritosDisponibles.encolar(caja1.verPrimero().getCarritoAsignado());
				caja1.desencolar();
				vm.getLbl_infcaja1().setText("CAJA 1 Atendiendo a: ");
				if(caja1.size()!=0)
					caja1.verPrimero().setTime(System.currentTimeMillis());
				carritos++;
			}
			if(caja2.verPrimero()!=null&&System.currentTimeMillis()-caja2.verPrimero().getTime()>5000)
			{
				carritosDisponibles.encolar(caja2.verPrimero().getCarritoAsignado());
				caja2.desencolar();
				vm.getLbl_infcaja2().setText("CAJA 2 Atendiendo a: ");
				if(caja2.size()!=0)
					caja2.verPrimero().setTime(System.currentTimeMillis());
				carritos++;
			}
			if(caja3.verPrimero()!=null&&System.currentTimeMillis()-caja3.verPrimero().getTime()>5000)
			{
				carritosDisponibles.encolar(caja3.verPrimero().getCarritoAsignado());
				caja3.desencolar();
				vm.getLbl_infcaja3().setText("CAJA 3 Atendiendo a: ");
				if(caja3.size()!=0)
					caja3.verPrimero().setTime(System.currentTimeMillis());
				carritos++;
			}
			
		}
		
	}


	public int getCarritos() {
		return carritos;
	}


	public void setCarritos(int carritos) {
		this.carritos = carritos;
	}


	public Colasimple getCaja1() {
		return caja1;
	}


	public void setCaja1(Colasimple caja1) {
		this.caja1 = caja1;
	}


	public Colasimple getCaja2() {
		return caja2;
	}


	public void setCaja2(Colasimple caja2) {
		this.caja2 = caja2;
	}


	public Colasimple getCaja3() {
		return caja3;
	}


	public void setCaja3(Colasimple caja3) {
		this.caja3 = caja3;
	}


	public Colasimple getClientes() {
		return clientes;
	}


	public void setClientes(Colasimple clientes) {
		this.clientes = clientes;
	}


	public long getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getToAdd() {
		return toAdd;
	}


	public void setToAdd(int toAdd) {
		this.toAdd = toAdd;
	}

	
}
