package me.north.easybase.impl.clickgui;

import java.awt.Color;
import java.util.ArrayList;

import me.north.easybase.api.module.Category;
import me.north.easybase.api.module.Module;
import me.north.easybase.api.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class Frame {
	
	ArrayList<Button> buttons = new ArrayList<>();
	
	Minecraft mc = Minecraft.getMinecraft();
	FontRenderer fr = Minecraft.getMinecraft().fontRenderer;
	
    public int x;
    public int y;
    public int width;
    public int height;
    public int barHeight;
    public Category category;
    
    public boolean isDragging;

    public int dragX;
    public int dragY;
	
    public Frame(Category category, int x, int y) {
        this.category = category;
        this.x = x;
        this.y = y;
        this.width = 98;
        this.height = 240;
        this.barHeight = 14;

        int offset = 0;
        for (Module m : ModuleManager.getModulesByCategory(category)) {
            offset += 15.5f;
            buttons.add(new Button(m, this, x ,y + offset, offset));
            
            this.height = offset;
        }
    }
    
    public boolean isWithin(int x, int y) {
        return x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.barHeight;
    }

    public void updatePosition(int mouseX, int mouseY, float partialTicks) {
        if (this.isDragging) {
            this.x = (mouseX - dragX);
            this.y = (mouseY - dragY);
            
        }
    }

    public void draw_frame(int mouseX, int mouseY, float partialTicks) {

        Gui.drawRect(x, y, x + width, y + height + 16, new Color(30, 30, 30, 200).getRGB());
		Gui.drawRect(x, y, x + width, y + barHeight, new Color(189, 25, 35).getRGB());

        fr.drawStringWithShadow(category.name, x + 2, y + 3, new Color(255, 255, 255).getRGB());
        
        for (Button b : buttons) {
            b.draw(mouseX,mouseY);
        }
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {

    	
        for (Button button : buttons) {
            button.mouseClicked(mouseX, mouseY, mouseButton);
        }
    } 

}
