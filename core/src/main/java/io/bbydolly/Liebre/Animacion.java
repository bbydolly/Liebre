package io.bbydolly.Liebre;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animacion {
    //Texturas
    public Texture conejo1 = new Texture("bunny-Sheet.png");
    public TextureRegion texturaConejo1Correr[];
    public TextureRegion texturaConejo1Estatico[];
    //    public TextureRegion texturaConejo1Salto[];
    public TextureRegion[][] conejo1Corre = TextureRegion.split(conejo1, conejo1.getWidth() / 4, conejo1.getHeight() / 6);

    //Animaciones
    public Animation<TextureRegion> animacionCorrerConejo1;
    public Animation<TextureRegion> animacionEstaticoConejo1;

    //Tiempo
    public float duracionFrame = 15f;
    // tiempo entre frames
    final float delta = Gdx.graphics.getDeltaTime();

    //Alto y ancho frame
    public int width;
    public int hight;

    //Escala
    float escala = 3f;

    //Coordenadas de inicio
    private float posicionX = 3;
    private float posicionY = 10;

    //Frame actual
    private int frameActual = 0;


    //setters y getters
    public TextureRegion[] getTexturaConejo1Correr() {
        return texturaConejo1Correr;
    }

    public void setTexturaConejo1Correr(TextureRegion[] texturaConejo1Correr) {
        this.texturaConejo1Correr = texturaConejo1Correr;
    }

    public TextureRegion[] getTexturaConejo1Estatico() {
        return texturaConejo1Estatico;
    }

    public void setTexturaConejo1Estatico(TextureRegion[] texturaConejo1Estatico) {
        this.texturaConejo1Estatico = texturaConejo1Estatico;
    }

    public float getWidth() {
        return texturaConejo1Correr[0].getRegionWidth() * escala;
    }

    public float getHeight() {
        return texturaConejo1Correr[0].getRegionHeight() * escala;
    }

    public float getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(float posicionX) {
        this.posicionX = posicionX;
    }

    public float getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(float posicionY) {
        this.posicionY = posicionY;
    }

    public int getFrameActual() {
        return frameActual;
    }

    public void setFrameActual(int frameActual) {
        this.frameActual = frameActual;
    }

    //Inicia las texturas
    public void initTexturas() {
        //Textura correr
        texturaConejo1Correr = new TextureRegion[5];
        texturaConejo1Correr[0] = conejo1Corre[3][2];
        texturaConejo1Correr[1] = conejo1Corre[2][3];
        texturaConejo1Correr[2] = conejo1Corre[2][2];
        texturaConejo1Correr[3] = conejo1Corre[2][1];
        texturaConejo1Correr[4] = conejo1Corre[2][0];
        setTexturaConejo1Correr(texturaConejo1Correr);

        //Textura estatica
        texturaConejo1Estatico = new TextureRegion[4];
        texturaConejo1Estatico[0] = conejo1Corre[4][3];
        texturaConejo1Estatico[1] = conejo1Corre[1][0];
        texturaConejo1Estatico[2] = conejo1Corre[1][3];
        texturaConejo1Estatico[3] = conejo1Corre[4][2];
        setTexturaConejo1Estatico(texturaConejo1Estatico);

        initAnimaciones();
    }


    //Inicia las animaciones
    public void initAnimaciones() {
        //Animacion conejo corriendo
        animacionCorrerConejo1 = new Animation<>(duracionFrame, getTexturaConejo1Correr());
        animacionCorrerConejo1.setPlayMode(Animation.PlayMode.LOOP);


        //Animación conejo estática
        animacionEstaticoConejo1 = new Animation<>(duracionFrame, getTexturaConejo1Estatico());
        animacionEstaticoConejo1.setPlayMode(Animation.PlayMode.LOOP);


    }

    public void avanzarFrame(TextureRegion[] animacion) {
        frameActual++;

        if (frameActual >= animacion.length) {
            frameActual = 0;
        }
    }

//    public TextureRegion elegirAnimacion(String animation, float tiempoTotal) {
//
//        switch (animation) {
//            case "correr":
////               avanzarFrame(texturaConejo1Correr);
//                //return texturaConejo1Correr;
//
//            case "estatico":
//
//                return animacionEstaticoConejo1.getKeyFrame(tiempoTotal);
//
//
////            case "salto":
////                return texturaConejo1Salto;
////                break;
//        }
//        return null;
//
//    }

    //Prueba para gestionar pulsaciones y cargar animacion
    public TextureRegion AnimacionPulsaciones(int pulsacion, float tiempoTotal) {

        switch (pulsacion) {
            case 1: //corre
//               avanzarFrame(texturaConejo1Correr);
                return animacionCorrerConejo1.getKeyFrame(tiempoTotal);

            case 2: //salta

                return animacionEstaticoConejo1.getKeyFrame(tiempoTotal);

            default: //se mantiene estático
                break;

        }
        return null;

    }
}





