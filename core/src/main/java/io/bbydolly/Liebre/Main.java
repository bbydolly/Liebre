package io.bbydolly.Liebre;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.ScreenUtils;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture conejo,fondoNieve;
    private Sprite fondo;
    public  Animacion a;
    private float tiempoTotal;
    private GestureDetector gesture;
    private PulsacionesPantalla pulsaciones;



    @Override
    public void create() {
        batch = new SpriteBatch();
        conejo = new Texture("bunny-Sheet.png");
        a=new Animacion();
        a.initTexturas();
        //a.initAnimaciones();
        fondoNieve=new Texture("fondonieve.jpeg");
        fondo=new Sprite(fondoNieve);
        tiempoTotal = 0.0f;
        pulsaciones=new PulsacionesPantalla();

    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        tiempoTotal++;
        batch.begin();
        fondo.draw(batch);
        batch.draw(fondo,
            0,
            0,
            Gdx.graphics.getWidth(),
            Gdx.graphics.getHeight()
        );

//        batch.draw(
//            a.elegirAnimacion("estatico", tiempoTotal),
//            a.getPosicionX(),
//            a.getPosicionY(),
//            a.getWidth(),
//            a.getHeight()
//        );

                batch.draw(
            a.AnimacionPulsaciones(pulsaciones.Pulsaciones(), tiempoTotal),
            a.getPosicionX(),
            a.getPosicionY(),
            a.getWidth(),
            a.getHeight()
        );

        //Te dice si se está tocando la pantalla
        //int numero_pulsaciones=pulsaciones.Pulsaciones();

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        conejo.dispose();
    }
}
