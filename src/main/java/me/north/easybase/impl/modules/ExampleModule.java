package me.north.easybase.impl.modules;

import org.lwjgl.input.Keyboard;

import com.mojang.realmsclient.gui.ChatFormatting;

import me.north.easybase.api.module.Category;
import me.north.easybase.api.module.Module;
import me.north.easybase.api.util.Util;

//Class that extends Module:
public class ExampleModule extends Module {

	//Constructor:
	public ExampleModule() {
		super("ExampleModule", "An example description", Category.CLIENT);
		
		//Keybind to toggle module:
		this.setKey(Keyboard.KEY_X);
	}
	
	//When module gets enabled:
	@Override
	public void onEnable() {
		System.out.println("ENABLED");
		Util.sendMsg(ChatFormatting.WHITE + this.name + ChatFormatting.GREEN + " enabled!");
	}
	
	//When module gets disabled:
	@Override
	public void onDisable() {
		System.out.println("DISABLED!");
		Util.sendMsg(ChatFormatting.WHITE + this.name + ChatFormatting.RED + " disabled!");
	}
	
	//When module updates:
	@Override
	public void onUpdate() {
		if(nullCheck())
			return;
		
	}

}
