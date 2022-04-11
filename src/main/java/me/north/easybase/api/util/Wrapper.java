package me.north.easybase.api.util;


import net.minecraft.client.Minecraft;

//Global functions
public interface Wrapper {
	
    Minecraft mc = Minecraft.getMinecraft();

    default boolean nullCheck() {
        return mc.player == null || mc.world == null;
    }

}
