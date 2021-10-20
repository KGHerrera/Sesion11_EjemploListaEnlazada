import java.util.Scanner;

class Nodo{
	private int  dato;
	private Nodo nodoSiguiente;
	
	public Nodo(int dato) {
		this.dato = dato;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public Nodo getNodoSiguiente() {
		return nodoSiguiente;
	}

	public void setNodoSiguiente(Nodo nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}

	@Override
	public String toString() {
		return "Nodo [dato=" + dato + ", nodoSiguiente=" + nodoSiguiente + "]";
	}
}

class ListaEnlazada{
	Nodo nodoInicio;
	Nodo nodoFin;
	
	// 1) Creacion
	public ListaEnlazada() {
		nodoInicio = nodoFin = null; // no es nesesario
	}
	
	public boolean verificarListaVacia() {
		if(nodoInicio == null)
			return true;
		else return false;
	}
	
	// 2) Agregar elemento al inicio
	public void agregarElementoInicio(int dato) {
		// conocer el estado de la lista en este momento
		Nodo nodoNuevo = new Nodo(dato);
		if(nodoInicio == null) {
			nodoInicio = nodoFin = nodoNuevo;
		}else {
			nodoNuevo.setNodoSiguiente(nodoInicio);
			nodoInicio = nodoNuevo;
		}
		System.out.println("\nSe agrego el dato");
	}
	
	// 2b) Agregar elemento al final
	public void agregarElementoFinal(int dato) {
		Nodo nodoNuevo = new Nodo(dato);
		if(nodoInicio == null) {
			nodoInicio = nodoFin = nodoNuevo;
		} else {
			nodoFin.setNodoSiguiente(nodoNuevo);
			nodoFin = nodoNuevo;
		}
		System.out.println("\nSe agrego el dato");
	}
	
	// 2c) Agregar elemento en posicion especifica
	public void agregarElementoPosicionEspecifica(int dato, int posicion) {
		Nodo nodoNuevo = new Nodo(dato);
		if (posicion == 0) {
			agregarElementoInicio(dato);
		} else if (nodoInicio == null){
			System.out.println("\nNo se encontro la posicion");
		} else {
			Nodo nodoActual = nodoInicio.getNodoSiguiente();
			Nodo nodoAnterior = nodoInicio;
			int contPosicion = 1;
			while(nodoActual != null && posicion != contPosicion) {
				contPosicion++;
				nodoAnterior = nodoAnterior.getNodoSiguiente();
				nodoActual = nodoActual.getNodoSiguiente();
			}
			//------------------------------------
			if(contPosicion == posicion) {
				nodoAnterior.setNodoSiguiente(nodoNuevo);
				nodoNuevo.setNodoSiguiente(nodoActual);
				System.out.println("\nSe agrego el dato");
			} else {
				System.out.println("\nNo se encontro la posicion");
			}
		}
	}
	
	// 3b) eliminar inicio
	
	public void eliminarInicio() {
		if(nodoInicio == null) {
			System.out.println("\nLista vacia");
		} else if (nodoInicio == nodoFin){
			nodoInicio = nodoFin = null;
			System.out.println("\nDato eliminado");
		} else {
			nodoInicio = nodoInicio.getNodoSiguiente();
			System.out.println("\nDato Eliminado");
		}
	}
	
	// 3c) eliminar final
	
	public void eliminarFinal() {
		if(nodoInicio == null) {
			System.out.println("\nLista vacia");
		} else {
			if(nodoInicio == nodoFin) {
				nodoInicio = nodoFin = null;
				System.out.println("\nDato eliminado");
			} else {
				Nodo nodoActual = nodoInicio;
				Nodo nodoAnterior = null;
				while(nodoActual != nodoFin) {
					nodoAnterior = nodoActual;
					nodoActual = nodoActual.getNodoSiguiente();
				}
				nodoAnterior.setNodoSiguiente(null);
				nodoFin = nodoAnterior;
				System.out.println("\nDato eliminado");
			}
		}
	}
	
	// 3c) Eliminar dato especifico
	public void eliminarDatoEspecifico(int dato) {
		if(nodoInicio == null) {
			System.out.println("\nLista vacia");
		} else if(nodoInicio.getDato() == dato) {
			nodoInicio = nodoInicio.getNodoSiguiente(); 
			System.out.println("\nEliminado correctamente");
		} else {
			Nodo nodoAnterior = nodoInicio;
			Nodo nodoActual = nodoInicio.getNodoSiguiente();
			while(dato != nodoAnterior.getDato() && nodoActual.getNodoSiguiente() != null) {
				nodoAnterior = nodoAnterior.getNodoSiguiente();
				nodoActual = nodoActual.getNodoSiguiente();
			}
			
			if(nodoActual.getDato() == dato) {
				nodoAnterior.setNodoSiguiente(nodoActual.getNodoSiguiente());
				System.out.println("\nSe elimino el dato");
			} else {
				System.out.println("\nNo se encontro el dato");
			}
		}
	}
	
	// 3d) eliminar pocicion especifica
	
	public void eliminarPosicionEspecifica(int posicion) {
		if(nodoInicio == null) {
			System.out.println("\nLista vacia");
		} else if (nodoInicio == nodoFin) {
			if(posicion == 0) {
				nodoInicio = nodoFin = null;
				System.out.println("\nDato Eliminado");
			} else {
				System.out.println("\nNo existe esa posicion");
			}
		} else {
			
			if(posicion == 0) {
				eliminarInicio();
			} else {
				int contPosicion = 1;
				Nodo nodoAnterior = nodoInicio;
				Nodo nodoActual = nodoInicio.getNodoSiguiente();
				while(contPosicion != posicion && nodoActual.getNodoSiguiente() != null) {
					contPosicion++;
					nodoAnterior = nodoAnterior.getNodoSiguiente();
					nodoActual = nodoActual.getNodoSiguiente();
				}
				
				if(contPosicion == posicion) {
					nodoAnterior.setNodoSiguiente(nodoActual.getNodoSiguiente());
					System.out.println("\nDato eliminado");
				} else {
					System.out.println("\nNo se encontro la posicion");
				}
			}
		}
	}
	
	public void mostrarListaEnlazada() {
		Nodo nodoActual = nodoInicio;
		while(nodoActual != null) {
			System.out.print("[" + nodoActual.getDato() + "] --> ");
			nodoActual = nodoActual.getNodoSiguiente();
		}
		System.out.println();
	}
	
	public void mostrarCantidadElementos() {
		Nodo nodoActual = nodoInicio;
		int cont = 0;
		while(nodoActual != null) {
			cont++;
			nodoActual = nodoActual.getNodoSiguiente();
		}
		
		System.out.println("Numero de elementos: " + cont);
	}
	
	@Override
	public String toString() {
		return "ListaEnlazada [nodoInicio=" + nodoInicio + ", nodoFin=" + nodoFin + "]";
	}
}

public class PruebaListaEnlazada {
	public static void main(String[] args) {
		Nodo n1 = new Nodo(7);
		
		ListaEnlazada le1 = new ListaEnlazada();
		
		Scanner entrada = new Scanner(System.in);
		int opcion = 0;
		
		int dato = 0;
		int posicion = 0;
		do {
			System.out.println("\nElige una de las siguientes opciones");
			System.out.println("1) Insertar elemento inicio");
			System.out.println("2) Insertar elemento final");
			System.out.println("3) Insertar elemento posicion espesifica");
			System.out.println("4) Eliminar dato");
			System.out.println("5) Eliminar dato inicio");
			System.out.println("6) Eliminar dato final");
			System.out.println("7) Eliminar dato posicion especifica");
			System.out.println("8) Mostrar datos");
			System.out.println("9) Mostrar cantidad de datos");
			System.out.println("10) salir");
			System.out.println("Introduce opcion: ");
			opcion = entrada.nextInt();
			
			switch (opcion) {
			case 1:
				System.out.println("\nIntroduce dato: ");
				dato = entrada.nextInt();
				le1.agregarElementoInicio(dato);
				break;
				
			case 2:
				System.out.println("\nIntroduce dato: ");
				dato = entrada.nextInt();
				le1.agregarElementoFinal(dato);
				break;
				
			case 3:
				System.out.println("\nIntroduce dato: ");
				dato = entrada.nextInt();
				System.out.println("Introduce posicion: ");
				posicion = entrada.nextInt();
				le1.agregarElementoPosicionEspecifica(dato, posicion);
				break;
			
			case 4:
				System.out.println("Introduce dato a eliminar: ");
				dato = entrada.nextInt();
				le1.eliminarDatoEspecifico(dato);
				break;
				
			case 5:
				le1.eliminarInicio();
				break;
				
			case 6:
				le1.eliminarFinal();
				break;
				
			case 7:
				System.out.println("Introduce posicion: ");
				posicion = entrada.nextInt();
				le1.eliminarPosicionEspecifica(posicion);
				break;
				
			case 8:
				le1.mostrarListaEnlazada();
				break;
				
			case 9:
				le1.mostrarCantidadElementos();
				break;
				
			case 10:
				System.out.println("\nSaliendo . . . ");
				break;
			default:
				System.out.println("\nOpcion incorrecta");
				break;
			}
			
		} while(opcion != 10);
	}
}
