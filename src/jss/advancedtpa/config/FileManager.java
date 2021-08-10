package jss.advancedtpa.config;

import java.io.File;
import java.io.InputStream;

import org.bukkit.plugin.java.JavaPlugin;

import jss.advancedtpa.AdvancedTpa;
import jss.advancedtpa.utils.Logger;
import jss.advancedtpa.utils.Logger.Level;


public abstract class FileManager {

    private AdvancedTpa plugin;
    private Logger logger = new Logger(plugin);

    public FileManager(AdvancedTpa plugin) {
        this.plugin = plugin;
    }
	
    public void createVoidFolder(String name) {
        File folder = new File(getDataFolder(), name);
        if (!folder.exists()) {
            try {
                folder.mkdir();
            } catch (Exception e) {
            	logger.Log(Level.ERROR, "!!Error Load Folder!!");
                logger.Log(Level.ERROR, e.getStackTrace());
            }
        }
    }

    public void createFolderAndFile(String namefolder, String namefile) {
        File folder = new File(getDataFolder(), namefolder);
        if (!folder.exists()) {
            try {
                folder.mkdir();
            } catch (Exception e) {
            	logger.Log(Level.ERROR, "!!Error Load Folder!!");
                logger.Log(Level.ERROR, e.getStackTrace());
            }
        }

        File file = new File(folder, namefile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Deprecated
    public JavaPlugin getJavaPlugin() {
        return plugin;
    }

    public void saveResources(String filename, boolean replace) {
        plugin.saveResource(filename, replace);
    }

    public InputStream getResources(String filename) {
        return plugin.getResource(filename);
    }

    public File getDataFolder() {
        return plugin.getDataFolder();
    }
    
}
