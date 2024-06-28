package mypermissions.command.core.exception;

import net.minecraft.command.CommandException;

import mypermissions.MyPermissions;

public class PermissionCommandException extends CommandException {

    public PermissionCommandException(String localKey, Object... args) {
        super(
            MyPermissions.instance.LOCAL.getLocalization(localKey, args)
                .getUnformattedText());
    }
}
