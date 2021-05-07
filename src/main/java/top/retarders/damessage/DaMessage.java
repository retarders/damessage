package top.retarders.damessage;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class DaMessage extends Plugin {
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
        this.getProxy().getPluginManager().registerListener(this, new Listener() {
            @EventHandler
            public void onPing(ProxyPingEvent event) {
                String message =
                    messages[(int) Math.floor(new Random().nextInt() * messages.length)];
                ServerPing serverPing = new ServerPing();
                serverPing.setDescription(
                    "&d&lRetarders Network &7- The Reconnaissance\n&7> " + message);
                event.setResponse(serverPing);
            }
        });
    }
}
