package net.unestia.onevsone;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.SneakyThrows;
import net.unestia.api.UnestiaAPI;
import net.unestia.api.game.GameState;
import net.unestia.onevsone.countdown.StartCountdown;
import net.unestia.onevsone.game.kill.KillManager;
import net.unestia.onevsone.game.kit.KitManager;
import net.unestia.onevsone.listener.block.BlockBreakListener;
import net.unestia.onevsone.listener.block.BlockCanBuildListener;
import net.unestia.onevsone.listener.block.BlockPlaceListener;
import net.unestia.onevsone.listener.player.*;
import net.unestia.onevsone.listener.weather.WeatherChangeListener;
import net.unestia.onevsone.utils.scoreboard.Scoreboard;
import net.unestia.onevsone.utils.tablist.TabList;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Uprank
 * @date: 19.01.2021
 */

public class OneVsOne extends JavaPlugin {

    public static final String PREFIX = "§8» §b1vs1 §8❘ §r";

    @Getter
    private Gson gson;

    @Getter
    private KitManager kitManager;

    @Getter
    private Scoreboard scoreboard;

    @Getter
    private KillManager killManager;

    @Getter
    private StartCountdown startCountdown;

    @Getter
    private TabList tabList;

    @Getter
    private List<Location> locations = new ArrayList<>();

    @Getter
    private UnestiaAPI unestiaAPI;

    @Getter
    private World world;

    public OneVsOne() {
        this.gson = new Gson();
    }

    @Override
    @SneakyThrows
    public void onEnable() {
        File[] dependencies = new File("/home/minecraft/cloud/dependency/").listFiles();
        for (File dependency : dependencies) {
            Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            method.setAccessible(true);
            method.invoke(Thread.currentThread().getContextClassLoader(), dependency.toURI().toURL());
        }

        this.unestiaAPI = UnestiaAPI.getInstance();
        this.world = Bukkit.getWorld(this.unestiaAPI.getServerManager().getWorldManager().getWorld().getName());
        this.unestiaAPI.initialize();

        this.unestiaAPI.setGameState(GameState.LOBBY);

        this.tabList = new TabList();
        this.startCountdown = new StartCountdown(this);
        this.killManager = new KillManager(this);
        this.scoreboard = new Scoreboard(this);
        this.kitManager = new KitManager();
        this.initializeListener();
    }

    @Override
    public void onDisable() {
        /*Bukkit.getOnlinePlayers().forEach(players -> {
            players.kickPlayer(MessageFormat.format(this.getUnestiaAPI().getPlayerManager().getPlayer(players.getUniqueId()).getLanguage().getTranslations().get("restart_message"), OneVsOne.PREFIX));
        });*/
    }

    public void initializeListener(){
        // =============================================================================================================== //

        BlockBreakListener blockBreakListener = new BlockBreakListener(this);
        BlockCanBuildListener blockCanBuildListener = new BlockCanBuildListener(this);
        BlockPlaceListener blockPlaceListener = new BlockPlaceListener(this);

        // =============================================================================================================== //

        PlayerDeathListener playerDeathListener = new PlayerDeathListener(this);
        PlayerInteractListener playerInteractListener = new PlayerInteractListener(this);
        PlayerJoinListener playerJoinListener = new PlayerJoinListener(this);
        PlayerQuitListener playerQuitListener = new PlayerQuitListener(this);
        PlayerRespawnListener playerRespawnListener = new PlayerRespawnListener(this);

        // =============================================================================================================== //

        WeatherChangeListener weatherChangeListener = new WeatherChangeListener(this);

        // =============================================================================================================== //
    }

}
