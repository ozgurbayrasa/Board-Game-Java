package main.java.it.unibz.inf.pp.clash.controller.listeners;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import main.java.it.unibz.inf.pp.clash.view.singletons.ImageManager;
import main.java.it.unibz.inf.pp.clash.view.singletons.Dimensions;
import main.java.it.unibz.inf.pp.clash.view.singletons.FileManager;

import static main.java.it.unibz.inf.pp.clash.view.singletons.Dimensions.Resolution;

public class ResolutionChangeListener extends ChangeListener {

    @Override
    public void changed(ChangeEvent event, Actor actor) {

        Resolution newResolution = Resolution.valueOf("R_" + ((SelectBox<?>) actor).getSelected());
        Dimensions.instance().update(newResolution);
        FileManager.instance().updateResolution(newResolution);
        ImageManager.instance().updateResolution(newResolution);
    }

}
