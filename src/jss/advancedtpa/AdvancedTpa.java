package jss.advancedtpa;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class AdvancedTpa extends JavaPlugin{
	
	private PluginDescriptionFile jss = getDescription();
	private static AdvancedTpa plugin;
	public String name = this.jss.getName();
	public String version = this.jss.getVersion();
	private String nmsversion;
	
	public void onEnable() {
        nmsversion = Bukkit.getServer().getClass().getPackage().getName();
        nmsversion = nmsversion.substring(nmsversion.lastIndexOf(".") + 1);
		plugin = this;
		loadNms(nmsversion);
	}
	
	public void onDisable() {

	}
	
	public void loadCommand() {
		
	}
	
	public void loadEvent() {
		
	}

	public static AdvancedTpa getPlugin() {
		return plugin;
	}
	@SuppressWarnings("unused")
	private  void loadNms(String nmsversion) {
		try {
			Class<?> clazz = Class.forName("jss.advancedtpa.utils.version" + "." + nmsversion + "." + "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
