/**
 * This work is licensed under the Creative Commons
 * Attribution-ShareAlike 3.0 Unported License. To view a copy of this
 * license, visit http://creativecommons.org/licenses/by-sa/3.0/.
 */

package extrabiomes.handlers;

import net.minecraft.item.ItemStack;

import com.google.common.base.Optional;

import cpw.mods.fml.common.registry.GameRegistry;
import extrabiomes.Extrabiomes;
import extrabiomes.api.Stuff;
import extrabiomes.items.LogTurner;
import extrabiomes.lib.Element;
import extrabiomes.lib.ItemSettings;
import extrabiomes.lib.ModuleControlSettings;
import extrabiomes.lib.Reference;

public abstract class ItemHandler
{
    
    public static void createItems()
    {
        createLogTurner();
    }
    
    private static void createLogTurner()
    {
        final int itemID = ItemSettings.LOGTURNER.getID();
        if (!ModuleControlSettings.SUMMA.isEnabled() || itemID <= 0)
            return;
        
        final LogTurner logTurner = new LogTurner(itemID);
        
        Stuff.logTurner = Optional.of(logTurner);
        
        logTurner.setUnlocalizedName("extrabiomes.logturner").setCreativeTab(Extrabiomes.tabsEBXL);
        
        GameRegistry.registerItem(logTurner, "extrabiomes.logturner", Reference.MOD_ID);
        
        Element.LOGTURNER.set(new ItemStack(logTurner));
    }
    
}
