package es.masanz.ut5.iceslide.model;

public class IceSlide {

    // TODO 01: Definicion de atributos

    private int curlLevel;
    private int[][] escenario;
    private int filaJugadaor, columnaJugador;

    public IceSlide(int altura, int anchura){
        // TODO 02: conscructor 1
        escenario = new int[][]{new int[]{altura}, new int[]{anchura}};
        filaJugadaor = 0;
        columnaJugador = 0;
    }

    public IceSlide(int[][] escenario){
        // TODO 03: conscructor 2
        clonarEscenario(escenario);
        if (!encontrarJugador()){
            filaJugadaor = 0;
            columnaJugador = 0;
        }
    }

    private void clonarEscenario(int[][] escenario) {
        // TODO 04: clonar la matriz facilitada sobre el atributo escenario
        int[][] matrizClonada = new int[0][];
        for (int i = 0; i < escenario.length; i++) {
            for (int j = 0; j < escenario[0].length; j++) {
                matrizClonada[i][j] = escenario[i][j];
            }
        }
    }

    private boolean encontrarJugador() {
        // TODO 05: localizar la celda tipo JUGADOR en el atributo escenario
        for (int i = 0; i < escenario.length; i++) {
            for (int j = 0; j < escenario[0].length; j++) {
                if (escenario[i][0] == filaJugadaor && escenario[0][j] == columnaJugador){
                    return true;
                }
            }
        }
        return false;
    }

    public void moverJugador(int despFila, int despCol){
        // TODO 06: desplazar el jugador siguiendo las reglas indicadas
    }

    private boolean desplazarHielo(int filaHielo, int colHielo, int despFila, int despCol) {
        // TODO 07: desplazar el bloque de hielo siguiendo las reglas indicadas
        return false;
    }

    public boolean completado(){
        // TODO 08: indicar si el nivel ha sido resuelto
        return false;
    }

    public int[][] getEscenario() {
        // TODO 09: devolver el objeto correspondiente
        return null;
    }
}
