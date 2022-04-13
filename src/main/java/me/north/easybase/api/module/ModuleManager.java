package me.north.easybase.api.module;

import java.util.ArrayList;

import me.north.easybase.impl.modules.*;

//Manages modules
public class ModuleManager {
	
	private ArrayList<Module> modules;
	
	//Initialize modules here
	public ModuleManager() {
		modules = new ArrayList<>();

		//
		modules.add(new ExampleModule());
		modules.add(new ClickGUI());
		//
		
		modules.sort(this::sortAlphabetically);
	}
	
	private int sortAlphabetically(Module module1, Module module2) {
		return module1.getName().compareTo(module2.getName());
	}
	
	public ArrayList<Module> getModules() {
		return this.modules;
	}
	
	public Module getModuleByName(String name) {
		for(Module m : this.modules) {
			if(m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Module> getModulesByCategory(Category c) {
		final ArrayList<Module> modulesList = new ArrayList<>();
		
		for(Module m : modules) {
			if(m.getCategory() == c)
				modulesList.add(m);
		}
		return modulesList;
	}

}
