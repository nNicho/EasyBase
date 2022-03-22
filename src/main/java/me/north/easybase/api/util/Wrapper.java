package me.north.easybase.api.util;

import me.north.easybase.impl.Main;
import net.minecraft.client.Minecraft;

//Global functions
public interface Wrapper {
	
    Minecraft mc = Minecraft.getMinecraft();

    default boolean nullCheck() {
        return mc.player == null || mc.world == null;
    }

    default Main getMain() {
        return Main.INSTANCE;
    }

}
