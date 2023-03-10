package og.hlft.fabricatech.init;

import net.minecraft.block.MapColor;
import og.hlft.fabricatech.Fabricatech;
import og.hlft.fabricatech.common.materials.RMaterial;
import og.hlft.fabricatech.common.materials.RMaterialPart;

public class RMaterials {
    public static final RMaterial TIN = new RMaterial("tin").setChinese("锡").setColor(MapColor.LIGHT_BLUE_GRAY)
            .setParts(RMaterialPart.values());
    public static final RMaterial NICKEL = new RMaterial("nickel").setChinese("镍").setColor(MapColor.PALE_YELLOW)
            .setParts(RMaterialPart.values());
    public static final RMaterial LEAD = new RMaterial("lead").setChinese("铅").setColor(MapColor.PALE_PURPLE)
            .setParts(RMaterialPart.values());
    public static final RMaterial SILVER = new RMaterial("silver").setChinese("银").setColor(MapColor.LIGHT_GRAY)
            .setParts(RMaterialPart.values());
    public static final RMaterial IRON = new RMaterial("iron").setChinese("铁").setParts(RMaterialPart.vanilla());
    public static final RMaterial GOLD = new RMaterial("gold").setChinese("金").setParts(RMaterialPart.vanilla());
    public static final RMaterial COPPER = new RMaterial("copper").setChinese("铜").setParts(RMaterialPart.vanilla());

    public static void init() {
        Fabricatech.LOGGER.info("Fabricatech materials loading!");
    }

}
