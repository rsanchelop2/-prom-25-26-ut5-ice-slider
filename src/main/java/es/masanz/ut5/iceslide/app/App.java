package es.masanz.ut5.iceslide.app;

import es.masanz.ut5.iceslide.model.Celda;
import es.masanz.ut5.iceslide.model.IceSlide;
import es.masanz.ut5.iceslide.model.Nivel;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class App extends Application {

    private static final int TAMANO_CELDA = 60;
    private StackPane root;
    private GridPane gridPane;
    private Button resetStage, nextStage;
    private int curLevel;
    private int[][] matrizNivel;
    private IceSlide iceSlide;

    @Override
    public void start(Stage primaryStage) {

        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        root = new StackPane(gridPane);
        curLevel = 1;
        matrizNivel = cargarNivel(curLevel);
        iceSlide = new IceSlide(matrizNivel);

        pintarMatriz();

        Scene scene = new Scene(root, matrizNivel[0].length * TAMANO_CELDA, matrizNivel.length * TAMANO_CELDA);
        scene.setOnKeyPressed(event -> {
            switch(event.getCode()) {
                case UP, W    -> {
                    // TODO 11: desplazar el jugador hacia ARRIBA

                }
                case DOWN, S  -> {
                    // TODO 12: desplazar el jugador hacia ABAJO

                }
                case LEFT, A  -> {
                    // TODO 13: desplazar el jugador hacia la IZQUIERDA

                }
                case RIGHT, D -> {
                    // TODO 14: desplazar el jugador hacia la DERECHA

                }
                default -> {}
            }
            pintarMatriz();
            if(iceSlide.completado()){
                mostrarMensaje();
            }
        });

        resetStage = new Button("Reiniciar");
        resetStage.setTranslateX(matrizNivel[0].length * TAMANO_CELDA / -2 + 40);
        resetStage.setTranslateY(matrizNivel.length * TAMANO_CELDA / -2 + 20);
        resetStage.setOnAction(event -> {
            ocultarMensaje();
            iceSlide = new IceSlide(matrizNivel);
            pintarMatriz();
        });

        nextStage = new Button("Siguiente Nivel");
        nextStage.setTranslateX(matrizNivel[0].length * TAMANO_CELDA / -2 + 140);
        nextStage.setTranslateY(matrizNivel.length * TAMANO_CELDA / -2 + 20);
        nextStage.setOnAction(event -> {
            ocultarMensaje();
            curLevel++;
            if(curLevel > Nivel.values().length){
                curLevel = 1;
            }
            matrizNivel = cargarNivel(curLevel);
            iceSlide = new IceSlide(matrizNivel);
            pintarMatriz();
        });
        root.getChildren().addAll(resetStage, nextStage);
        primaryStage.setTitle("Ice Slider");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private int[][] cargarNivel(int numero) {
        // TODO 15: Devolver el nivel correspondiente al numero indicado, sino existe devolver null
        //  Recorrer el enum Nivel para ello
        return null;
    }

    public void pintarMatriz() {
        gridPane.getChildren().clear();
        int[][] escenario = iceSlide.getEscenario();
        if(escenario!=null){
            int filas = escenario.length;
            int cols = escenario[0].length;
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < cols; j++) {
                    int valor = escenario[i][j];
                    Rectangle fondo = new Rectangle(TAMANO_CELDA, TAMANO_CELDA);
                    fondo.setFill(Color.BLACK);
                    StackPane celda = null;
                    ImageView img = Celda.values()[valor].obtenerImagen();
                    if(img!=null) {
                        img.setFitWidth(TAMANO_CELDA);
                        img.setFitHeight(TAMANO_CELDA);
                        celda = new StackPane(fondo, img);
                    } else {
                        celda = new StackPane(fondo);
                    }
                    gridPane.add(celda, j, i);
                }
            }
        }
    }

    public void mostrarMensaje() {
        StackPane overlay = new StackPane();
        overlay.setStyle("-fx-background-color: rgba(0,0,0,0.5);");
        overlay.setPrefSize(root.getWidth(), root.getHeight());
        javafx.scene.text.Text texto = new javafx.scene.text.Text("¡Has ganado!");
        texto.setFill(Color.WHITE);
        texto.setStyle("-fx-font-size: 40px; -fx-font-weight: bold;");
        texto.setStrokeWidth(2);
        overlay.getChildren().add(texto);
        StackPane.setAlignment(texto, Pos.CENTER);
        root.getChildren().add(overlay);
        resetStage.toFront();
        nextStage.toFront();
    }

    public void ocultarMensaje(){
        if(root.getChildren().size()==4){
            root.getChildren().remove(1);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
