
package proyecto;
import java.util.*;
import java.io.*;
import javax.swing.DefaultListModel;
/*
*
*   CAMBIOS EN LA CLASE:
*       Clase dedicada a la verificación, manejará todos las listas desde 'arriba' y se dedicará a la verificación de
*       condiciones antes de agregar ciertos obj's a c/lista.
*
*
*/
public class Tienda implements Serializable{
    
    private String direc;
    private String id;
    private int porcentajeGanancia; /*no se le asigna valor inicial, se modifica*/
    private Gerente GerenteTienda;
    private ListaVendedores listaVendedores;
    private ListaArticulos listaArticulos;
    
    public Tienda(String id){
        this.id = id;
        listaVendedores = new ListaVendedores();
        listaArticulos = new ListaArticulos();
        
    }
    public void setPorcentajeGanancia(int porcentajeGanancia){
        this.porcentajeGanancia=porcentajeGanancia;
    }
    public Gerente getGerente(){
        return GerenteTienda;
    }
    public void setGerente(Gerente Grnt){
        this.GerenteTienda = Grnt;
    }
    public void setDirec (String direc){
        this.direc = direc;
    }
    public void setID(String id){
        this.id=id;
    }
    public String getID(){
        return id;
    }
    public String getDirecc() {
    	return direc;
    }
    public int obtenerTamañoListaVendedores(){
        return listaVendedores.obtenerTamañoListaVendedores();
    }
    public int obtenerTamañoListaArticulos(){
        return listaArticulos.obtenerTamañoListaArticulos();
    }
    public int añadirVendedorTienda(String Nombre, String Rut, String Sueldo){
        if(listaVendedores.buscarVendedor(Rut) != null)return -1;
        
        Vendedor aux = listaVendedores.crearVendedor(Nombre, Rut,Sueldo);
        listaVendedores.agregarVendedor(aux);
        
        return 1;
        
    }
    public int añadirVendedorTienda(String Nombre, String Rut){
        if(listaVendedores.buscarVendedor(Rut) != null)return -1;
        
        Vendedor aux = listaVendedores.crearVendedor(Nombre, Rut, "0");
        listaVendedores.agregarVendedor(aux);
        
        return 1;
        
    } 
    public int añadirArticulosTienda(String Codigo,String Nombre, String PrecioVenta, String PrecioCosto, String Stock, String Descuento){
        if(listaArticulos.buscarArticulo(Codigo) != null)return -1;
        
        Articulo aux = listaArticulos.crearArticulo(Codigo, Nombre, PrecioVenta, PrecioCosto, Stock, Descuento);
        listaArticulos.agregarArticulo(aux);
        
        return 1;
    }
    public int eliminarArticulo(String codigo){
        if(listaArticulos.buscarArticulo(codigo)==null)return -1;
        
        listaArticulos.eliminarArticulo(codigo);
        return 1;
    }
    public int modificarArticulo(String Codigo,String Nombre, String PrecioVenta, String PrecioCosto, String Stock, String Descuento,String codigoNuevo){
        if(listaArticulos.buscarArticulo(Codigo)== null || listaArticulos.buscarArticulo(codigoNuevo) != null)return -1;
        
        listaArticulos.modificarArticulo(Codigo,Nombre, PrecioVenta, PrecioCosto, Stock, Descuento,codigoNuevo);
        return 1;
    }
    public int calcularGananciaTienda(){
       // listaVendedores es la clase que encapsula a los vendedores.
       return listaVendedores.obtenerVentas();
        /*Vendedor aux;
        int GananciaTotal=0;
        ListIterator<Vendedor> itr=listaVendedores.listIterator();
        while (itr.hasNext()) {
            aux=itr.next();  
            GananciaTotal=GananciaTotal+aux.getGananciaDeVendedor();
        }
        
        return GananciaTotal;*/
    
    }
    public DefaultListModel modelVentana(){
        return listaVendedores.MdlVentana();
    }
    public int añadirVendedor(String nombre,String rut,String sueldo){
        if(listaVendedores.buscarVendedor(rut)!=null)return -1;
        Vendedor aux = listaVendedores.crearVendedor(nombre, rut, sueldo);
        listaVendedores.agregarVendedor(aux);
        
        return 1;
    }
    public int eliminarVendedor(String rut){
        if(listaVendedores.buscarVendedor(rut)==null)return -1;
        
        listaVendedores.eliminarVendedor(rut);
        return 1;
    }
    public int modificarVendedor(String nombre,String rut,String sueldo,String rutnuevo){
        if(listaVendedores.buscarVendedor(rut)==null)return -1;
        
        Vendedor aux = listaVendedores.buscarVendedor(rut);
        aux.setName(nombre);
        aux.setRut(rutnuevo);
        aux.setSueldo(Integer.parseInt(sueldo));
        return 1;
    }
    public Vendedor buscarVendedor(String rut){
        return listaVendedores.buscarVendedor(rut);
    }
    public Articulo buscarArticulo(String codigo){
        return listaArticulos.buscarArticulo(codigo);
    }
    public DefaultListModel modelVentanaArticulo(){
        return listaArticulos.MdlVentana();
    }
    public ArrayList obtenerArticulos(){
       ArrayList<Articulo> listaDuplicada;
        listaDuplicada=listaArticulos.duplicarArrayListArticulos();
        return listaDuplicada;
    }
    public void exportarArticulos() throws IOException{
        listaArticulos.guardarArchivoArticulos();
    }
    /*public int añadirFactura(String Rut, String Codigo, String IDFact){
        Articulo AObj = listaArticulos.buscarArticulo(Codigo);
        Trabajador TObj = listaTrabajadores.buscarTrabajador(Rut);
        if(AObj == null | TObj == null )return -1; // en caso de no existir el trabajador o el articulo, se retorna -1
        
        if(listaFacturas.buscarFactura(IDFact) != null)return -1;   //en caso de existir la factura se retorna
                                                                    // ya que la f(x) es dedicada a la creacion de facturas.
        listaFacturas.agregarFactura(TObj, IDFact, AObj);
        
        return 1;
    }*/
    /*public int getInventory() {
    	return listaArticulos.size();
    }
    public int getStaff() {
    	return listaTrabajadores.size();
    }
    */
    
    /*public Articulo buscarArticulo(String codigo) {
    	ListIterator<Articulo> itr=listaArticulos.listIterator();
        while (itr.hasNext()) {
            Articulo aux = itr.next();
            if(aux.getCodigo().equals(codigo)) {
            	return aux;
            }
        }
        return null;
    }*/
    
    
    /*private void addArticulo () throws IOException{
        Articulo item = crearArticulo();
       
        if(buscarArticulo(item.getCodigo())!=null) {
        	System.out.println("\n\tEl articulo ya se encuentra en la lista de productos de la tienda.");
        	return;
        }
        System.out.println("\n\tArticulo agregado exitosamente a la tienda");
        listaArticulos.add(item);
    }*/
    
    
    /*private Articulo crearArticulo() throws IOException{
        Articulo item = new Articulo();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el codigo que tendrá el articulo a agregar:\n");
        item.setCodigo(br.readLine());
        System.out.println("Ingrese el nombre del articulo:\n");
        item.setNombre(br.readLine());
        System.out.println("Ingrese el precio venta:\n");
        item.setPrecio(Integer.parseInt(br.readLine()));
        System.out.println("Ingrese el precio costo:\n");
        item.setPrecioCosto(Integer.parseInt(br.readLine()));
        System.out.println("Ingrese su stock inicial:\n");
        item.setStock(Integer.parseInt(br.readLine()));
        System.out.println("Ingrese (en caso de tenerlo) el % de descuento:\n");
        item.setDscto(Integer.parseInt(br.readLine()));
        
        return item;    
    }*/
    
    
    /*public void menuTienda() throws NumberFormatException, IOException, InterruptedException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
	int option;
    	do {
    		System.out.println("\n\tBienvenido al menu de administracion de la Tienda");
    		System.out.println("\tTrabajadores Registrados: "+listaTrabajadores.size());
    		System.out.println("\tArticulos Registrados: "+listaArticulos.size());
    		System.out.println("\n\t[1].- Cambiar ID"
                                   + "\n\t[2].- Cambiar Direccion"
                                   + "\n\t[3].- Cambiar Gerente"
                                   + "\n\t[4].- Menu Articulos"
                                   + "\n\t[5].- Menu Trabajadores"
                                   + "\n\t[6].- Menu Facturas"
                                   + "\n\t[7].- Ver ganancias de la Tienda"
                                   + "\n\t[0].- Volver al men� principal\n\t");
    		option = Integer.parseInt(br.readLine());
    		switch(option) {
    			case 1:{
    				System.out.println("\n\tIngresa la nueva ID de la  tienda");
    				id = br.readLine();
    				break;
    			}
    			case 2:{
    				System.out.println("\n\tIngresa la nueva direccion de la tienda");
    				direc = br.readLine();
    				break;
    			}
    			case 3:{
    				Trabajador aux = new Trabajador();
    				System.out.println("\n\tIngrese el nombre: ");
    				aux.setName(br.readLine());
    				System.out.println("\n\tIngrese el rut del gerente: ");
    				aux.setRut(br.readLine());
    				aux.setCargo("Administrador Tienda [ID: "+getID()+"]");
    				System.out.println("\n\tIngrese el sueldo: ");
    				aux.setSueldo(Integer.parseInt(br.readLine()));
    				setGerente(aux);
    				break;
    			}
    			case 4:{
    				menuArticulos();
    				break;
    			}
    			case 5:{
    				menuTrabajadores();
    				break;
    			}
                        case 6:{
                                menuFacturas();
                                break;
                        }
                        case 7:{
                                System.out.println("\n\tLa tienda actualmente generó: $"+getProfitFacturas()+" en ingresos.");
                                break;
                        }
    		}    		
    	}while(option != 0);
    }
    private void menuArticulos() throws NumberFormatException, IOException, InterruptedException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
    	int option;
    	do {
            System.out.println("\n\tBienvenido al menu de Articulos");
            System.out.println("\n\tArticulos Registrados: "+listaArticulos.size());
            System.out.println("\n\t[1].- Agregar Articulo"
                    + "\n\t[2].- Buscar Articulo"
                    + "\n\t[3].- Eliminar Articulo"
                    + "\n\t[4].- Editar Articulo"
                    + "\n\t[5].- Mostrar Articulos"
                    + "\n\t[6].- Mostrar Articulos con descuento"
                    + "\n\t[0].- Volver al Menu anterior\n\t");
            option = Integer.parseInt(br.readLine());
    		switch(option) {
	    		case 1:{
	    			addArticulo();
	    			break;
	    		}
	    		case 2:{
	    			if(listaArticulos.size()<1) {
	    				System.out.println("\n\tActualmente no hay ningun articulo registrado. Volviendo al menu de Articulos");
	    				break;
	    			}
	    			System.out.println("\n\tIngrese el codigo del articulo a buscar");
	    			Articulo aux = buscarArticulo(br.readLine());
	    			if(aux == null) {
	    				System.out.println("\n\tNo existe articulo asociado a tal codigo");
	    				break;
	    			}
	    			System.out.println("\n\t[Nombre: "+aux.getNombre()+"]->[Codigo: "+aux.getCodigo()+"]->[Stock: "+aux.getStock()+"]"
	    		    + "->[Precio: "+aux.getPrecio()+"]->[% de descuento: "+aux.getDscto()+"]");
	    			break;
	    		}
	    		case 3:{
	    			if(listaArticulos.size()<1) {
	    				System.out.println("\n\tActualmente no hay ningun articulo. Volviendo al menu de Articulos");
	    				break;
	    			}
	    			System.out.println("\t\n Ingresa el codigo del articulo a borrar: ");
	    			String code = br.readLine();
	    			ListIterator<Articulo> itr=listaArticulos.listIterator();
                                while (itr.hasNext()) {
                                    Articulo aux = itr.next();
                                    if(aux.getCodigo().equals(code)) {
                                        do{
	    	        			
                                            System.out.println("\n\tArticulo encontrado - desea eliminar el articulo permanentemente?\n\t [1] SI\n\t [2] NO");
                                            option = Integer.parseInt(br.readLine());  
	    	            		
	    	        			switch(option) {
	    	        				case 1:{
	    	        					System.out.println("\n\t Eliminando Articulo - Espere por favor");
	    	        					Thread.sleep(1000);
	    	        					System.out.println(".");
	    	        					Thread.sleep(1000);
	    	        					System.out.println(".");
	    	        					Thread.sleep(1000);
	    	        					System.out.println(".");
	    	        					Thread.sleep(1000);
	    	        					itr.remove();
	    	        					System.out.println("\n\tArticulo eliminada exitosamente\n");
	    	        					break;
	    	        				}
	    	        			}
	    	        		}while(option >2 && option <1);
                                    }
                                }
                                break;
	    		}
	    		case 4:{
	    			if(listaArticulos.size()<1) {
	    				System.out.println("\n\tActualmente no hay ningun articulo. Volviendo al menu de Articulos");
	    				break;
	    			}
	    			System.out.println("\n\tIngresa el codigo del articulo a editar");
	    			Articulo aux = buscarArticulo(br.readLine());
	    			if(aux == null) {
	    				System.out.print("\n\tNo existe articulo asociado a tal codigo. Volviendo al menu de Articulos");
	    				break;
	    			}	    			
	    			int option2;
	    			do {
	    				System.out.println("\n\t�Que caracteristica deseas cambiar?\n\n");
		    			System.out.println("\n\t[1].- Codigo\n\t[2].- Nombre\n\t[3].- Stock\n\t[4].- Precio Venta"
                                                + "\n\t[5].- Precio Unitario\n\t[6].- Porcentaje de Descuento"
                                                + "\n\t[7].- Volver al menu de Articulos");
	    				option2 = Integer.parseInt(br.readLine());
	    				switch(option2) {
	    					case 1:{
	    						System.out.println("\n\tIngresa el nuevo codigo del articulo\n\n");
	    						aux.setCodigo(br.readLine());
	    						break;
	    					}
	    					case 2:{
	    						System.out.println("\n\tIngresa el nuevo nombre\n\n");
	    						aux.setNombre(br.readLine());
	    						break;
	    					}
	    					case 3:{
	    						System.out.println("\n\tIngresa el nuevo stock del articulo\n\n");
	    						aux.setStock(Integer.parseInt(br.readLine()));
	    						break;
	    					}
	    					case 4:{
	    						System.out.println("\n\tIngresa el nuevo precio de venta\n\n");
	    						aux.setPrecio(Integer.parseInt(br.readLine()));
	    						break;
	    					}
                                                case 5:{
	    						System.out.println("\n\tIngresa el nuevo precio unitario\n\n");
	    						aux.setPrecio(Integer.parseInt(br.readLine()));
	    						break;
	    					}
	    					case 6:{
	    						System.out.println("\n\tIngresa el nuevo % de descuento\n\n");
	    						aux.setDscto(Integer.parseInt(br.readLine()));
	    						break;
	    					}
	    				}
	    			}while(option != 7);
	    			break;
	    		}
	    		case 5:{
                                if(listaArticulos.size()<1) {
    					System.out.println("\n\tNo hay articulos registrados. Volviendo al menu anterior");
    					break;
    				}
    				int option2;
    				do{	        			
	            		System.out.println("\n\tDesea mostrar los articulos por... ?\n\t [1] Consola\n\t [2] Archivo");
	            		option2 = Integer.parseInt(br.readLine());  
	            		
	        			switch(option2) {
	        				case 1:{
	        					ListIterator<Articulo> itr=listaArticulos.listIterator();
                                                        while (itr.hasNext()) {
                                                            Articulo aux = itr.next();
                                                            System.out.println("\n\t[Nombre: "+aux.getNombre()+"]->[Codigo: "+aux.getCodigo()+""
                                                            + "]->[Stock: "+aux.getStock()+"]"
                                                            + "->[Precio Venta: "+aux.getPrecio()+"]->[Precio Unitario: "+aux.getPrecioCosto()
                                                            + "]->[% de descuento: "+aux.getDscto()+"]");
                                                        }
	        			            
	        					break;
	        				}
	        				case 2:{
	        					printArtTextFile();
	        					break;
	        				}
	        			}
	        		}while(option2 >2 && option2 <1);
    				
    				break;
	    		}
                        case 6:{                       
	    			if(listaArticulos.size()<1) {
	    				System.out.println("\n\tActualmente no hay ningun articulo registrado. "
                                        + "Volviendo al menu de Articulos");
	    				break;
	    			}
                                Collections.sort(listaArticulos,(art1,art2) -> art1.getDscto() - art2.getDscto());
                                
	    			ListIterator<Articulo> itr=listaArticulos.listIterator();
                                while (itr.hasNext()) {
                                    Articulo aux = itr.next();
                                    System.out.println("\n\t[Nombre: "+aux.getNombre()
                                                        +"]->[Codigo: "+aux.getCodigo()
                                                        +"]->[Stock: "+aux.getStock()
                                                        + "]->[Precio Unitario: "+aux.getPrecioCosto()
                                                        + "]->[Precio Venta: "+aux.getPrecio()
                                                        + "]->[Precio con dscto:"+aux.getPrecioConDscto()
                                                        + "]->[% de descuento: "+aux.getDscto()+"]");
                                    
                                }
                                break;
                        }
    		}
    	}while(option != 0);
    }
    
    
    private void menuTrabajadores() throws NumberFormatException, IOException, InterruptedException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int option;
    	do {
    		System.out.println("\n\tBienvenido al Menu de trabajadores"
                        + "\n\tTrabajadores Registrados: "+listaTrabajadores.size());
    		System.out.println("\n\t[1].- Agregar Trabajador"
                        + "\n\t[2].- Buscar Trabajador"
                        + "\n\t[3].- Eliminar Trabajador"
                        + "\n\t[4].- Editar Trabajador"
                        + "\n\t[5].- Mostrar Trabajadores"
                        + "\n\t[0].- Volver al Menu anterior");
    		option = Integer.parseInt(br.readLine());
    		switch(option) {
    			case 1:{
    				agregarTrabajador();
    				break;
    			}
    			case 2:{
    				if(listaTrabajadores.size()<1) {
    					System.out.println("\n\tActualmente no hay trabajadores registrados. "
                                                + "Volviendo al menu anterior.");
    					break;
    				}
    				System.out.println("\n\tIngrese el RUT del trabajador a buscar");
    				Trabajador aux = buscarTrabajador(br.readLine());
    				if(aux == null) {
    					System.out.println("\n\tNo existe tal trabajador asociado al RUT escrito. "
                                                + "Volviendo al menu anterior.");
    					break;
    				}
    				
    				System.out.println("\n[Nombre: "+aux.getName()+"]->[Rut: "+aux.getRut()+"]->"
    				+ "[Cargo: "+aux.getCargo()+"]->[Sueldo: "+aux.getSueldo()+"]");
    				break;
    			}
    			case 3:{
    				System.out.print("\n\tIngrese el RUT del trabajador a eliminar");
    				String rut = br.readLine();
    				ListIterator<Trabajador> itr=listaTrabajadores.listIterator();
    				int option2;
                                while (itr.hasNext()) {
                                    Trabajador aux = itr.next();
                                    if(aux.getRut().equals(rut)) {	  
                                        do {
                                            System.out.println("\n\tTrabajador encontrado - desea eliminar al Trabajador "
                                                    + "permanentemente?\n\t [1] SI\n\t [2] NO");
                                            option2 = Integer.parseInt(br.readLine());  

                                            switch(option2) {
                                                case 1:{
                                                        System.out.println("\n\t Eliminando Trabajador - Espere por favor");
                                                        Thread.sleep(1000);
                                                        System.out.println(".");
                                                        Thread.sleep(1000);
                                                        System.out.println(".");
                                                        Thread.sleep(1000);
                                                        System.out.println(".");
                                                        Thread.sleep(1000);
                                                        itr.remove();
                                                        System.out.println("\n\tTrabajador eliminado exitosamente\n");
                                                        break;
                                                }
                                            }
                                        }while(option2 >2 && option2 <1);
                                    }
                                }
                                break;
    			}
    			case 4:{
    				if(listaTrabajadores.size()<1) {
    					System.out.println("\n\tNo hay ningun trabajador registrado. Volviendo al menu anterior");
    					break;
    				}
    				System.out.println("\n\tIngrese el RUT del trabajador a editar");
    				Trabajador aux = buscarTrabajador(br.readLine());
    				if(aux == null) {
    					System.out.println("\n\tNo hay ningun trabajador asociado a tal RUT en nuestros archivos"
    					+ ". Volviendo al menu principal");
    					break;
    				}
    				do {
	    				System.out.println("\n\t�Que caracteristica deseas cambiar?\n\n");
		    			System.out.println("\n\t[1].- Nombre\n\t[2].- Rut\n\t[3].- Cargo\n\t[4].- Sueldo\n\t"
		    			+ "[5].- Volver al menu de Articulos");
	    				int option2 = Integer.parseInt(br.readLine());
	    				switch(option2) {
	    					case 1:{
	    						System.out.println("\n\tIngresa el nuevo nombre del trabajador\n\n");
	    						aux.setName(br.readLine());
	    						break;
	    					}
	    					case 2:{
	    						System.out.println("\n\tIngresa el nuevo rut\n\n");
	    						aux.setRut(br.readLine());
	    						break;
	    					}
	    					case 3:{
	    						System.out.println("\n\tIngresa el nuevo Cargo\n\n");
	    						aux.setCargo(br.readLine());
	    						break;
	    					}
	    					case 4:{
	    						System.out.println("\n\tIngresa el nuevo sueldo\n\n");
	    						aux.setSueldo(Integer.parseInt(br.readLine()));
	    						break;
	    					}
	    				}
	    			}while(option != 5);
    				break;
    			}
    			case 5:{
    				if(listaTrabajadores.size()<1) {
    					System.out.println("\n\tNo hay trabajadores registrados. Volviendo al menu anterior");
    					break;
    				}
    				int option2;
    				do{	        			
	            		System.out.println("\n\tDesea mostrar los trabajadores por... ?\n\t [1] Consola\n\t [2] Archivo");
	            		option2 = Integer.parseInt(br.readLine());  
	            		
	        			switch(option2) {
	        				case 1:{
	        					ListIterator<Trabajador> itr=listaTrabajadores.listIterator();
	        			        while (itr.hasNext()) {
	        			            Trabajador aux = itr.next();
	        			            System.out.println("\n[Nombre: "+aux.getName()+"]->[Rut: "+aux.getRut()+"]->"
                                                    + "[Cargo: "+aux.getCargo()+"]->[Sueldo: "+aux.getSueldo()+"]");
	        			        }
	        			            
	        					break;
	        				}
	        				case 2:{
	        					printTextFile();
	        					break;
	        				}
	        			}
	        		}while(option2 >2 && option2 <1);
    				
    				break;
    			}
    		}
    		
    	}while(option !=0);
    }*/
    
    
    /*private void printTextFile() throws IOException {
    	ListIterator<Trabajador> itr=listaTrabajadores.listIterator();
        File file = new File("TrabajadoresRegistrados.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            while (itr.hasNext()) {
                Trabajador aux = itr.next();
                bw.write("\n[Nombre: "+aux.getName()+"]->[Rut: "+aux.getRut()+"]->"
                        + "[Cargo: "+aux.getCargo()+"]->[Sueldo: "+aux.getSueldo()+"]");
            }
        }
    }
    private void printArtTextFile() throws IOException {
    	ListIterator<Articulo> itr=listaArticulos.listIterator();
        File file = new File("ArticulosRegistrados.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            while (itr.hasNext()) {
                Articulo aux = itr.next();
                bw.write("\n\t[Nombre: "+aux.getNombre()+"]->[Codigo: "+aux.getCodigo()+"]->[Stock: "+aux.getStock()+"]"
                        + "->[Precio Original: "+aux.getPrecio()+"]->[% de descuento: "+aux.getDscto()+"]");
            }
        }
    }*/
    
    /*public void agregarTrabajador() throws IOException {
    	Trabajador nuevo = crearTrabajador();
    	if(buscarTrabajador(nuevo.getRut())!=null) {
    		System.out.println("\n\tYa hay un trabajador registrado con tal RUT. Volviendo al menu anterior.");
    		return;
    	}
    	System.out.println("\n\tTrabajador agregado exitosamente.");
    	listaTrabajadores.add(nuevo);
    }*/
    
    
    /*private Trabajador buscarTrabajador(String rut) {
    	ListIterator<Trabajador> itr=listaTrabajadores.listIterator();
        while (itr.hasNext()) {
            Trabajador aux = itr.next();
            if(aux.getRut().equals(rut)) {
            	return aux;
            }
        }
    	return null;
    }*/
    
    
    /*private Trabajador crearTrabajador() throws IOException {
    	Trabajador nuevo = new Trabajador();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("\n\tIngrese el nombre del trabajador");
    	nuevo.setName(br.readLine());
    	System.out.println("\n\tIngrese el Rut del trabajador");
    	nuevo.setRut(br.readLine());
    	System.out.println("\n\tIngrese el Cargo del trabajador");
    	nuevo.setCargo(br.readLine());
    	System.out.println("\n\tIngrese el Sueldo del trabajador");
    	nuevo.setSueldo(Integer.parseInt(br.readLine()));
    	return nuevo;
    }*/
    /*private void menuFacturas() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int option;
    	do {
    		System.out.println("\n\tBienvenido al Menu de Facturas"
                + "\n\tFacturas Registradas: "+listaDeFacturas.size());
    		System.out.println("\n\t[1].- Agregar Factura"
                        + "\n\t[2].- Ver Facturas Registradas"
                        + "\n\t[3].- Buscar Factura"
                        + "\n\t[4].- Eliminar Factura"
                        + "\n\t[0].- Volver al menu Principal");
    		option = Integer.parseInt(br.readLine());
                switch(option){
                    case 1:{
                        if(listaTrabajadores.size()<1){
                            System.out.println("\n\tNo hay trabajadores registrados. Volviendo al menu anterior.");
                            break;
                        }
                        if(listaArticulos.size()<1){
                            System.out.println("\n\tNo hay articulos registrados. Volviendo al menu anterior.");
                            break;
                        }
                        String auxRut;
                        int resp = 0;
                        System.out.println("Ingrese el rut del vendedor"); 
                        do{
                            auxRut=br.readLine();
                            if(buscarTrabajador(auxRut)==null){
                            System.out.println("\n No se encuentra trabajador asociado al rut ingresado"
                                 + "\n Intente nuevamente: ");
                                                    resp = 1;
                            }
                        }while(resp != 0);
                        System.out.println("\n\tIngrese la ID de la factura: ");
                        Factura nuevo = new Factura(br.readLine(),0,buscarTrabajador(auxRut));  
                       
                        do{
                            Articulo aux;  
                            do{
                                System.out.println("\n\tIngrese la ID del articulo a vender: ");
                                aux = buscarArticulo(br.readLine());
                                if(aux == null) {
                                        System.out.print("\n\tNo existe articulo asociado a tal codigo.");
                                }
                            }while(aux == null);
                            nuevo.addItem(aux);
                            System.out.println("\n\tDesea agregar más articulos?\n\t[1].- SI\n\t[0].- NO");
                            resp = Integer.parseInt(br.readLine());
                        }while(resp != 0);
                        listaDeFacturas.add(nuevo);
                        break;
                    }
                    case 2:{
                        if(listaDeFacturas.size()<1){
                            System.out.println("\n\tNo hay facturas registradas actualmente."
                                    + "Volviendo al menu anterior.");
                            break;
                        }
                        ListIterator<Factura> itr=listaDeFacturas.listIterator();
                        while (itr.hasNext()) {
                            Factura aux = itr.next();
                            System.out.println("\n\t[ID Factura: "+aux.getID()+"]"
                            +"\n\t[Articulos Comprados: "+aux.getSize()+"]"
                            +"\n\t[Ganancia: "+aux.getGanancia());
                        }
                        break;
                    }
                    case 3:{
                        if(listaDeFacturas.size()<1){
                            System.out.println("\n\tNo hay facturas registradas actualmente."
                                    + "Volviendo al menu anterior.");
                            break;
                        }
                        System.out.println("\n\tIngrese la ID de la factura a buscar: ");
                        Factura fct = buscarFactura(br.readLine());
                        if(fct == null){
                            System.out.println("\n\tNo hay factura asociada a tal ID");
                            break;
                        }
                        System.out.println("\n\t[ID Factura: "+fct.getID()+"]"
                            +"\n\t[Articulos Comprados: "+fct.getSize()+"]"
                            +"\n\t[Ganancia: "+fct.getGanancia()
                            +"\n\t[Vendedor: "+fct.Vendedor.getName()
                            +"\n\t[Rut: "+fct.Vendedor.getRut());
                        break;
                    }
                    case 4:{
                        if(listaDeFacturas.size()<1){
                            System.out.println("\n\tNo hay facturas registradas actualmente."
                                    + "Volviendo al menu anterior.");
                            break;
                        }
                        System.out.println("\n\tIngrese la ID de la factura a eliminar: ");
                        String idFactura = br.readLine();
                        if(buscarFactura(idFactura)== null){
                            System.out.println("\n\tNo hay facturas asociadas a tal ID. Volviendo al menu anterior");
                            break;
                        }
                        ListIterator<Factura> itr=listaDeFacturas.listIterator();
                        while (itr.hasNext()) {
                            Factura aux = itr.next();
                            if(aux.getID().equals(idFactura)){
                                itr.remove();
                                System.out.println("\n\tFactura eliminada exitosamente");
                                break;
                            }
                        }
                        break;
                    }
                }
        }while(option != 0);
    }*/
    /*private int getProfitFacturas(){
        int profit = 0;
        ListIterator<Factura> itr=listaDeFacturas.listIterator();
        while (itr.hasNext()) {
            Factura aux = itr.next();
            profit += aux.getGanancia();
        }
    
        return profit;
    }
    private Factura buscarFactura(String ID){
        ListIterator<Factura> itr=listaDeFacturas.listIterator();
        while (itr.hasNext()) {
            Factura aux = itr.next();
            if(aux.getID().equals(ID))
                   return aux;
        }
        
        return null;
    }*/
}

