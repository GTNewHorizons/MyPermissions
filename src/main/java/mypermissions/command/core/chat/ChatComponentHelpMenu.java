package mypermissions.command.core.chat;

import myessentials.chat.api.ChatComponentContainer;
import myessentials.chat.api.ChatComponentFormatted;
import myessentials.chat.api.ChatComponentMultiPage;
import myessentials.localization.api.LocalManager;
import mypermissions.command.core.entities.CommandTreeNode;

public class ChatComponentHelpMenu extends ChatComponentMultiPage {

    private CommandTreeNode command;

    public ChatComponentHelpMenu(int maxComponentsPerPage, CommandTreeNode command) {
        super(maxComponentsPerPage);
        this.command = command;
        this.construct();
    }

    public void construct() {

        for (CommandTreeNode subCommand : command.getChildren()) {
            this.add(
                new ChatComponentFormatted(
                    "{7| %s << %s}",
                    subCommand.getCommandLine(),
                    LocalManager.get(
                        subCommand.getAnnotation()
                            .permission() + ".help")));
        }

    }

    @Override
    public ChatComponentContainer getHeader(int page) {
        ChatComponentContainer header = super.getHeader(page);
        header.add(new ChatComponentFormatted("{9| - Command: }{9o|%s}", command.getLocalizedSyntax()));
        return header;
    }
}
