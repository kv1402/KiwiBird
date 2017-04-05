package com.kv1402.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Kv1402 on 05.04.2017.
 */

public abstract class State {
    protected OrthographicCamera cam; //camera to locate position of the world
    protected Vector3 mouse; //mouse 3-d
    protected GameStateManager gsm; //manage our state, state on the state pause state on the game

    protected State(GameStateManager gsm){ //constructor
        this.gsm= gsm;
        cam = new OrthographicCamera();
        mouse = new Vector3();

    }

    protected abstract void handleInput(); //
    public abstract void update(float dt); //take in dt (difference one fram rendered and next)
    public abstract void render(SpriteBatch ab);
    public abstract void dispose();
}
