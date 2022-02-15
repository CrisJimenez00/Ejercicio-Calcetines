/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocalcetines;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author cristina
 */
public class CajonCalcetin {

    //ArrayList donde se guardan todos los calcetines aleatorios
    ArrayList<Calcetin> lista;
    ArrayList<Calcetin> listaEmparejados;
    Calcetin[] calcetinesSolitarios;
    //Lo usaremos para que el tamaño sea aleatorio entre otros casos
    private Random random;

    //Constructor que inicializa el ArrayList
    public CajonCalcetin() {
        this.lista = new ArrayList<>();
    }

    //Método el cual nos permite llenar el array
    private ArrayList<Calcetin> llenarArray() {
        //Inicializamos el objeto de tipo Random
        random = new Random();

        //lo usaremos para declarar el tamaño de la lista sea entre 10 y 20 de forma aleatoria
        int tamanioArray = random.nextInt(20 - 10 + 1) + 10;

        //Las listas al ser dinámicas en el for no usaremos lista.size, usaremos tamanioArray.
        for (int i = 0; i < tamanioArray; i++) {
            //Lo que hacemos aquí es que según el tamaño aleatorio que ha salido le añadimos un calcetin creado de forma aleatoria
            lista.add(new Calcetin());
        }
        return lista;

    }

    //Método el cual nos sirve para imprimir la lista de calcetines
    private void imprimirLista() {
        for (Calcetin calcetin : lista) {
            System.out.println(calcetin + " , ");
        }
        System.out.println("");
    }

    //Método el cual nos permite imprimir la lista de calcetines emparejados
    private void imprimirEmparejados() {
        for (Calcetin calcetin : listaEmparejados) {
            System.out.println(calcetin + " , ");
        }
        System.out.println("");
    }

    //Método el cual nos permite imprimir por consola los calcetines sin pareja
    private void imprimirListaSolitarios() {
        for (int i = 0; i < calcetinesSolitarios.length; i++) {
            System.out.println(calcetinesSolitarios[i]);
        }
    }

    //Método el cual crea el array de calcetines
    private Calcetin[] devolverArrayCalcetines() {
        calcetinesSolitarios = new Calcetin[lista.size()];

        for (int i = 0; i < calcetinesSolitarios.length; i++) {

            //los que sobran en la lista(que no están emparejados) lo pasamos al array
            calcetinesSolitarios[i] = lista.get(i);

        }
        return calcetinesSolitarios;
    }

    //Método el cual compara calcetines y los añade en otra lista de emparejados
    public void compararCalcetines() {
        int n = 0;
        lista = llenarArray();
        listaEmparejados = new ArrayList<>();
        System.out.println("Lista original--------");
        imprimirLista();

        for (int i = 0; i < lista.size(); i++) {

            //Comparamos talla y color
            if (lista.get(i).equals(lista.get(n))) {

                listaEmparejados.add(lista.get(i));
                listaEmparejados.add(lista.get(n));
                //Al ser pareja lo tenemos que eliminar de la lista inicial
                try {
                    lista.remove(i);
                    lista.remove(n);
                } catch (IndexOutOfBoundsException iobe) {
                    System.out.println("\n");
                }

                //Pasamos al siguiente calcetín
                n++;
            }
        }
        n = 0;
        //Para asegurarnos de que no hay niguna pareja(porque en el primer for se me escapaba alguno en ocasiones)
        for (int i = 0; i < lista.size(); i++) {

            //Comparamos talla y color
            if (lista.get(i).equals(lista.get(n))) {

                listaEmparejados.add(lista.get(i));
                listaEmparejados.add(lista.get(n));
                //Al ser pareja lo tenemos que eliminar de la lista inicial
                try {
                    lista.remove(i);
                    lista.remove(n);
                } catch (IndexOutOfBoundsException iobe) {
                    System.out.println("\n");
                }

                //Pasamos al siguiente calcetín
                n++;
            }
        }

        System.out.println("---------MOSTRAMOS LOS EMPAREJADOS--------");
        imprimirEmparejados();
        devolverArrayCalcetines();
        System.out.println("--------CALCETINES QUE NO TIENEN PAREJA--------");
        imprimirListaSolitarios();
    }

}
