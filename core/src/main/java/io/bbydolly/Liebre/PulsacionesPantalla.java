package io.bbydolly.Liebre;

import com.badlogic.gdx.Gdx;

public class PulsacionesPantalla {
    public boolean one_pulsation;
    public boolean two_pulsation;

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

    public int Pulsaciones(){
        try {
            setOne_pulsation(Gdx.input.isTouched(1));
            setTwo_pulsation(Gdx.input.isTouched(2));
            System.out.println("ENTRA EN PULSACIONES");

            if (isOne_pulsation() & isTwo_pulsation()) {
                System.out.println("DOS");
                return 2;
            } else {
               // System.out.println("UNO");
                return 1;
            }
        }catch (NullPointerException n){
            return 1;
        }
    }



}
