package me.north.easybase.impl.clickgui;

import java.util.ArrayList;

import me.north.easybase.api.module.Category;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

public class ClickGUIScreen extends GuiScreen {
	
	ArrayList<Frame> frames = new ArrayList<>();
	
	Minecraft mc = Minecraft.getMinecraft();
	FontRenderer fr = Minecraft.getMinecraft().fontRenderer;
	ScaledResolution sr = new ScaledResolution(mc);
    
	
	public static ClickGUIScreen INSTANCE = new ClickGUIScreen();
	
	public ClickGUIScreen() {
        int offset = 0;
        for (Category c : Category.values()) {
            frames.add(new Frame(c, 20 + offset, 15));
            offset += 115;
        }
	}
	
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        for (Frame f : frames) {
            f.updatePosition(mouseX, mouseY, partialTicks);
            f.draw_frame(mouseX, mouseY, partialTicks);
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        for (Frame f : frames) {

            if (f.isWithin(mouseX, mouseY)) {
                f.isDragging = true;
                f.dragX = mouseX - f.x;
                f.dragY = mouseY - f.y;
            }

            f.mouseClicked(mouseX, mouseY, mouseButton);
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        for (Frame f : frames) {
            f.isDragging = false;
        }
    }

}
