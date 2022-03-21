package me.north.easybase.api.module;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

//Module base class
public class Module {
	
	protected final Minecraft mc = Minecraft.getMinecraft();
	
	public String name;
	public String description;
	private int key;
	private Category category;
	public boolean toggled;
	
	public Module(String name, String description, Category category) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.toggled = false;
		this.key = Keyboard.KEY_NONE;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
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
	
	public String getName() {
		return this.name;
	}
	
	public Category getCategory() {
		return this.category;	
	}
	
	public boolean nullCheck() {
		return mc.player == null || mc.world == null;
	}
	
	public void onUpdate() {}
	
}
