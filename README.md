# spring-plugin-poc

### Goal (Completed!)

To see if I can register a spring bean from the `plugin-poc` project, in the `plugin-usage` spring boot application, via a dependency import only.

### Constraints

Get `plugin-poc\src\main\java\org\thirdpartyplugin\PluginController.java` to serve content...

- without changing the default `plugin-usage` project (i.e. no additional scan paths or bean config).
- with no knowledge of  the `plugin-usage`'s default package.

