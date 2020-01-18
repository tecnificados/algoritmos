package org.tecnificados.algoritmos.voraz;


/**
 * @author Juan Carlos Ballesteros (tecnificados.com)
 */
public class Pelicula
{
  private String Titulo;
  private int Duracion;
  private double Hora;
  private int Sala;

  public Pelicula(String T, int D, double H, int S)
  {
    Titulo=T;
    Duracion=D;
    Hora=H;
    Sala=S;
  }

  public Pelicula(Pelicula P)
 {
   Titulo=P.dameTitulo();
   Duracion=P.dameDuracion();
   Hora=P.dameHora();
   Sala=P.dameSala();
 }


  public String dameTitulo(){return Titulo;}
  public double dameHora(){return Hora;}
  public int dameDuracion(){return Duracion;}
  public int dameSala(){return Sala;}
  public double dameTiempo(){return (Hora+((double)Duracion/60));}

  public String toString()
  {
    String cadena=dameTitulo()+" a las "+dameHora()+"0 dura "+dameDuracion()+" minutos en la sala "+dameSala();
    return cadena;
  }

  public static void main(String[] args)
   {
     Pelicula p1=new Pelicula("matrix",90,22.30,18);
     System.out.println(p1);
   }


}