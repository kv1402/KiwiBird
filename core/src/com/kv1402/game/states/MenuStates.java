package com.kv1402.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kv1402.game.FlappyDemo;

/**
 * Created by Kv1402 on 05.04.2017.
 */

public class MenuStates extends State {

    private Texture background;
    private Texture playButton;

    public MenuStates(GameStateManager gsm) {
        super(gsm);
        background= new Texture("bg.png");
        playButton= new Texture("playBtn.png");
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            dispose();
        }
        handleInput();
    }

    @Override
    public void render(SpriteBatch ab) {
        ab.begin();
        ab.draw(background,0,0,FlappyDemo.WIDTH, FlappyDemo.HEIGHT);
        ab.draw(playButton,(FlappyDemo.WIDTH/2)-(playButton.getWidth()/2), FlappyDemo.HEIGHT/2 );
        ab.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}
