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

/*
 * Lista enlazada 
 * Operaciones basicas
 * 
 * 1) creacion
 * 2) Insertar
 * 		2a) Al inicio
 * 		2b) Al final
 * 		2c) En pocicion especifica
 * 3) Eliminar
 * 		3a) dato
 * 		3b) Posicion
 * 4) Mostrar o recorrer
 * 
 */

class ListaEnlazada{
	Nodo nodoInicio;
	Nodo nodoFin;
	
	// 1) Creacion
	public ListaEnlazada() {
		nodoInicio = nodoFin = null; // no es nesesario
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
	}
	
	// 2c) Agregar elemento en posicion especifica
	public void agregarElementoPosicionEspecifica(int dato, int posicion) {
		Nodo nodoNuevo = new Nodo(dato);
		int contPosicion = 0;
		if(nodoInicio == null) {
			nodoInicio = nodoFin = nodoNuevo;
		} else {
			if (posicion == 0) {
				agregarElementoInicio(dato);
			} else {
				Nodo nodoActual = nodoInicio.getNodoSiguiente();
				Nodo nodoAnterior = nodoInicio;
				
				while(nodoActual != null) {
					contPosicion++;
					if(contPosicion == posicion) {
						nodoAnterior.setNodoSiguiente(nodoNuevo);
						nodoNuevo.setNodoSiguiente(nodoActual);
						break;
					} else {
						// se recorren
						nodoAnterior = nodoActual;
						// nodoAnterior = nodoAnterior.getNodoSiguiente();
						nodoActual = nodoActual.getNodoSiguiente();
					}
				}
				//------------------------------------
				if(nodoActual == null && contPosicion == posicion-1) {
					agregarElementoFinal(dato);
				} else {
					//System.out.println("\nNo existe la pocicion");
				}
			}
		}
	}
	// 3a) Eliminar dato
	public void eliminarDato(int dato) {
		if (nodoInicio == null) {
			System.out.println("\nLista vacia");
		} else {
			if(nodoInicio.getDato() == dato && nodoInicio == nodoFin) {
				nodoInicio = nodoFin = null;
			} else {
				Nodo nodoActual = nodoInicio;
				Nodo nodoAnterior = null;
				
				while(nodoActual != null) {
					if(nodoActual.getDato() == dato) {
						if(nodoAnterior != null) {
							// se inserta en medio
							nodoAnterior.setNodoSiguiente(nodoActual.getNodoSiguiente());
						} else {
							// dejan de apuntar al primer
							nodoInicio = nodoActual.getNodoSiguiente();
						}
						break;
					}else {
						nodoAnterior = nodoActual;
						nodoActual = nodoActual.getNodoSiguiente();
					}
				}
			}
		}
	}
	
	// 3b) eliminar inicio
	
	public void eliminarInicio() {
		if(nodoInicio == null) {
			System.out.println("\nLista vacia");
		} else {
			if(nodoInicio == nodoFin) {
				nodoInicio = nodoFin = null;
			} else {
				nodoInicio = nodoInicio.getNodoSiguiente();
			}
		}
	}
	
	// 3c) eliminar final
	
	public void eliminarFinal() {
		if(nodoInicio == null) {
			System.out.println("\nLista vacia");
		} else {
			if(nodoInicio == nodoFin) {
				nodoInicio = nodoFin = null;
			} else {
				Nodo nodoActual = nodoInicio;
				Nodo nodoAnterior = null;
				while(nodoActual != nodoFin) {
					nodoAnterior = nodoActual;
					nodoActual = nodoActual.getNodoSiguiente();
				}
				nodoAnterior.setNodoSiguiente(null);
				nodoFin = nodoAnterior;
			}
		}
	}
	
	// 3d) eliminar pocicion especifica
	
	public void eliminarPosicionEspecifica(int posicion) {
		if(nodoInicio == null) {
			System.out.println("Lista vacia");
		} else if (nodoInicio == nodoFin) {
			if(posicion == 0) {
				nodoInicio = nodoFin = null;
			} else {
				System.out.println("No existe esa posicion");
			}
		} else {
			int contPosicion = 0;
			Nodo nodoAnterior = nodoInicio;
			Nodo nodoActual = nodoInicio.getNodoSiguiente();
			
			if(posicion == 0) {
				eliminarInicio();
			} else {
				while(nodoActual != null) {
					contPosicion++;
					if(contPosicion == posicion) {
						nodoAnterior.setNodoSiguiente(nodoActual.getNodoSiguiente());
						break;
					} else {
						nodoAnterior = nodoAnterior.getNodoSiguiente();
						nodoActual = nodoActual.getNodoSiguiente();
					}
				}
			}
			
		}
	}
	
	// 4) Mostrar o recorrer
	
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
		
		/*
		 * Lista enlazada 
		 * Operaciones basicas
		 * 
		 * 1) creacion
		 * 2) Insertar
		 * 		2a) Al inicio
		 * 		2b) Al final
		 * 		2c) En pocicion especifica
		 * 3) Eliminar
		 * 		3a) dato
		 * 		3b) Posicion
		 * 4) Mostrar o recorrer
		 * 
		 */
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
				le1.eliminarDato(dato);
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
