package me.north.easybase.impl.modules;

import org.lwjgl.input.Keyboard;

import com.mojang.realmsclient.gui.ChatFormatting;

import me.north.easybase.api.module.Category;
import me.north.easybase.api.module.Module;
import me.north.easybase.api.util.Util;

//Class that extends Module
public class ExampleModule extends Module {

	//Constructor
	public ExampleModule() {
		super("ExampleModule", "An example description", Category.CLIENT);
		
		//Keybind to toggle module
		this.setKeybind(Keyboard.KEY_NONE);
	}
	
	//When module gets enabled
	@Override
	public void onEnable() {
		Util.sendMessage(ChatFormatting.WHITE + this.getName() + ChatFormatting.GREEN + " enabled!");
	}
	
	//When module gets disabled
	@Override
	public void onDisable() {
		Util.sendMessage(ChatFormatting.WHITE + this.getName() + ChatFormatting.RED + " disabled!");
	}
	
	//When module updates
	@Override
	public void onUpdate() {
		if(nullCheck())
			return;
	}

}
