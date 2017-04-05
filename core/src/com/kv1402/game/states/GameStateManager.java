package com.kv1402.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by Kv1402 on 05.04.2017.
 */

/**Create a manager has a stack of states, renders and updates the one on tops
 *
 */

public class GameStateManager {

    private Stack<State> states;

    public GameStateManager(){
        states = new Stack<State>();
    }

    //Manage our stacks
    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop();
    }

    public void set(State state){ //poppe og pushe instant
        states.pop();
        states.push(state);
    }

    public void update(float dt){// ser på toppen
        states.peek().update(dt);
    }

    public void render(SpriteBatch ab){
        states.peek().render(ab);
    }
}
