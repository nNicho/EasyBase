package me.north.easybase.impl.clickgui;

import java.awt.Color;
import java.util.Collections;
import java.util.Comparator;

import me.north.easybase.api.module.Module;
import me.north.easybase.impl.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

//ClickGUI button class that can handle settings in the future
public class Button {
	
    public int x, y, width, height, offset;
    public Module module;
    public Frame parent;
    
    private boolean open;
    
	Minecraft mc = Minecraft.getMinecraft();
	FontRenderer fr = Minecraft.getMinecraft().fontRenderer;

    public Button(Module module, Frame parent, int x, int y, int offset) {
        this.x = x;
        this.y = y;
        this.offset = offset;
        this.width = 96;
        this.height = 14;
        this.module = module;
        this.parent = parent;
    }
    
	public static class ModuleComparator implements Comparator<Module> {
		
		@Override
		public int compare(Module arg0, Module arg1) {
			if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
				return -1;
			}
			if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
				return 1;
			}
			return 0;
		}
	}

    public void draw(int mouseX, int mouseY) {
    	Collections.sort(Main.INSTANCE.getModuleManager().modules, new ModuleComparator());
    	
		int color = module.toggled ? new Color(189, 25, 35).getRGB() : new Color(255, 255, 255).getRGB();
    	
		fr.drawStringWithShadow(module.name, parent.x + 2, parent.y + offset + 3f, color);
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
    	if(isWithin(mouseX, mouseY)) {
    		if(mouseButton == 0) {
    			module.toggle();
    		}
    		else if(mouseButton == 1) {
    			open = !open;
    		}
    	}
    }

    public boolean isWithin(int x, int y) {
        return x >= parent.x && x <= parent.x + width && y >= parent.y + this.offset && y <= parent.y + height + this.offset;
    }

}
