package lu.kolja.ultraapi;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.components.GuiAction;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import dev.triumphteam.gui.guis.PaginatedGui;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public final class UltraAPI extends JavaPlugin {

    public static GuiItem guiItemBuilder(Material material, String name, int amount, @Nullable List<String> lore, @Nullable Integer modelData, GuiAction<InventoryClickEvent> lambda) {
        return GuiUtil.itemBuilder(material, name, amount, lore, modelData, lambda);
    }
    public static Gui guiBuilder(TextComponent title, int rows) {
        return GuiUtil.guiBuilder(title, rows);
    }
    public static PaginatedGui pagedGuiBuilder(TextComponent title, int rows) {
        return GuiUtil.pagedGuiBuilder(title, rows);
    }
    public static void clearFiller(Gui gui) {
        gui.getFiller().fill(ItemBuilder.from(Material.AIR).asGuiItem());
    }
    public static void clearFiller(PaginatedGui gui) {
        gui.getFiller().fillBorder(ItemBuilder.from(Material.AIR).asGuiItem());
    }
    public static String chatFormatter(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
    public static List<String> chatFormatter(List<String> text) {
        List<String> ret = new ArrayList<>();
        text.forEach(s -> ret.add(ChatColor.translateAlternateColorCodes('&', s)));
        return ret;
    }
    public static void registerEvents(Plugin pl, Listener... listener) {
        for (Listener l : listener) {
            pl.getServer().getPluginManager().registerEvents(l, pl);
        }
    }
}