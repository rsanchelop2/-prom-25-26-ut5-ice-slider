package es.masanz.ut5.iceslide.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public enum Celda {

    VACIO(0, null),
    PARED(1, "/imgs/brick-wall.png"),
    HIELO(2, "/imgs/ice-cube.png"),
    FUEGO(3, "/imgs/flame.png"),
    CHARCO(4, "/imgs/water-splash.png"),
    JUGADOR(5, "/imgs/snowman.png");

    private final int valor;
    private final String img;

    Celda(int valor, String img) {
        this.valor = valor;
        this.img = img;
    }

    public ImageView obtenerImagen(){
        ImageView iv;
        if(img!=null){
            Image imgFX = new Image(getClass().getResource(img).toString());
            iv = new ImageView(imgFX);
        } else {
            iv = new ImageView();
        }
        return iv;
    }

    public int getValor() {
        return valor;
    }
}
