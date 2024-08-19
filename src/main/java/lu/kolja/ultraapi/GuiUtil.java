package lu.kolja.ultraapi;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.components.GuiAction;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import dev.triumphteam.gui.guis.PaginatedGui;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GuiUtil {



    public static GuiItem itemBuilder(Material material, String name, int amount, @Nullable List<String> lore, @Nullable Integer modelData, GuiAction<InventoryClickEvent> lambda) {
        ItemStack is = new ItemStack(material, amount);
        ItemMeta isMeta = is.getItemMeta();
        isMeta.setDisplayName(UltraAPI.chatFormatter(name));
        if (lore != null) isMeta.setLore(UltraAPI.chatFormatter(lore));
        if (modelData != null) isMeta.setCustomModelData(modelData);
        is.setItemMeta(isMeta);
        return ItemBuilder.from(is).asGuiItem(lambda);
    }

    public static Gui guiBuilder(TextComponent title, int rows) {
        return Gui.gui().title(title).rows(rows).create();
    }

    public static PaginatedGui pagedGuiBuilder(TextComponent title, int rows) {
        return Gui.paginated().title(title).rows(rows).create();
    }

}
