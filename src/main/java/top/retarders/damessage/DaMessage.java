package top.retarders.damessage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;

public class DaMessage extends Plugin {
    private ServerPing serverPing;

    // clang-format off
    private static String[] messages = new String[] {
        "retarders > all",
        "sir,,,",
        "karekla",
        "freedom of speech is allowed here",
        "leave = slap",
        "petting my car rn"
    };
    // clang-format on

    @Override
    public void onEnable() {
        this.getProxy().getScheduler().schedule(this, () -> {
            String message = messages[(int) Math.floor(new Random().nextInt() * messages.length)];
            BaseComponent[] component = new ComponentBuilder("")
                                            .color(ChatColor.LIGHT_PURPLE)
                                            .bold(true)
                                            .append("Retarders Network")
                                            .color(ChatColor.GRAY)
                                            .append("- The Reconnaissance")
                                            .append("\n")
                                            .color(ChatColor.GRAY)
                                            .append("> " + message)
                                            .create();
            serverPing = new ServerPing();
            serverPing.setDescriptionComponent(component[0]);
        }, 3000, TimeUnit.MILLISECONDS);

        this.getProxy().getPluginManager().registerListener(this, new Listener() {
            @EventHandler
            public void onPing(ProxyPingEvent event) {
                event.setResponse(serverPing);
            }
        });
    }
}
