package org.tecnificados.algoritmos.voraz;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Juan Carlos Ballesteros (tecnificados.com)
 */
public class SolucionVoraz {

	private static final Logger log = LoggerFactory.getLogger(SolucionVoraz.class);

	// Peliculas disponibles
	List<Pelicula> peliculasEnCartel=new ArrayList<Pelicula>();
	// Solución
	List<Pelicula> laSolucion=new ArrayList<Pelicula>();


	public SolucionVoraz() {
		peliculasEnCartel=new ArrayList<Pelicula>();
		laSolucion=new ArrayList<Pelicula>();
	}

	



	// funcion que a�ade una pelicula
	public void add(Pelicula peli) {
		peliculasEnCartel.add(peli);
	}

	// funcion toString
	public String toString() {
		String Cadena = "";
		for (Pelicula peli:peliculasEnCartel)
			Cadena = Cadena + peli.toString() + "\n";
		return Cadena;
	}

	// funcion cambia que se usa para el quicksort
	private void cambia(List<Pelicula> lista, int j, int k) {
		Pelicula aux = lista.get(j);
		lista.set(j,lista.get(k));
		lista.set(k, aux);
	}

	// funcion particion que se usa para el quicksort
	private int particion(List<Pelicula> a, int m, int n) {
		Pelicula x = a.get(m); // Pivote
		int j = n + 1;
		int i = m - 1;
		while (true) {
			j--;
			while ((a.get(j)).dameTiempo() > x.dameTiempo())
				j--;
			i++;
			while ((a.get(i)).dameTiempo() < x.dameTiempo())
				i++;
			if (i < j)
				cambia(a, i, j);
			else
				return j;
		}
	}

	// funcion que ordena el vector de las peliculas por hora y duracion
	public void quickSort(int l, int r) {
		if (l < r) {
			int aux = particion(peliculasEnCartel, l, r);
			quickSort(l, aux);
			quickSort(aux + 1, r);
		}
	}

	// funcion que elige las peliculas usando algoritmo voraz
	public void solucion() {
		// Empiezo a escoger
		int pasadas = 0;
		double Horafin = 0;
		while (pasadas < peliculasEnCartel.size()) {
			// cogo una pelicula
			Pelicula aux = peliculasEnCartel.get(pasadas);
			// miro a que hora acaba
			Horafin = aux.dameTiempo();
			// la imprimo por pantalla
			log.info(aux.toString());
			// la guardo en el vector
			laSolucion.add(aux);
			// miro la siguiente
			pasadas++;
			// si me cabe la eligo, en caso contrario busco la siguiente
			if (pasadas < peliculasEnCartel.size()) {
				while (peliculasEnCartel.get(pasadas).dameHora() < Horafin)
					pasadas++;
			}
		}
	}

	public static void main(String[] args) {
		
	
		// creo las peliculas (considero que las medias horas son de 50, 9.30=9.50)
		Pelicula p1 = new Pelicula("El exorcista", 90, 21.50, 1);
		Pelicula p2 = new Pelicula("Pesadilla en Elm Street 4", 120, 9.50, 2);
		Pelicula p3 = new Pelicula("La Pesadilla final", 96, 10.50, 3);
		Pelicula p4 = new Pelicula("Reanimator", 90, 12.50, 4);
		Pelicula p5 = new Pelicula("La Nueva Pesadilla", 120, 12.50, 5);
		Pelicula p6 = new Pelicula("Viernes 13", 100, 14.00, 6);
		Pelicula p7 = new Pelicula("Apocalipsis", 223, 15.00, 7);
		Pelicula p8 = new Pelicula("It", 183, 16.50, 8);
		Pelicula p9 = new Pelicula("Halloween", 74, 17.30, 9);
		Pelicula p10 = new Pelicula("El Ente", 96, 17.00, 10);
		Pelicula p11 = new Pelicula("Jason X", 81, 18.00, 1);
		Pelicula p12 = new Pelicula("La Celda", 123, 15.00, 2);
		Pelicula p13 = new Pelicula("Horizonte Final", 87, 16.00, 3);
		Pelicula p14 = new Pelicula("Destino Final", 95, 17.00, 4);
		Pelicula p15 = new Pelicula("Mortal Zombie", 93, 17.50, 5);

		SolucionVoraz Peliculas = new SolucionVoraz();

		Peliculas.add(p1);
		Peliculas.add(p2);
		Peliculas.add(p3);
		Peliculas.add(p4);
		Peliculas.add(p5);
		Peliculas.add(p6);
		Peliculas.add(p7);
		Peliculas.add(p8);
		Peliculas.add(p9);
		Peliculas.add(p10);
		Peliculas.add(p11);
		Peliculas.add(p12);
		Peliculas.add(p13);
		Peliculas.add(p14);
		Peliculas.add(p15);
		// imprimo las peliculas
		log.info("****************Cartel****************");
		for (Pelicula p:Peliculas.peliculasEnCartel)
		{
			log.info(p.toString());
		}
		// ordeno las peliculas por hora y duracion
		Peliculas.quickSort(0, 14);
		// imprimo las peliculas ordenadas
		log.info("****************Ordenadas****************");
		for (Pelicula p:Peliculas.peliculasEnCartel)
		{
			log.info(p.toString());
		}
		// llamo a la funcion solucion
		log.info("****************Solución****************");
		Peliculas.solucion();
	}
}