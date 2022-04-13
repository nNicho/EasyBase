package me.north.easybase.api.module;

import org.lwjgl.input.Keyboard;

import me.north.easybase.api.clickgui.Toggleable;
import me.north.easybase.api.util.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

//Module base class
public class Module implements Wrapper, Toggleable {
	
	protected final Minecraft mc = Minecraft.getMinecraft();
	
	private String name;
	private String description;
	private int keybind;
	private Category category;
	private boolean toggled;
	
	public Module(String name, String description, Category category) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.toggled = false;
		this.keybind = Keyboard.KEY_NONE;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public int getKeybind() {
		return keybind;
	}
	
	public void setKeybind(int keybind) {
		this.keybind = keybind;
	}
	
	public boolean isToggled() {
		return toggled;
	}
	
	public void setToggled(boolean toggled) {
		this.toggled = toggled;
		
		if(this.toggled) {
			this.onEnable();
		}else {
			this.onDisable();
		}
	}
	
	public void toggle() {
		this.toggled = !this.toggled;
		
		if(this.toggled) {
			this.onEnable();
		}else {
			this.onDisable();
		}
	}
	
	public void onEnable() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public void onDisable() {
		MinecraftForge.EVENT_BUS.unregister(this);
	}
	
	public void onUpdate() {}
	
}
