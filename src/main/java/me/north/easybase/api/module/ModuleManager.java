package me.north.easybase.api.module;

import java.util.ArrayList;
import java.util.List;

import me.north.easybase.impl.Main;
import me.north.easybase.impl.modules.*;

//Manages modules
public class ModuleManager {
	
	public ArrayList<Module> modules;
	
	//Initialize modules here:
	public ModuleManager() {
		modules = new ArrayList<>();
		
		//COMBAT
		
		//MISC
		
		//MOVEMENT
		
		//PLAYER
		
		//RENDER
		
		//CLIENT
		modules.add(new ExampleModule());
		modules.add(new ClickGUI());
	}
	
	public Module getModuleName(String name) {
		for(Module m : this.modules) {
			if(m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Module> getModules() {
		return this.modules;
	}
	
	public static List<Module> getModulesByCategory(Category c) {
		List<Module> modules = new ArrayList<Module>();
		
		for(Module m : Main.INSTANCE.getModuleManager().modules) {
			if(m.getCategory() == c)
				modules.add(m);
		}
		return modules;
	}

}
