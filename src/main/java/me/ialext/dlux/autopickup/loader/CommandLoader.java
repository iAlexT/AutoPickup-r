package me.ialext.dlux.autopickup.loader;

import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.SimpleCommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilderImpl;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.annotated.part.SimplePartInjector;
import me.fixeddev.commandflow.annotated.part.defaults.DefaultsModule;
import me.fixeddev.commandflow.bukkit.BukkitAuthorizer;
import me.fixeddev.commandflow.bukkit.BukkitCommandManager;
import me.fixeddev.commandflow.bukkit.factory.BukkitModule;
import me.fixeddev.commandflow.translator.DefaultTranslator;
import me.ialext.dlux.autopickup.command.AutoPickupCommand;
import me.ialext.dlux.autopickup.flow.CustomTranslationProvider;
import team.unnamed.inject.Inject;

public class CommandLoader implements Loadable {

    @Inject
    private CustomTranslationProvider translationProvider;

    @Inject
    private AutoPickupCommand autoPickupCommand;

    @Override
    public void load() {
        registerCommands(
                autoPickupCommand
        );
    }

    private void registerCommands(CommandClass... commandClasses) {
        PartInjector injector = new SimplePartInjector();
        injector.install(new DefaultsModule());
        injector.install(new BukkitModule());

        AnnotatedCommandTreeBuilder builder = new AnnotatedCommandTreeBuilderImpl(injector);
        CommandManager manager = new BukkitCommandManager(new SimpleCommandManager(new BukkitAuthorizer()),
                "autopickup");
        manager.setTranslator(new DefaultTranslator(translationProvider));

        for(CommandClass commandClass : commandClasses) {
            manager.registerCommands(builder.fromClass(commandClass));
        }
    }
}
