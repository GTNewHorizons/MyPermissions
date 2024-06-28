package mypermissions.permission.core.bridge;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.permission.PermissionManager;

import myessentials.utils.PlayerUtils;

public class ForgeEssentialsPermissionBridge implements IPermissionBridge {

    @Override
    public boolean hasPermission(UUID uuid, String permission) {
        EntityPlayer player = PlayerUtils.getPlayerFromUUID(uuid);
        return PermissionManager.checkPermission(player, permission);
    }
}
