package org.tecnificados.algoritmos.voraz;

public class SolucionVoraz
{
  //Vector de peliculas
  Pelicula laLista[];
  //Vector con las peliculas elegidas
  Pelicula laSolucion[];
  //Numero de peliculas en cartel
  int tam = 0;

  public SolucionVoraz()
  {
    laLista = new Pelicula[20];
    laSolucion = new Pelicula[20];
  }
  //funcion que devuelve el tama�o
  public int dameTam() {return tam;}
  //funcion que devuelve una pelicula de la lista
  public Pelicula damePelicula(int p) {return laLista[p];}
  //funcion que a�ade una pelicula
  public void add(Pelicula P)
  {
    laLista[tam++] = P;
  }
  //funcion toString
  public String toString()
  {
    String Cadena = "";
    for (int i = 0; i < tam; i++)
      Cadena = Cadena + laLista[i] + "\n";
    return Cadena;
  }

  //funcion cambia que se usa para el quicksort
  private void cambia(Pelicula vector[], int j, int k)
  {
    Pelicula aux = vector[j];
    vector[j] = vector[k];
    vector[k] = aux;
  }
  //funcion particion que se usa para el quicksort
  private int particion(Pelicula a[], int m, int n) {
    Pelicula x = a[m]; // Pivote
    int j = n + 1;
    int i = m - 1;
    while (true) {
      j--;
      while ( (a[j]).dameTiempo() > x.dameTiempo())
        j--;
      i++;
      while ( (a[i]).dameTiempo() < x.dameTiempo())
        i++;
      if (i < j)
        cambia(a, i, j);
      else
        return j;
    }
  }
  //funcion que ordena el vector de las peliculas por hora y duracion
  public void quickSort(int l, int r) {
    //La funcion en si
    if (l < r) {
      int aux = particion(laLista, l, r);
      quickSort(l, aux);
      quickSort(aux + 1, r);
    }
  }

  //funcion que elige las peliculas usando algoritmo voraz
  public void solucion() {
    //Empiezo a escoger
    int pasadas = 0;
    int solucion = 0;
    double Horafin = 0;
    while (pasadas < dameTam()) {
      //cogo una pelicula
      Pelicula aux = damePelicula(pasadas);
      //miro a que hora acaba
      Horafin = aux.dameTiempo();
      //la imprimo por pantalla
      System.out.println(aux);
      //la guardo en el vector
      laSolucion[solucion++]=aux;
      //miro la siguiente
      pasadas++;
      //si me cabe la eligo, en caso contrario busco la siguiente
      if (pasadas < dameTam()) {
        while (damePelicula(pasadas).dameHora() < Horafin)
          pasadas++;
      }
    }
  }

  public static void main(String[] args)
  {
    //creo las peliculas  (considero que las medias horas son de 50, 9.30=9.50)
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
    Pelicula p11 = new Pelicula("Jason X", 81, 17.00, 11);
    Pelicula p12 = new Pelicula("La Celda", 123, 15.00, 12);
    Pelicula p13 = new Pelicula("Horizonte Final", 87, 14.00, 13);
    Pelicula p14 = new Pelicula("Destino Final", 95, 16.00, 14);
    Pelicula p15 = new Pelicula("Mortal Zombie", 93, 17.50, 15);
    //Creo la clase ejercicio_9
    SolucionVoraz Peliculas = new SolucionVoraz();
    //A�ado las peliculas
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
    //imprimo las peliculas
    System.out.println(Peliculas);
    //ordeno las peliculas por hora y duracion
    Peliculas.quickSort(0, 14);
    //imprimo las peliculas ordenadas
    System.out.println(Peliculas);
    //llamo a la funcion solucion
    Peliculas.solucion();
    }
}