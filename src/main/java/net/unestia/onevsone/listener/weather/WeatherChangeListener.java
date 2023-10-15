package net.unestia.onevsone.listener.weather;

import net.unestia.onevsone.OneVsOne;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

/**
 * @author: Uprank
 * @date: 19.01.2021
 */

public class WeatherChangeListener implements Listener {

    private final OneVsOne oneVsOne;

    public WeatherChangeListener(OneVsOne oneVsOne) {
        this.oneVsOne = oneVsOne;
        this.oneVsOne.getServer().getPluginManager().registerEvents(this, this.oneVsOne);
    }

    @EventHandler
    public void onWeatherChangeEvent(WeatherChangeEvent event) {
        event.setCancelled(true);
    }

}
