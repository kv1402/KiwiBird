package com.kv1402.game.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.kv1402.game.FlappyDemo;
import com.kv1402.game.sprites.Bird;
import com.kv1402.game.sprites.Tube;

/**
 * Created by Kv1402 on 05.04.2017.
 */

public class PlayState extends State {
    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;

    private Array<Tube> tubes;
    private Bird bird;
    private Texture bg;


    protected PlayState(GameStateManager gam) {
        super(gam);
        bird = new Bird(50,300);
        cam.setToOrtho(false, FlappyDemo.WIDTH/2, FlappyDemo.HEIGHT/2);
        bg= new Texture("bg.png");


        tubes = new Array<Tube>();

        for(int i =1; i <= TUBE_COUNT; i++){
            tubes.add(new Tube(i*(TUBE_SPACING+ Tube.TUBE_WIDTH)));
        }
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched())
            bird.jump();
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
        cam.position.x = bird.getPosition().x + 80;
        //logic to reposition
        //off the screen?
        for(Tube tube: tubes){
            if (cam.position.x -(cam.viewportWidth/2)>tube.getPostTopTube().x + tube.getTopTube().getWidth()){
                tube.reposition(tube.getPostTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING )* TUBE_COUNT));
            }
        }
        cam.update();
    }

    @Override
    public void render(SpriteBatch ab) {
        ab.setProjectionMatrix(cam.combined);//where in the gameworld we are
        ab.begin();
        ab.draw(bg,cam.position.x -(cam.viewportWidth/2),0);
        ab.draw(bird.getBird(), bird.getPosition().x, bird.getPosition().y);
        for(Tube tube :tubes){
            ab.draw(tube.getTopTube(),tube.getPostTopTube().x, tube.getPostTopTube().y);
            ab.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        }

        ab.end();
    }

    @Override
    public void dispose() {

    }
}
