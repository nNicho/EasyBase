package me.north.easybase.impl.modules;

import org.lwjgl.input.Keyboard;

import me.north.easybase.api.module.Category;
import me.north.easybase.api.module.Module;
import me.north.easybase.impl.clickgui.ClickGUIScreen;

//Initializes the ClickGUI
public class ClickGUI extends Module {

	public ClickGUI() {
		super("ClickGUI", "Initializes the ClickGUI", Category.CLIENT);
		this.setKey(Keyboard.KEY_RSHIFT);
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		mc.displayGuiScreen(ClickGUIScreen.INSTANCE);
		setToggled(false);
	}

}
