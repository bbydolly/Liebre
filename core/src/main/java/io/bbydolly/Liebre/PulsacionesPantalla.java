package io.bbydolly.Liebre;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public  class PulsacionesPantalla implements GestureDetector.GestureListener{
    public boolean one_pulsation;
    public boolean two_pulsation;
    public int num_animacion;


    public int getNum_animacion() {
        return num_animacion;
    }

    public void setNum_animacion(int num_animacion) {
        this.num_animacion = num_animacion;
    }

    public boolean isOne_pulsation() {
        return one_pulsation;
    }

    public void setOne_pulsation(boolean one_pulsation) {
        this.one_pulsation = one_pulsation;
    }

    public boolean isTwo_pulsation() {
        return two_pulsation;
    }

    public void setTwo_pulsation(boolean two_pulsation) {
        this.two_pulsation = two_pulsation;
    }

    //Método que no funciona
    public int Pulsaciones(){

        try {
            setOne_pulsation(Gdx.input.isTouched(1));
            setTwo_pulsation(Gdx.input.isTouched(2));
           // System.out.println("ENTRA EN PULSACIONES");


            if (isOne_pulsation() & isTwo_pulsation()) {
               // System.out.println("DOS");
                return 2;
            } else {
               // System.out.println("UNO");
                return 1;
            }
        }catch (NullPointerException n){
            return 1;
        }
    }


    //Correr
    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        System.out.println(("Correr"));
        num_animacion=1;
        return false;
    }

    //Saltar
    @Override
    public boolean tap(float x, float y, int count, int button) {
        //contador
        num_animacion=2;
        System.out.println(("Saltar"));
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        System.out.println("Lonpress");
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
