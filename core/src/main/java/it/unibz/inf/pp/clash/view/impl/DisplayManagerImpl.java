package main.java.it.unibz.inf.pp.clash.view.impl;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import main.java.it.unibz.inf.pp.clash.model.EventHandler;
import main.java.it.unibz.inf.pp.clash.model.snapshot.Snapshot;
import main.java.it.unibz.inf.pp.clash.view.DisplayManager;
import main.java.it.unibz.inf.pp.clash.view.exceptions.NoGameOnScreenException;
import main.java.it.unibz.inf.pp.clash.view.screen.game.GameScreen;
import main.java.it.unibz.inf.pp.clash.view.screen.home.HomeScreen;
import main.java.it.unibz.inf.pp.clash.view.singletons.FileManager;
import main.java.it.unibz.inf.pp.clash.view.singletons.FontManager;
import main.java.it.unibz.inf.pp.clash.view.singletons.ImageManager;
import main.java.it.unibz.inf.pp.clash.view.singletons.SkinManager;

import java.util.Optional;

public class DisplayManagerImpl extends Game implements DisplayManager {


    private final boolean debug;
    private final float animationDuration;
    private EventHandler eventHandler;
    private HomeScreen homeScreen;
    private GameScreen gameScreen;


    /**
     * @param debug if true, then the compositor will draw in debug mode.
     *              In particular, the borders of all cells in tables will be drawn on screen.
     *              Should be set to false when drawing the actual graphical user interface.
     */
    public DisplayManagerImpl(boolean debug) {
        this.animationDuration = FileManager.instance().parseAnimationDuration(1);
        this.debug = debug;
    }

    public DisplayManagerImpl() {
        this(false);
    }

    @Override
    public void create() {
        drawHomeScreen();
    }

    @Override
    public void dispose() {
        Optional.ofNullable(gameScreen).ifPresent(GameScreen::dispose);
        Optional.ofNullable(homeScreen).ifPresent(HomeScreen::dispose);
        SkinManager.instance().dispose();
        ImageManager.instance().dispose();
        FontManager.instance().dispose();
    }

    @Override
    public void updateMessage(String message) throws NoGameOnScreenException {
        if(gameScreen == null || getScreen() != gameScreen){
            throw new NoGameOnScreenException();
        }
        gameScreen.updateMessage(message);
    }

    @Override
    public void drawSnapshot(Snapshot snapshot, String message) {
        if (gameScreen == null) {
            gameScreen = new GameScreen(
                    eventHandler,
                    animationDuration,
                    debug
            );
            setScreen(gameScreen);
        }
        gameScreen.drawSnapshot(snapshot, message);
    }

    @Override
    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public void drawHomeScreen(){
        if(homeScreen == null) {
            homeScreen = new HomeScreen(this, eventHandler, debug);
        }
        if(gameScreen != null) {
            gameScreen.dispose();
            gameScreen = null;
        }

        setScreen(homeScreen);
        homeScreen.render(Gdx.graphics.getDeltaTime());
    }
}
