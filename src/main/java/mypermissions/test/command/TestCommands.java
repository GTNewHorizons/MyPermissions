package mypermissions.test.command;


import mypermissions.command.annotation.Command;
import net.minecraft.command.ICommandSender;

import java.util.List;

/**
 *
 */
public class TestCommands {

    public static boolean testPermBreach(String permission, ICommandSender sender) {
        return true;
    }

    @Command(
            name="test",
            permission="myessentials.test",
            syntax = "/test <command>")
    public static void testCommand(ICommandSender sender, List<String> args) {

    }

    @Command(
            name="sub",
            permission="myessentials.test.sub",
            parentName = "myessentials.test",
            syntax = "/test sub")
    public static void testSubCommand(ICommandSender server, List<String> args) {

    }

}
