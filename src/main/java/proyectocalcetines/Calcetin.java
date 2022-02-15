/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocalcetines;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author cristina
 */
public class Calcetin {

    //Atributos que lo usaremos
    private int talla;
    private ColorCalcetines color;
    private Random random;

    //Constructores
    public Calcetin() {
        random = new Random();
        this.talla = random.nextInt(43 - 40 + 1) + 43;
        int colorAleatorio = random.nextInt(2);
        //Para que tenga un color aleatorio.
        switch (colorAleatorio) {
            case 0:
                this.color = color.NEGRO;
                break;
            case 1:
                this.color = color.GRIS_CLARO;
                break;
            case 2:
                this.color = color.GRIS_OSCURO;
                break;
        }

    }

    //getters y setters
    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public ColorCalcetines getColor() {
        return color;
    }

    public void setColor(ColorCalcetines color) {
        this.color = color;
    }

    //toString
    @Override
    public String toString() {
        return "Calcetin{" + "talla=" + talla + ", color=" + color + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.talla;
        hash = 19 * hash + Objects.hashCode(this.color);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Calcetin other = (Calcetin) obj;
        if (this.talla != other.talla) {
            return false;
        }
        return this.color == other.color;
    }

}
