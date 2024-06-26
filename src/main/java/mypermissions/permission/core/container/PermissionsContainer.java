package mypermissions.permission.core.container;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.util.IChatComponent;

import myessentials.chat.api.ChatComponentFormatted;
import myessentials.chat.api.ChatComponentList;
import myessentials.chat.api.IChatFormat;
import myessentials.localization.api.LocalManager;
import mypermissions.permission.core.entities.PermissionLevel;

public class PermissionsContainer extends ArrayList<String> implements IChatFormat {

    public PermissionLevel hasPermission(String permission) {
        PermissionLevel permLevel = PermissionLevel.NONE;
        if (contains(permission)) {
            permLevel = PermissionLevel.ALLOWED;
        }

        for (String p : this) {
            if (p.endsWith("*")) {
                if (permission.startsWith(p.substring(0, p.length() - 1))) {
                    permLevel = PermissionLevel.ALLOWED;
                } else if (p.startsWith("-") && permission.startsWith(p.substring(1, p.length() - 1))) {
                    permLevel = PermissionLevel.DENIED;
                }
            } else {
                if (permission.equals(p)) {
                    permLevel = PermissionLevel.ALLOWED;
                } else if (p.startsWith("-") && permission.equals(p.substring(1))) {
                    permLevel = PermissionLevel.DENIED;
                }
            }
        }

        return permLevel;
    }

    public boolean remove(String perm) {
        for (Iterator<String> it = iterator(); it.hasNext();) {
            String p = it.next();
            if (p.equals(perm)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public IChatComponent toChatMessage() {
        IChatComponent root = new ChatComponentList();
        root.appendSibling(
            LocalManager.get("myessentials.format.list.header", new ChatComponentFormatted("{9|PERMISSIONS}")));
        for (String perm : this) {
            root.appendSibling(LocalManager.get("mypermissions.format.permission", perm));
        }
        return root;
    }
}
