package me.north.easybase.api.util;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.util.text.TextComponentString;

//Utilities for making things easier
public class Util implements Wrapper {
	
	public static void sendMessage(String message) {
		if (mc.player == null)
			return;
		mc.player.sendMessage(new TextComponentString(ChatFormatting.GRAY + "[EasyBase] " + ChatFormatting.RESET + message));
	}

}
